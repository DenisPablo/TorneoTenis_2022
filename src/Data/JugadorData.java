/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Conexion;
import Modelo.Jugador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martinbordon
 */
public class JugadorData {
    private Connection con;
    
    public JugadorData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    }
    
     public JugadorData() {
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public void guardarJugador(Jugador jugador) {
     
            String sql = "INSERT INTO jugador(nombre,dni,fechaNac,altura,peso,estilo,manoHabil,torneosGanados, ranking, puntaje, activo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, jugador.getNombre());
                ps.setInt(2, jugador.getDni());
                ps.setDate(3, Date.valueOf(jugador.getFechaNac()));
                ps.setDouble(4, jugador.getAltura());
                ps.setDouble(5, jugador.getPeso());
                ps.setString(6, jugador.getEstilo());
                ps.setString(7, jugador.getManoHabil());
                ps.setInt(8, jugador.getTorneoGanados());
                ps.setInt(9, jugador.getRanking());
                ps.setInt(10, jugador.getPuntaje());
                ps.setBoolean(11, jugador.isActivo());
                ps.executeUpdate();
                
                System.out.println("Jugador guardado con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar "+ex);
        }
    }
    
    
     public void borrarJugador(int id){
      String sql="DELETE FROM jugador WHERE idJugador=?";
      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            
            System.out.println("Jugador borrado definitivamente");
        } catch (SQLException ex) {
             System.out.println("Error al borrar "+ex);
        }  
    }
    
       public List<Jugador> buscarTodosJugadores(){
    List<Jugador> resultados;
        resultados = new ArrayList<>();
        Jugador jugador= null;
        String sql = "SELECT * FROM jugador ";
    try{
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    while(rs.next()){
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
    ps.close();
    }
    catch(SQLException ex){
        System.out.println("No se encontraron resultados: "+ ex);
    }
return resultados;

  }
    
       public Jugador buscarPorID (int ID){
        Jugador jugador = new Jugador();
       String sql = "SELECT * FROM jugador Where idJugador=?";
       try{
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, ID);
       ResultSet rs = ps.executeQuery();
       if(rs.next()) {
        jugador = new Jugador();


             jugador.setIdJugador(rs.getInt("idJugador"));
             jugador.setNombre(rs.getString("nombre"));
             jugador.setDni(rs.getInt("dni"));
             jugador.setFechaNac(rs.getDate("fechaNac").toLocalDate());
             jugador.setAltura(rs.getDouble("altura"));
             jugador.setPeso(rs.getDouble("peso"));
             jugador.setEstilo(rs.getString("estilo"));
             jugador.setManoHabil(rs.getString("manoHabil"));
             jugador.setTorneoGanados(rs.getInt("torneosGanados"));
             jugador.setRanking(rs.getInt("ranking"));
             jugador.setPuntaje(rs.getInt("puntaje"));
             jugador.setActivo(rs.getBoolean("activo"));

       }
       }
       catch(SQLException ex){
        System.out.println("Jugador no encontrado: " + ex);
       }
       return jugador;
       }
       

       
    public void desactivarJugador(int id){
    String sql = "UPDATE jugador SET activo=? WHERE idJugador=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            
            System.out.println("Jugador dado de baja con exito");
        } catch (SQLException ex) {
            System.out.println("Error al desactivar "+ex);
        }
    }
    
        
    public void activarJugador(int id){
        String sql = "UPDATE jugador SET activo=? WHERE idJugador=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1,true);
            ps.setInt(2, id);
            ps.executeUpdate();
            
            System.out.println("Jugador dado de alta nuevamente con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al desactivar "+ex);
        }
    }
        
        
     public Jugador buscarJugador(int id){
         Jugador jugador=null;
         String sql = "SELECT * FROM jugador Where idJugador= ?";
         
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
             }
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener la busqueda de jugador"+ex);
        }
    
         return jugador;
         
  }
        
        
     public void actualizarJugador(Jugador jugador){
        String sql = "UPDATE jugador SET nombre=?, dni=?, fechaNac=?, altura=?, peso=?, estilo=?, manoHabil=? ,torneosGanados=?, ranking=?, puntaje=?, activo=? Where idJugador=?";

        try {
        PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, jugador.getNombre());
                ps.setInt(2, jugador.getDni());
                ps.setDate(3, Date.valueOf(jugador.getFechaNac()));
                ps.setDouble(4, jugador.getAltura());
                ps.setDouble(5, jugador.getPeso());
                ps.setString(6, jugador.getEstilo());
                ps.setString(7, jugador.getManoHabil());
                ps.setInt(8, jugador.getTorneoGanados());
                ps.setInt(9, jugador.getRanking());
                ps.setInt(10, jugador.getPuntaje());
                ps.setBoolean(11, jugador.isActivo());
                ps.setInt(12, jugador.getIdJugador());

        ps.executeUpdate();
        ps.close();

        System.out.println("Jugador modificado con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos. " + ex);
        }

   }
     
     public List<Jugador> buscarJugadorPorNombre (String nombre){
        List<Jugador> resultados;
        resultados = new ArrayList<>();
        Jugador jugador = new Jugador() ;
        String sql = "SELECT * FROM jugador Where nombre like '%" + nombre + "%'";
        try{
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
          while(rs.next()){
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
        ps.close();
        }
        catch(SQLException ex){
        System.out.println("No se encontraron resultados: "+ ex);
        }
        return resultados;
    }

     
     public List<Jugador> listarPuntajeDeJugadores(){
     
        List<Jugador> resultados;
        resultados = new ArrayList<>();
        Jugador jugador = new Jugador() ;
        String sql = "SELECT idJugador,nombre,puntaje FROM jugador Where activo=true";
        try{
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
          while(rs.next()){
             jugador.setIdJugador(rs.getInt(1));
             jugador.setNombre(rs.getString(2));
             jugador.setPuntaje(rs.getInt(11));
             

             resultados.add(jugador);
        }
        ps.close();
        }
        catch(SQLException ex){
        System.out.println("No se encontraron resultados: "+ ex);
        }
        return resultados;
    }
     
    
}


