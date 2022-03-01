/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Conexion;
import Modelo.Jugador;
import Modelo.Patrocinio;
import Modelo.Sponsor;
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
 * @author Romi
 */
public class PatrocinioData {
        private Connection con;

    public PatrocinioData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
     public boolean guardarPatrocinio(Patrocinio patrocinio) {
         boolean a = false;
            try {
                
                Conexion p=new Conexion();
                Jugador j=new Jugador();
                JugadorData jD=new JugadorData(p);
                PatrocinioData pd=new PatrocinioData(p);
                if(pd.buscarSponsordeJugador(j.getIdJugador()).size()<=3){
                String sql = "INSERT INTO `patrocinio`(`idPatrocinio`, `idSponsor`, `idJugador`, `fechIniContrato`, `fechFinContrato`, `activo`, `Indumentaria`) VALUES (?,?,?,?,?,?,?)";
                try {
                    
                    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    
                    
                    
                    //patrocinio.getJugador().setPuntaje( patrocinio.getJugador().getPuntaje() + 1);
                    
                    ps.setInt(1, patrocinio.getIdPatrocinio());
                    ps.setInt(2, patrocinio.getSponsor().getIdSponsor());
                    ps.setInt(3, patrocinio.getJugador().getIdJugador());
                    ps.setDate(4,Date.valueOf( patrocinio.getFechaInicioContrato()));
                    ps.setDate(5,Date.valueOf(  patrocinio.getFechaFinContrato()));
                    ps.setBoolean(6,patrocinio.isActivo());
                    ps.setString(7, patrocinio.getIndumentaria());
                    ps.executeUpdate();
                    
                    
                    Jugador j1 = new Jugador();
                    j1 = patrocinio.getJugador();
                    j1.setPuntaje( j1.getPuntaje() +1);
                    Conexion con;
                    try {
                        con = new Conexion();
                        JugadorData jd = new JugadorData(con);
                        jd.actualizarJugador(j1);
                        
                    } catch (ClassNotFoundException ex) {
                        a = false;
                    }
                    
                    
                    
                    a = true;
                } catch (SQLException ex) {
                    a = false;}}
                else
                   JOptionPane.showMessageDialog(null,"Solo se pueden agregar 3 sponsor:");
                } catch (ClassNotFoundException ex) {
                a = false;
        }
            return a;
     }
 
     public boolean modificadarPatrocicio (Patrocinio patrocinio) {
        String sql = "UPDATE patrocinio SET `idPatrocinio`=?,`idSponsor`=?,`idJugador`=?,`fechIniContrato`=?,`fechFinContrato`=?,`activo`=?,`indumentaria`=? Where `idPatrocinio`=?";
        boolean a;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patrocinio.getIdPatrocinio());
            ps.setInt(2, patrocinio.getSponsor().getIdSponsor());
            ps.setInt(3, patrocinio.getJugador().getIdJugador());
            ps.setDate(4,Date.valueOf( patrocinio.getFechaInicioContrato()));
            ps.setDate(5,Date.valueOf(  patrocinio.getFechaFinContrato()));
            ps.setBoolean(6,patrocinio.isActivo());
            ps.setString(7, patrocinio.getIndumentaria()); 
            ps.setInt(8, patrocinio.getIdPatrocinio());
            ps.executeUpdate();
            ps.close();
                a = true;
        }
        catch (SQLException ex){
                a = false;
        }
  return a;
 }
   
      public Patrocinio buscarPatrocinio (int ID){
        Patrocinio pat = new Patrocinio();
         try{
             Conexion p = new Conexion();
             SponsorData s=new SponsorData(p);
             Sponsor spon=new Sponsor();
             JugadorData j=new JugadorData(p);
             Jugador jug=new Jugador();
             String sql = "SELECT * FROM patrocinio Where idPatrocinio=?";
             try{
                 PreparedStatement ps = con.prepareStatement(sql);
                 ps.setInt(1, ID);
                 ResultSet rs = ps.executeQuery();
                 if(rs.next()) {
                     pat = new Patrocinio();
                     pat.setIdPatrocinio(rs.getInt(1));
                     spon=s.buscarSponsor(rs.getInt(2));
                     pat.setSponsor(spon);
                     jug=j.buscarJugador(rs.getInt(3));
                     pat.setJugador(jug);
                     pat.setFechaInicioContrato(rs.getDate(4).toLocalDate());
                     pat.setFechaFinContrato(rs.getDate(5).toLocalDate());
                     pat.setActivo(rs.getBoolean(6));
                     pat.setIndumentaria(rs.getString(7));
                     
                 }
             }
             catch(SQLException ex){
                 JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
             }
         }
        catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
          return pat;
}   
     
      public boolean bajaPatrocinio (int id){
          String sql = "UPDATE patrocinio SET activo=? WHERE idPatrocinio=?";
          boolean a;
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            
            a = true;
            }
         catch(SQLException ex){
             a = false;
            }
         return a;
}   
      
      public boolean altaPatrocinio (int id){
          String sql = "UPDATE patrocinio SET activo=? WHERE idPatrocinio=?";
          boolean a = false;
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
        a = false;
        }
         return a;
}
      
      public void borrarPatrocinio(int id){
            String sql="DELETE FROM patrocinio WHERE idPatrocinio=?";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();

                JOptionPane.showMessageDialog(null,"Patrocinio borrado con exito: ");
            } 
            catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
    }
    
      public List<Patrocinio> buscarTodosPatrocinio(){
          List<Patrocinio> resultados;
          resultados = new ArrayList<>();
        try{
            Conexion p = new Conexion();
            Patrocinio patrocinio= null;
            SponsorData s=new SponsorData(p);
            Sponsor spon=new Sponsor();
            JugadorData j=new JugadorData(p);
            Jugador jug=new Jugador();
            String sql = "SELECT * FROM patrocinio ";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    patrocinio=new Patrocinio();
                    patrocinio.setIdPatrocinio(rs.getInt(1));
                    spon=s.buscarSponsor(rs.getInt(2));
                    patrocinio.setSponsor(spon);
                    jug=j.buscarJugador(rs.getInt(3));
                    patrocinio.setJugador(jug);
                    patrocinio.setFechaInicioContrato(rs.getDate(4).toLocalDate());
                    patrocinio.setFechaFinContrato(rs.getDate(5).toLocalDate());
                    patrocinio.setActivo(rs.getBoolean(6));
                    patrocinio.setIndumentaria(rs.getString(7));
                    resultados.add(patrocinio);
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
      
     public List<Jugador> buscarJugadoresdeSponsor(int sp){
          List<Jugador> resultados;
          resultados = new ArrayList<>();
        try{
            Conexion p = new Conexion();
            JugadorData j=new JugadorData(p);
            Jugador jug=new Jugador();
            String sql = "SELECT idJugador FROM `patrocinio` WHERE idSponsor=?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, sp);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    jug=j.buscarJugador(rs.getInt(1));
                    resultados.add(jug);
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
    
     public List<Sponsor> buscarSponsordeJugador(int sp){
          List<Sponsor> resultados;
          resultados = new ArrayList<>();
        try{
            Conexion p = new Conexion();
            SponsorData s=new SponsorData(p);
            Sponsor spon=new Sponsor();
            String sql = "SELECT idSponsor FROM `patrocinio` WHERE  idJugador=?";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, sp);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    spon=s.buscarSponsor(rs.getInt(1));
                    resultados.add(spon);
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
     
     public List<Patrocinio> buscarActivos(){
         
          List<Patrocinio> resultados;
          resultados = new ArrayList<>();
        try{
            Conexion p = new Conexion();
            Patrocinio patrocinio= null;
            SponsorData s=new SponsorData(p);
            Sponsor spon=new Sponsor();
            JugadorData j=new JugadorData(p);
            Jugador jug=new Jugador();
            String sql = "SELECT * FROM patrocinio Where activo=true";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    patrocinio=new Patrocinio();
                    patrocinio.setIdPatrocinio(rs.getInt(1));
                    spon=s.buscarSponsor(rs.getInt(2));
                    patrocinio.setSponsor(spon);
                    jug=j.buscarJugador(rs.getInt(3));
                    patrocinio.setJugador(jug);
                    patrocinio.setFechaInicioContrato(rs.getDate(4).toLocalDate());
                    patrocinio.setFechaFinContrato(rs.getDate(5).toLocalDate());
                    patrocinio.setActivo(rs.getBoolean(6));
                    patrocinio.setIndumentaria(rs.getString(7));
                    resultados.add(patrocinio);
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
     
     public List<Patrocinio> buscarInactivos(){
          
         List<Patrocinio> resultados;
          resultados = new ArrayList<>();
        try{
            Conexion p = new Conexion();
            Patrocinio patrocinio= null;
            SponsorData s=new SponsorData(p);
            Sponsor spon=new Sponsor();
            JugadorData j=new JugadorData(p);
            Jugador jug=new Jugador();
            String sql = "SELECT * FROM patrocinio Where activo=false";
            try{
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    patrocinio=new Patrocinio();
                    patrocinio.setIdPatrocinio(rs.getInt(1));
                    spon=s.buscarSponsor(rs.getInt(2));
                    patrocinio.setSponsor(spon);
                    jug=j.buscarJugador(rs.getInt(3));
                    patrocinio.setJugador(jug);
                    patrocinio.setFechaInicioContrato(rs.getDate(4).toLocalDate());
                    patrocinio.setFechaFinContrato(rs.getDate(5).toLocalDate());
                    patrocinio.setActivo(rs.getBoolean(6));
                    patrocinio.setIndumentaria(rs.getString(7));
                    resultados.add(patrocinio);
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
