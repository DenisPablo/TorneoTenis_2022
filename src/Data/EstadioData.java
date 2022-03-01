/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Modelo.Conexion;
import Modelo.Estadio;
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
 * @author martinbordon
 */
public class EstadioData {
    private Connection con;
    
    public EstadioData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
    
     public EstadioData() {
        //To change body of generated methods, choose Tools | Templates.
    }
     
       public void guardarEstadio(Estadio estadio) {
     
            String sql = "INSERT INTO estadio(nombre,ciudad,categoria, activo, direComercial, dimension, estado) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setString(1, estadio.getNombre());
                ps.setString(2, estadio.getCiudad());
                ps.setString(3, estadio.getCategoria());
                ps.setBoolean(4, estadio.isActivo());
                ps.setString(5, estadio.getDireccionComercial());
                ps.setString(6, estadio.getDimension());
                ps.setBoolean(7, estadio.isEstado());
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Estadio guardo con exito: ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }
       
      public Estadio buscarEstadio (int ID){
         Estadio estadio = new Estadio();
         String sql = "SELECT * FROM estadio Where idEstadio=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, ID);
         ResultSet rs = ps.executeQuery();
         if(rs.next()) {
            estadio = new Estadio();
            estadio.setIdEstadio(rs.getInt(1));
            estadio.setNombre(rs.getString(2));
            estadio.setCiudad(rs.getString(3));
            estadio.setCategoria(rs.getString(4));
            estadio.setActivo(rs.getBoolean(5));
            estadio.setDireccionComercial(rs.getString(6));
            estadio.setDimension(rs.getString(7));
            estadio.setEstado(rs.getBoolean(8));
            
        }   
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        return estadio;
}     

      public void modificadarEstadio (Estadio e) {
        String sql = "UPDATE estadio SET `nombre`=?,`ciudad`=?,`categoria`=?,`activo`=?,`direComercial`=?,`dimension`=?,`estado`=?  Where idEstadio=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,e.getNombre());
            ps.setString(2,e.getCiudad());
            ps.setString(3, e.getCategoria());
            ps.setBoolean(4, e.isActivo());
            ps.setString(5, e.getDireccionComercial());
            ps.setString(6, e.getDimension());
            ps.setBoolean(7,e.isEstado());
            ps.setInt(8, e.getIdEstadio());

            ps.executeUpdate();
            ps.close();
              // JOptionPane.showMessageDialog(null,"Estadio modificado con exito: ");
        }
        catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
 }
       
       public Estadio bajaEstadio (int id){
         Estadio estadio = new Estadio();
         String sql = "UPDATE estadio SET activo=? WHERE idEstadio=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        return estadio;
}   
      
       public Estadio altaEstadio (int id){
         Estadio estadio = new Estadio();
         String sql = "UPDATE estadio SET activo=? WHERE idEstadio=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        return estadio;
    }
       
       
       public void borrarEstadio(int id){
            String sql="DELETE FROM estadio WHERE idEstadio=?";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();

              JOptionPane.showMessageDialog(null,"Estadio eliminado con exito: ");
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
    }
       
       
        public List<Estadio> buscarTodosEstadio(){
        List<Estadio> resultados;
        resultados = new ArrayList<>();
        Estadio estadio= null;
        String sql = "SELECT * FROM estadio ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                 estadio=new Estadio();
                 estadio.setIdEstadio(rs.getInt(1));
                 estadio.setNombre(rs.getString(2));
                 estadio.setCiudad(rs.getString(3));
                 estadio.setCategoria(rs.getString(4));
                 estadio.setActivo(rs.getBoolean(5));
                 estadio.setDireccionComercial(rs.getString(6));
                 estadio.setDimension(rs.getString(7));
                 estadio.setEstado(rs.getBoolean(8));
                 resultados.add(estadio);
            }
            ps.close();
            }
        catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
        return resultados;
  }

        public List<Estadio> buscarActivos(){
        List<Estadio> resultados;
        resultados = new ArrayList<>();
        Estadio estadio= null;
        String sql = "SELECT * FROM estadio Where activo=true and estado=false";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                 estadio=new Estadio();
                 estadio.setIdEstadio(rs.getInt(1));
                 estadio.setNombre(rs.getString(2));
                 estadio.setCiudad(rs.getString(3));
                 estadio.setCategoria(rs.getString(4));
                 estadio.setActivo(rs.getBoolean(5));
                 estadio.setDireccionComercial(rs.getString(6));
                 estadio.setDimension(rs.getString(7));
                 estadio.setEstado(rs.getBoolean(8));
                 resultados.add(estadio);
            }
            ps.close();
            }
        catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
        return resultados;
  }
        
        public List<Estadio> buscarInactivos(){
        List<Estadio> resultados;
        resultados = new ArrayList<>();
        Estadio estadio= null;
        String sql = "SELECT * FROM estadio Where activo=false";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                 estadio=new Estadio();
                 estadio.setIdEstadio(rs.getInt(1));
                 estadio.setNombre(rs.getString(2));
                 estadio.setCiudad(rs.getString(3));
                 estadio.setCategoria(rs.getString(4));
                 estadio.setActivo(rs.getBoolean(5));
                 estadio.setDireccionComercial(rs.getString(6));
                 estadio.setDimension(rs.getString(7));
                 estadio.setEstado(rs.getBoolean(8));
                 resultados.add(estadio);
            }
            ps.close();
            }
        catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
        return resultados;
  }
        
      public void modificarEstado(int id, boolean estado){
         Estadio estadio = new Estadio();
         String sql = "UPDATE estadio SET estado=? WHERE idEstadio=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }  
    }        
}
