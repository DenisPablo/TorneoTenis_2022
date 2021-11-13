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
       System.out.println("Error en la conexcion: "+ex);
    }
 }
    
    public void agregarEncuentro(Encuentro en){
    
     String sql = "INSERT INTO encuentro (`jugador1`, `jugador2`, `fechaEncuentro`, `resultado`, `jugadorGanador`, `estado`, `idEstadio`, `activo`, `idTorneo`) VALUES (?,?,?,?,?,?,?,?,?)";

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
         System.out.println("Encuentro Guardado con Exito");
     }
     catch (SQLException ex){
    System.out.println("Error al conectar con la base de datos: "+ex); 
    }

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
                en.setJugador1(j2);
                en.setFechaEncuentro(rs.getDate(4).toLocalDate());
                en.setResultado(rs.getString(5));
                j3 = jugadorData.buscarPorID(rs.getInt(6));
                en.setJugadorGanador(j3);
                en.setEstado(rs.getString(7));
                e1 = estadioData.bajaEstadio(rs.getInt(8));
                en.setEstadio(e1);
                en.setActivo(rs.getBoolean(9));
                t=torneoData.buscarTorneo(rs.getInt(10));
                en.setTorneo(t);
                
            }
        }
        catch(SQLException ex){
            System.out.println("Error al conectar la base de datos" + ex);
        }
        
    }
    catch(ClassNotFoundException ex){
            Logger.getLogger(EncuentroData.class.getName()).log(Level.SEVERE, null, ex);
    }
    return en;
}
    
    public void darBajaEncuentro(int id){
     String sql = "UPDATE encuentro SET activo=? WHERE idEncuentro=?";
        
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            
            System.out.println("Encuentro suspendido con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos. "+ex);
        }
    }
    
    public void darAltaEncuentro(int id){
        
    String sql = "UPDATE encuentro SET activo=? WHERE idEncuentro=?";
        
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            
            System.out.println("Encuentro activado con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos. "+ex);
        }
        
    }
    
    public void borrarEncuentro(int id){
    
        
     String sql="DELETE FROM encuentro WHERE idEncuentro=?";
     
      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
            System.out.println("Encuentro Borrada con exito.");
        } catch (SQLException ex) {
             System.out.println("Error al conectar con la base de datos.  "+ex);
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
        
        
        Conexion con1 = new Conexion();
        
        JugadorData jugadorData = new JugadorData(con1);
        EstadioData estadioData = new EstadioData(con1);
        
        

        
        String sql = "SELECT * FROM encuentro Where activo=true ";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                en.setIdEncuentro(rs.getInt("id"));
                
                j1 = jugadorData.buscarPorID(rs.getInt("Jugador1"));
                en.setJugador1(j1);
                
                j2 = jugadorData.buscarPorID(rs.getInt("Jugador2"));
                en.setJugador1(j2);
                
                j3 = jugadorData.buscarPorID(rs.getInt("JugadorGanador"));
                en.setJugadorGanador(j3);
                
                e1 = estadioData.bajaEstadio(rs.getInt("idEstadio"));
                en.setEstadio(e1);
                
                
                
                en.setFechaEncuentro(rs.getDate("fechaEncuentro").toLocalDate());
                en.setResultado(rs.getString("resultado"));
                en.setEstado("estado");
                
                
                en.setActivo(rs.getBoolean("activo"));

                resultados.add(en);
            }
            ps.close();
          
           
        }
        catch(SQLException ex){
            System.out.println("Error al conectar con la base de datos. "+ ex);
        }
    }
    catch(ClassNotFoundException ex){
            Logger.getLogger(EncuentroData.class.getName()).log(Level.SEVERE, null, ex);
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
     System.out.println("Encuentro Postergado con Exito");
 }
 catch (SQLException ex){
 System.out.println("Error al conectar con la base de datos: "+ex);
 }
}
    
    public void modificarEncuentro(Encuentro en){
    
        String sql = "UPDATE encuentro SET `jugador1`=?,`jugador2`=?,`fechaEncuentro`=?,`resultado`=?,`jugadorGanador`=?,`estado`=?,`idEstadio`=?,`activo`=?,`idTorneo`=? Where idEncuentro=?";
        
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

        System.out.println("Encuentro modificado con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos. " + ex);
        }
    
    
    }
    
    public void encuentroFinalizado(Jugador j,Encuentro en, String r) {
   
        try {
            int x=0;
            
            en.setEstado("Finalizado");
            en.setResultado(r);
            en.setJugadorGanador(j);
            
            Jugador jm = new Jugador();
            
            Conexion con1 =new Conexion();
            
            EncuentroData ed = new EncuentroData(con1);
            JugadorData   j1 = new JugadorData(con1);
            
            ed.modificarEncuentro(en);
            j.setPuntaje(j.getPuntaje() + 3);
            
            j1.actualizarJugador(j);
            
            String sql = "SELECT * FROM jugador ORDER BY jugador.puntaje DESC";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                while(rs.next() && rs.getInt(1) != j.getIdJugador()){
                 ++x;
                jm = j1.buscarJugador(rs.getInt(1));
                jm.setRanking(x);
                j1.actualizarJugador(jm);
             
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(EncuentroData.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EncuentroData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
      
    }
    
    public List<Encuentro> listarProximosEncuentros(LocalDate fecha){
        
        ArrayList<Encuentro> resultados = new ArrayList();
        
            try{
  
        Encuentro en = new Encuentro();
        
        Jugador j1 = new Jugador();
        Jugador j2 = new Jugador();
        Jugador j3 = new Jugador();
        Estadio e1 = new Estadio();
        
        
        Conexion con1 = new Conexion();
        
        JugadorData jugadorData = new JugadorData(con1);
        EstadioData estadioData = new EstadioData(con1);
        
        

        
        String sql = "SELECT * FROM encuentro Where encuentro.fecha >= fechaEncuentro=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            ps.setDate(1,Date.valueOf(LocalDate.now()));
             
            while(rs.next()){
                
               
                
                j1 = jugadorData.buscarPorID(rs.getInt("Jugador1"));
                en.setJugador1(j1);
                
                j2 = jugadorData.buscarPorID(rs.getInt("Jugador2"));
                en.setJugador1(j2);
                
                j3 = jugadorData.buscarPorID(rs.getInt("JugadorGanador"));
                en.setJugadorGanador(j3);
                
                e1 = estadioData.bajaEstadio(rs.getInt("idEstadio"));
                en.setEstadio(e1);
                
                
                
                en.setFechaEncuentro(rs.getDate("fechaEncuentro").toLocalDate());
                en.setResultado(rs.getString("resultado"));
                en.setEstado("estado");
                
                
                en.setActivo(rs.getBoolean("activo"));

                resultados.add(en);
            }
            ps.close();
          
           
        }
        catch(SQLException ex){
            System.out.println("Error al conectar con la base de datos. "+ ex);
        }
    }
    catch(ClassNotFoundException ex){
            Logger.getLogger(EncuentroData.class.getName()).log(Level.SEVERE, null, ex);
    }
        return resultados; 
    }
        
 }
