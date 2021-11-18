/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Conexion;
import Modelo.Encuentro;
import Modelo.Estadio;
import Modelo.Jugador;
import Modelo.Sponsor;
import Modelo.Torneo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class EncuentroData {
    
    private Connection con;
    
    public EncuentroData(Conexion conexion ) {

     try {
        this.con = conexion.getConexion();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
 }
    
    public boolean agregarEncuentro(Encuentro en){
    
     String sql = "INSERT INTO encuentro (`jugador1`, `jugador2`, `fechaEncuentro`, `resultado`, `jugadorGanador`, `estado`, `idEstadio`, `activo`, `idTorneo`) VALUES (?,?,?,?,?,?,?,?,?)";
        boolean a;
     try{
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setObject(1,en.getJugador1().getIdJugador());
         ps.setObject(2, en.getJugador2().getIdJugador());
         ps.setDate(3, Date.valueOf(en.getFechaEncuentro()));
         ps.setString(4,en.getResultado());
         ps.setObject(5, en.getJugadorGanador().getIdJugador());
         ps.setString(6, en.getEstado());
         ps.setObject(7, en.getEstadio().getIdEstadio());
         ps.setBoolean(8, en.isActivo());
         ps.setObject(9, en.getTorneo().getIdTorneo());
        
         ps.executeUpdate();
         a = true;
     }
     catch (SQLException ex){
         a = false;
    }
       return a;
    }
    
    public Encuentro buscarEncuentro(int id){
      
       Encuentro en = new Encuentro();
        
    try{
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Jugador j3 = new Jugador();
        Estadio e1 = new Estadio();
        Torneo t =new Torneo();
        Conexion con1 = new Conexion();
        JugadorData jugadorData = new JugadorData(con1);
        EstadioData estadioData = new EstadioData(con1);
        TorneoData torneoData=new TorneoData(con1);
        String sql = "SELECT * FROM `encuentro` WHERE encuentro.idEncuentro=?";
        try{

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                en.setIdEncuentro(rs.getInt(1));
                j1 = jugadorData.buscarPorID(rs.getInt(2));
                en.setJugador1(j1);
                j2 = jugadorData.buscarPorID(rs.getInt(3));
                en.setJugador2(j2);
                en.setFechaEncuentro(rs.getDate(4).toLocalDate());
                en.setResultado(rs.getString(5));
                j3 = jugadorData.buscarPorID(rs.getInt(6));
                en.setJugadorGanador(j3);
                en.setEstado(rs.getString(7));
                e1 = estadioData.buscarEstadio(rs.getInt(8));
                en.setEstadio(e1);
                en.setActivo(rs.getBoolean(9));
                t=torneoData.buscarTorneo(rs.getInt(10));
                en.setTorneo(t);
                
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        
    }
    catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
    return en;
}
    
    public boolean darBajaEncuentro(int id){
    
         String sql = "UPDATE encuentro SET activo=? WHERE idEncuentro=?";
         boolean a;
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setBoolean(1, false);
             ps.setInt(2, id);
             ps.executeUpdate();
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
         }
          try {
         Conexion con1=new Conexion();
         Jugador j= new Jugador();
         JugadorData   j1 = new JugadorData(con1);
         j.setPuntaje(j.getPuntaje() + 3);
         
         j1.actualizarJugador(j);
         
         String sql1 = "SELECT * FROM jugador ORDER BY jugador.puntaje DESC";
         PreparedStatement ps;
         try {
             ps = con.prepareStatement(sql1);
             ResultSet rs = ps.executeQuery();
             int x=0;
             while(rs.next() && rs.getInt(1) != j.getIdJugador()){
                 ++x;
                 j= j1.buscarJugador(rs.getInt(1));
                 j.setRanking(x);
                 j1.actualizarJugador(j);
                 
             }
             
             a = true;
         } catch (SQLException ex) {
             a = false;
         }
        
     } catch (ClassNotFoundException ex) {
           a = false;
        }
          return a;
    }
    
    public boolean darAltaEncuentro(int id){
        
    
         String sql = "UPDATE encuentro SET activo=? WHERE idEncuentro=?";
         boolean a;
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setBoolean(1, true);
             ps.setInt(2, id);
             ps.executeUpdate();
             ps.close();
             a = true;
         } catch (SQLException ex) {
             a = false;
         }
          try {
         
         Conexion con1=new Conexion();
         Jugador j= new Jugador();
         JugadorData   j1 = new JugadorData(con1);
         j.setPuntaje(j.getPuntaje() - 3);
         
         j1.actualizarJugador(j);
         
         String sql1 = "SELECT * FROM jugador ORDER BY jugador.puntaje DESC";
         PreparedStatement ps;
         try {
             ps = con.prepareStatement(sql1);
             ResultSet rs = ps.executeQuery();
             int x=0;
             while(rs.next() && rs.getInt(1) != j.getIdJugador()){
                 ++x;
                 j= j1.buscarJugador(rs.getInt(1));
                 j.setRanking(x);
                 j1.actualizarJugador(j);
                 
             }
             
             
         } catch (SQLException ex) {
             a = false;
         }
         
     } catch (ClassNotFoundException ex) {
           a = false;
        }
        return a;
    }
    
    public void borrarEncuentro(int id){
    
        
     String sql="DELETE FROM encuentro WHERE idEncuentro=?";
     
      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
           JOptionPane.showMessageDialog(null,"Encuentro borrado con exito: ");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        
    }
    
    public List<Encuentro> devolverTodosEncuentros(){
    
        ArrayList<Encuentro> resultados = new ArrayList();
   
          try{
  
        Encuentro en = new Encuentro();
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Jugador j3 = new Jugador();
        Estadio e1 = new Estadio();
        Torneo t=new Torneo();
        Conexion con1 = new Conexion();
        JugadorData jugadorData = new JugadorData(con1);
        EstadioData estadioData = new EstadioData(con1);
        TorneoData td= new TorneoData(con1);
        String sql = "SELECT * FROM encuentro ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                en = new Encuentro();
                en.setIdEncuentro(rs.getInt(1));
                j1 = jugadorData.buscarPorID(rs.getInt(2));
                en.setJugador1(j1);
                j2 = jugadorData.buscarPorID(rs.getInt(3));
                en.setJugador2(j2);
                j3 = jugadorData.buscarPorID(rs.getInt(6));
                en.setJugadorGanador(j3);
                e1 = estadioData.buscarEstadio(rs.getInt(8));
                en.setEstadio(e1);
                en.setFechaEncuentro(rs.getDate(4).toLocalDate());
                en.setResultado(rs.getString(5));
                en.setEstado(rs.getString(7));
                en.setActivo(rs.getBoolean(9));
                t=td.buscarTorneo(rs.getInt(10));
                en.setTorneo(t);

                resultados.add(en);
            }
            ps.close();
          
           
        }
        catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
    catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
        return resultados; 
    }
    
    public void posponerEncuentro(int id, LocalDate fechEncuentro){
     String sql = "UPDATE encuentro SET fechaEncuentro=? Where idEncuentro=?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDate(1, Date.valueOf(fechEncuentro));
                ps.setInt(2, id);
                ps.executeUpdate();
                ps.close();
                
                JOptionPane.showMessageDialog(null,"Encuentro postuesto con exito: ");
                }
            catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
}
    
    public boolean modificarEncuentro(Encuentro en){
    
        String sql = "UPDATE encuentro SET `jugador1`=?,`jugador2`=?,`fechaEncuentro`=?,`resultado`=?,`jugadorGanador`=?,`estado`=?,`idEstadio`=?,`activo`=?,`idTorneo`=? Where idEncuentro=?";
        boolean a;
        try {
        PreparedStatement ps = con.prepareStatement(sql);
         ps.setObject(1,en.getJugador1().getIdJugador());
         ps.setObject(2, en.getJugador2().getIdJugador());
         ps.setDate(3, Date.valueOf(en.getFechaEncuentro()));
         ps.setString(4,en.getResultado());
         ps.setObject(5, en.getJugadorGanador().getIdJugador());
         ps.setString(6, en.getEstado());
         ps.setObject(7, en.getEstadio().getIdEstadio());
         ps.setBoolean(8, en.isActivo());
         ps.setObject(9, en.getTorneo().getIdTorneo());
         ps.setInt(10, en.getIdEncuentro());
         ps.executeUpdate();
         ps.close();

         a = true;
        } catch (SQLException ex) {
           a = false;
        }
    
    return a;
    }

    public List<Encuentro> listarProximosEncuentros(){
        
        ArrayList<Encuentro> resultados = new ArrayList();
        try{
            Encuentro en = new Encuentro();
            Jugador j1 = new Jugador();
            Jugador j2 = new Jugador();
            Jugador j3 = new Jugador();
            Estadio e1 = new Estadio();
            Conexion con1 = new Conexion();
            Torneo t = new Torneo();
            TorneoData torneoData= new TorneoData(con1);
            JugadorData jugadorData = new JugadorData(con1);
            EstadioData estadioData = new EstadioData(con1);
            String sql = "SELECT * FROM encuentro Where encuentro.fechaEncuentro >= ?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setDate(1,Date.valueOf(LocalDate.now()));
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    j1 = jugadorData.buscarPorID(rs.getInt("Jugador1"));
                    en.setJugador1(j1);
                    j2 = jugadorData.buscarPorID(rs.getInt("Jugador2"));
                    en.setJugador2(j2);
                    j3 = jugadorData.buscarPorID(rs.getInt("JugadorGanador"));
                    en.setJugadorGanador(j3);
                    e1 = estadioData.buscarEstadio(rs.getInt("idEstadio"));
                    en.setEstadio(e1);
                    en.setIdEncuentro(rs.getInt("idEncuentro"));
                    en.setFechaEncuentro(rs.getDate("fechaEncuentro").toLocalDate());
                    en.setResultado(rs.getString("resultado"));
                    en.setEstado("estado");
                    en.setActivo(rs.getBoolean("activo"));
                    t=torneoData.buscarTorneo(rs.getInt(10));
                     en.setTorneo(t);
                    resultados.add(en);
                }
                ps.close();
        }
        catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
    catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
        return resultados; 
    }
        
    public List<Encuentro> buscarPorFecha (LocalDate fecha){
    
     List<Encuentro> resultados = new ArrayList();
        try{
            Torneo t = new Torneo();
           
            Encuentro en = new Encuentro();
            Jugador j1 = new Jugador();
            Jugador j2 = new Jugador();
            Jugador j3 = new Jugador();
            Estadio e1 = new Estadio();
            Conexion con1 = new Conexion();
             TorneoData torneoData= new TorneoData(con1);
            JugadorData jugadorData = new JugadorData(con1);
            EstadioData estadioData = new EstadioData(con1);
        String sql = "SELECT * FROM `encuentro` WHERE fechaEncuentro=?";
        try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDate(1,Date.valueOf(fecha));
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    j1 = jugadorData.buscarPorID(rs.getInt("Jugador1"));
                    en.setJugador1(j1);
                    j2 = jugadorData.buscarPorID(rs.getInt("Jugador2"));
                    en.setJugador2(j2);
                    j3 = jugadorData.buscarPorID(rs.getInt("JugadorGanador"));
                    en.setJugadorGanador(j3);
                    e1 = estadioData.buscarEstadio(rs.getInt("idEstadio"));
                    en.setEstadio(e1);
                    en.setIdEncuentro(rs.getInt("idEncuentro"));
                    en.setFechaEncuentro(rs.getDate("fechaEncuentro").toLocalDate());
                    en.setResultado(rs.getString("resultado"));
                    en.setEstado("estado");
                    en.setActivo(rs.getBoolean("activo"));
                     t=torneoData.buscarTorneo(rs.getInt(10));
                     en.setTorneo(t);
                    resultados.add(en);
                }
                ps.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "el jugador  no ah jugado en ninguna cancha");
        }
    }
    catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
        return resultados; 
}
    
    public List<Torneo> buscarPorTorneo (int id){
    
         List<Torneo> resultados = new ArrayList();
        try{
            Encuentro en = new Encuentro();
            Jugador j1 = new Jugador();
            Jugador j2 = new Jugador();
            Jugador j3 = new Jugador();
            Torneo e1 = new Torneo();
            Conexion con1 = new Conexion();
            JugadorData jugadorData = new JugadorData(con1);
            TorneoData td = new TorneoData(con1);
            String sql = "SELECT idTorneo FROM encuentro Where Jugador1=? OR Jugador2=?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setInt(2, id);
               
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    e1 = td.buscarTorneo(rs.getInt("idTorneo"));
                    en.setTorneo(e1);
                    resultados.add(en.getTorneo());
                }
                ps.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "el jugador  no ah jugado en ninguna cancha");
        }
    }
    catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
        return resultados; 
    }
   
    public void calcularRankingPuntaje(){
        ArrayList<Jugador> resultados = new ArrayList();
        List<Sponsor> resulSponsor = new ArrayList();
         Encuentro en = new Encuentro();
        try{
            Jugador j1 = new Jugador();
            Jugador j2 = new Jugador();
            Jugador j3 = new Jugador();
            Estadio e1 = new Estadio();
            Torneo t =new Torneo();
            Conexion con1 = new Conexion();
            JugadorData jugadorData = new JugadorData(con1);
            EstadioData estadioData = new EstadioData(con1);
            TorneoData torneoData=new TorneoData(con1);
            PatrocinioData pd= new PatrocinioData(con1);
            String sql = "SELECT JugadorGanador FROM `encuentro` WHERE estado=?";
            try{
                
                PreparedStatement ps = con.prepareStatement(sql);
                 ps.setString(1, "Finalizado");
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    
                    j3 = jugadorData.buscarPorID(rs.getInt(1));
                    en.setJugadorGanador(j3);
                    resultados.add(j3);
                    
                }
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
            for (int i = 0; i < resultados.size(); i++) {
                j1=resultados.get(i);
                int contpuntaje=0;
                int contpatrocinios=0;
                j1.setPuntaje(0);
                for (int j = 0; j < resultados.size(); j++) {
                    if (j1.equals(resultados.get(j))){
                        contpuntaje++;
                        resulSponsor=pd.buscarSponsordeJugador(j1.getIdJugador());
                        contpatrocinios=resulSponsor.size();
                    }
                }
                 j1.setPuntaje(contpuntaje*3+contpatrocinios);
                 jugadorData.actualizarJugador(j3);
            }
            int x=0;
            String sql1 = "SELECT * FROM jugador ORDER BY jugador.puntaje DESC";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql1);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next()){
                 x++;
                j2 = jugadorData.buscarJugador(rs.getInt(1));
                j2.setRanking(x);
                jugadorData.actualizarJugador(j2);
                
                
                }
                JOptionPane.showMessageDialog(null,"Ranking actualizado con exito: ");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
            
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    
    
    
    
    }
    
    
     public List<Encuentro> devolverActivos(){
    
        ArrayList<Encuentro> resultados = new ArrayList();
   
          try{
  
        Encuentro en = new Encuentro();
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Jugador j3 = new Jugador();
        Estadio e1 = new Estadio();
        Torneo t=new Torneo();
        Conexion con1 = new Conexion();
        JugadorData jugadorData = new JugadorData(con1);
        EstadioData estadioData = new EstadioData(con1);
        TorneoData td= new TorneoData(con1);
        String sql = "SELECT * FROM encuentro Where activo=true";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                en = new Encuentro();
                en.setIdEncuentro(rs.getInt(1));
                j1 = jugadorData.buscarPorID(rs.getInt(2));
                en.setJugador1(j1);
                j2 = jugadorData.buscarPorID(rs.getInt(3));
                en.setJugador2(j2);
                j3 = jugadorData.buscarPorID(rs.getInt(6));
                en.setJugadorGanador(j3);
                e1 = estadioData.buscarEstadio(rs.getInt(8));
                en.setEstadio(e1);
                en.setFechaEncuentro(rs.getDate(4).toLocalDate());
                en.setResultado(rs.getString(5));
                en.setEstado(rs.getString(7));
                en.setActivo(rs.getBoolean(9));
                t=td.buscarTorneo(rs.getInt(10));
                en.setTorneo(t);

                resultados.add(en);
            }
            ps.close();
          
           
        }
        catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
    catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
        return resultados; 
    }
     
     public List<Encuentro> devolverInactivos(){
    
        ArrayList<Encuentro> resultados = new ArrayList();
   
          try{
  
        Encuentro en = new Encuentro();
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Jugador j3 = new Jugador();
        Estadio e1 = new Estadio();
        Torneo t=new Torneo();
        Conexion con1 = new Conexion();
        JugadorData jugadorData = new JugadorData(con1);
        EstadioData estadioData = new EstadioData(con1);
        TorneoData td= new TorneoData(con1);
        String sql = "SELECT * FROM encuentro Where activo=false";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                en = new Encuentro();
                en.setIdEncuentro(rs.getInt(1));
                j1 = jugadorData.buscarPorID(rs.getInt(2));
                en.setJugador1(j1);
                j2 = jugadorData.buscarPorID(rs.getInt(3));
                en.setJugador2(j2);
                j3 = jugadorData.buscarPorID(rs.getInt(6));
                en.setJugadorGanador(j3);
                e1 = estadioData.buscarEstadio(rs.getInt(8));
                en.setEstadio(e1);
                en.setFechaEncuentro(rs.getDate(4).toLocalDate());
                en.setResultado(rs.getString(5));
                en.setEstado(rs.getString(7));
                en.setActivo(rs.getBoolean(9));
                t=td.buscarTorneo(rs.getInt(10));
                en.setTorneo(t);

                resultados.add(en);
            }
            ps.close();
          
           
        }
        catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
    catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
        return resultados; 
    }
    }
    



