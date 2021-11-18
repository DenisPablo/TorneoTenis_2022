/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Conexion;
import Modelo.Encuentro;
import Modelo.Jugador;
import Modelo.Sponsor;
import Modelo.Torneo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class TorneoData {
    
     private Connection con;
     
     public TorneoData(Conexion conexion ) {

     try {
        con = conexion.getConexion();
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
 }
     
     public void agregarTorneo(Torneo t){
     
      String sql = "INSERT INTO torneo (nombre,fechaNacInicio,fechaNacFinal,activo) VALUES (?,?,?,?)";

     try{
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setObject(1,t.getNombre());
        ps.setObject(2,t.getFechaNacInicio());
        
         ps.setDate(3, Date.valueOf(t.getFehcaNacFinal()));
         ps.setBoolean(4,t.isActivo());
        
         ps.executeUpdate();
         JOptionPane.showMessageDialog(null,"Torneo agregado con exito: ");
     }
     catch (SQLException ex){
    JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }

     }
    
     public Torneo buscarTorneo(int id){
     
       Torneo t = new Torneo();
    
    String sql = "SELECT * FROM torneo Where idTorneo=?";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {

        t.setIdTorneo(rs.getInt("idTorneo"));
        t.setNombre(rs.getNString("nombre"));
        t.setFechaNacInicio(rs.getDate("fechaNacInicio").toLocalDate());
        t.setFehcaNacFinal(rs.getDate("fechaNacFinal").toLocalDate());
        t.setActivo(rs.getBoolean("activo"));
        
      
       }
    }
    catch(SQLException ex){
       JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
    
    return t;
}  
     
     public void modificadarTorneo (Torneo t) {
        String sql = "UPDATE `torneo` SET `nombre`=?,`fechaNacInicio`=?,`fechaNacFinal`=?,`activo`=? WHERE idTorneo=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,t.getNombre());
            ps.setDate(2, Date.valueOf(t.getFechaNacInicio()));
            ps.setDate(3, Date.valueOf(t.getFehcaNacFinal()));
            ps.setBoolean(4, t.isActivo());
            ps.setInt(5, t.getIdTorneo());

            ps.executeUpdate();
            ps.close();
                JOptionPane.showMessageDialog(null,"Torneo modificado con exito: ");
        }
        catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }

 }
     
     public void darBajaTorneo(int id){
     
        String sql = "UPDATE torneo SET activo=? WHERE idTorneo=?";
        
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Toreno dado de baja con exito: ");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
     
     public void darAltaTorneo(int id){
     
         String sql = "UPDATE torneo SET activo=? WHERE idTorneo=?";
        
     try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Torneo dado de alta con exito: ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
     
     }
     
     public void borrarTorneo(int id){
     
           String sql="DELETE FROM torneo WHERE idTorneo=?";
     
      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null,"Torneo borrado con exito: ");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        
    }
     
     public List<Torneo> devolverTodosTorneos(){
     
    List<Torneo> resultados = new ArrayList();
    Torneo t = null;
    String sql = "SELECT * FROM torneo ";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
      while(rs.next()){
          t = new Torneo();
        t.setIdTorneo(rs.getInt("idTorneo"));
        t.setNombre(rs.getNString("nombre"));
        t.setFechaNacInicio(rs.getDate("fechaNacInicio").toLocalDate());
        t.setFehcaNacFinal(rs.getDate("fechaNacFinal").toLocalDate());
        t.setActivo(rs.getBoolean("activo"));
        resultados.add(t);
         
    }
    ps.close();
    }
    catch(SQLException ex){
   JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
    return resultados;
    }
   
     public List<Jugador> listarJugadoresDeTorneo(int id){
      
            ArrayList<Jugador> resultados = new ArrayList();
            
            Jugador jugador=null;
            String sql = "SELECT * FROM encuentro Where idTorneo=?";
         
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs =ps.executeQuery();
             if(rs.next()){
         
             jugador=new Jugador();
             jugador.setIdJugador(rs.getInt(1));
             jugador.setNombre(rs.getString(2));
             jugador.setDni(rs.getInt(3));
             jugador.setFechaNac(rs.getDate(4).toLocalDate());
             jugador.setAltura(rs.getDouble(5));
             jugador.setPeso(rs.getDouble(6));
             jugador.setEstilo(rs.getString(7));
             jugador.setManoHabil(rs.getString(8));
             jugador.setTorneoGanados(rs.getInt(9));
             jugador.setRanking(rs.getInt(10));
             jugador.setPuntaje(rs.getInt(11));
             jugador.setActivo(rs.getBoolean(12));
             
             resultados.add(jugador);
             }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    
         return resultados;
        
     }
     
     public List<Torneo> devolverActivos(){
     
    List<Torneo> resultados = new ArrayList();
    Torneo t = null;
    String sql = "SELECT * FROM torneo Where activo=true";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
      while(rs.next()){
          t = new Torneo();
        t.setIdTorneo(rs.getInt("idTorneo"));
        t.setNombre(rs.getNString("nombre"));
        t.setFechaNacInicio(rs.getDate("fechaNacInicio").toLocalDate());
        t.setFehcaNacFinal(rs.getDate("fechaNacFinal").toLocalDate());
        t.setActivo(rs.getBoolean("activo"));
        resultados.add(t);
         
    }
    ps.close();
    }
    catch(SQLException ex){
   JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
    }
    return resultados;
    }
     
     }
     

     
    

