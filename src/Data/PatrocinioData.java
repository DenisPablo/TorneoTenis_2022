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
            System.out.println("Error en la conexion");
        }
    }
     public void guardarPatrocinio(Patrocinio patrocinio) {
         
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
                        Logger.getLogger(PatrocinioData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                    System.out.println("Patrocinio guardado con exito.");
                } catch (SQLException ex) {
                    System.out.println("Error al guardar Patrocinio "+ex);}}
                else
                    System.out.println("Solo se permiten 3 sponsor por jugador");
                } catch (ClassNotFoundException ex) {
                Logger.getLogger(PatrocinioData.class.getName()).log(Level.SEVERE, null, ex);
        }}
 
     public void modificadarPatrocicio (Patrocinio patrocinio) {
        String sql = "UPDATE patrocinio SET `idPatrocinio`=?,`idSponsor`=?,`idJugador`=?,`fechIniContrato`=?,`fechFinContrato`=?,`activo`=?,`indumentaria`=? Where `idPatrocinio`=?";
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
                System.out.println("Patrocinio modificada con exito.");
        }
        catch (SQLException ex){
                System.out.println("Error al actualizar Patrocinio: "+ex);
        }

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
                 System.out.println("Patrocinio no encontrado: " + ex);
             }
         }
        catch(ClassNotFoundException ex){
                Logger.getLogger(PatrocinioData.class.getName()).log(Level.SEVERE, null, ex);
        }
          return pat;
}   
     
      public void bajaPatrocinio (int id){
         String sql = "UPDATE patrocinio SET activo=? WHERE idPatrocinio=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            }
         catch(SQLException ex){
             System.out.println("Patrocinio no encontrado: " + ex);
            }
}   
      
      public void altaPatrocinio (int id){
          String sql = "UPDATE patrocinio SET activo=? WHERE idPatrocinio=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
         System.out.println("Patrocinio no encontrado: " + ex);
        }
}
      
      public void borrarPatrocinio(int id){
            String sql="DELETE FROM patrocinio WHERE idPatrocinio=?";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();

                System.out.println("Patrocinio borrado definitivamente");
            } 
            catch (SQLException ex) {
                 System.out.println("Error al borrar "+ex);
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
                System.out.println("No se encontraron resultados: "+ ex);
            }
            
        }
        catch(ClassNotFoundException ex){
                Logger.getLogger(PatrocinioData.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("No se encontraron resultados: "+ ex);
            }
            
        }
        catch(ClassNotFoundException ex){
                Logger.getLogger(PatrocinioData.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("No se encontraron resultados: "+ ex);
            }
            
        }
        catch(ClassNotFoundException ex){
                Logger.getLogger(PatrocinioData.class.getName()).log(Level.SEVERE, null, ex);
            }
        return resultados;
}
}
