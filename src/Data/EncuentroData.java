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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pablo
 */
public class EncuentroData {
    
    private Connection con;
    
    public EncuentroData(Conexion conexion ) {

     try {
        con = conexion.getConexion();
    } catch (SQLException ex) {
       System.out.println("Error en la conexcion: "+ex);
    }
 }
    
    public void agregarEncuentro(Encuentro en){
    
     String sql = "INSERT INTO encuentro (jugador1,jugador2,fechaEncuentro,resultado,jugadorGanador,estado,IdEstadio,activo) VALUES (?,?,?,?,?,?,?,?)";

     try{
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setObject(1,en.getJugador1());
        ps.setObject(2, en.getJugador2());
        
         ps.setDate(3, Date.valueOf(en.getFechaEncuentro()));
         ps.setInt(4,en.getResultado());
         ps.setObject(5, en.getJugadorGanador());
         
         ps.setString(6, en.getEstado());
         ps.setObject(7, en.getIdEstadio());
         ps.setBoolean(8, en.isActivo());
        
         ps.executeUpdate();
         System.out.println("Encuentro Guardado con Exito");
     }
     catch (SQLException ex){
    System.out.println("Error al conectar con la base de datos: "+ex); 
    }

    }
    
    public Encuentro buscarEncuentro(int id){
    
    Encuentro en = new Encuentro();
    
    String sql = "SELECT * FROM encuentro Where idEncuentro=?";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            en = new Encuentro();

        en.setIdPartido(rs.getInt("idPatido"));
        
        //Busca Jugador 1 y 2 pasando el ID y lo settea. 
        en.setJugador1(rs.getObject(jugadorData.buscarjugador(rs.getInt("idJugador1")), Jugador));
        en.setJugador2(rs.getObject(jugadorData.buscarjugador(rs.getInt("idJugador2")), Jugador));
 
        en.setFechaEncuentro(rs.getDate("fechaEncuentro").toLocalDate());
        en.setResultado(rs.getInt("resultado"));
        en.setJugadorGanador(rs.getObject(jugadorData.buscarjugador(rs.getInt("jugadorGanador")), Jugador));
        en.setEstado("estado");
        
        en.setIdEstadio(rs.getObject(EstadioData.buscarEstadio(rs.getInt("idEstadio"), Estadio);
        en.setActivo(rs.getBoolean("activo"));
       }
    }
    catch(SQLException ex){
        System.out.println("Error al conectar la base de datos" + ex);
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
       
    resultados = new ArrayList<>();
    Encuentro en = new Encuentro();
    String sql = "SELECT * FROM encuentro Where activo=true ";
    
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
      while(rs.next()){
        
        en.setJugador1(rs.getObject(jugadorData.buscarjugador(rs.getInt("idJugador1")), Jugador));
        en.setJugador2(rs.getObject(jugadorData.buscarjugador(rs.getInt("idJugador2")), Jugador));
 
        en.setFechaEncuentro(rs.getDate("fechaEncuentro").toLocalDate());
        en.setResultado(rs.getInt("resultado"));
        en.setJugadorGanador(rs.getObject(jugadorData.buscarjugador(rs.getInt("jugadorGanador")), Jugador));
        en.setEstado("estado");
        
        en.setIdEstadio(rs.getObject(EstadioData.buscarEstadio(rs.getInt("idEstadio"), Estadio);
        en.setActivo(rs.getBoolean("activo"));

    resultados.add(en);
    }
    ps.close();
    }
    catch(SQLException ex){
    System.out.println("Error al conectar con la base de datos. "+ ex);
    }
    
    return resultados;
    }
    
    public void posponerEncuentro(int id, LocalDate fechEncuentro){
     String sql = "UPDATE materia SET fechaEncuentro=? Where idMateria=idEncuentro=?";
     
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
    
}