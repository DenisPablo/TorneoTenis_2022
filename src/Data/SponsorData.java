/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Conexion;
import Modelo.Sponsor;
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
 * @author Romi
 */
public class SponsorData {
      private Connection con;

    public SponsorData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
    }

    
     public void guardarSponsor(Sponsor sponsor) {
     
            String sql = "INSERT INTO `sponsor`(`idSponsor`, `marca`, `activo`) VALUES (?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, sponsor.getIdSponsor());
                ps.setString(2, sponsor.getMarca());
                ps.setBoolean(3, sponsor.isActivo());
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Sponsor guardado con exito: ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }}
        
   public Sponsor buscarSponsor (int ID){
         Sponsor spon = new Sponsor();
         String sql = "SELECT * FROM sponsor Where idSponsor=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, ID);
         ResultSet rs = ps.executeQuery();
         if(rs.next()) {
            spon = new Sponsor();
            spon.setIdSponsor(rs.getInt(1));
            spon.setMarca(rs.getString(2));
            spon.setActivo(rs.getBoolean(3));
           
 
        }
        }
        catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        return spon;
}   
   
    public void modificadarSponsor (Sponsor s) {
        String sql = "UPDATE sponsor SET marca=?,activo=? Where idSponsor=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,s.getMarca());
            ps.setBoolean(2, s.isActivo());
            ps.setInt(3, s.getIdSponsor());

            ps.executeUpdate();
            ps.close();
                JOptionPane.showMessageDialog(null,"Sponsor modificado con exito: ");
        }
        catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }

 }
    
      public Sponsor bajaSponsor (int id){
         Sponsor spon = new Sponsor();
         String sql = "UPDATE sponsor SET activo=? WHERE idSponsor=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Sponsor borrado con exito: ");
        }
         
        catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        return spon;
}   
      
      public Sponsor altaSponsor (int id){
         Sponsor spon = new Sponsor();
         String sql = "UPDATE sponsor SET activo=? WHERE idSponsor=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null,"Dado de alta con exito: "); 
        }
         
        catch(SQLException ex){
         JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
        }
        return spon;
}
         
      public void borrarSponsor(int id){
            String sql="DELETE FROM sponsor WHERE idSponsor=?";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();

                JOptionPane.showMessageDialog(null,"Sponsor borrado con exito: ");
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
    }
      
     public List<Sponsor> buscarTodosSposor(){
        List<Sponsor> resultados;
        resultados = new ArrayList<>();
        Sponsor sponsor= null;
        String sql = "SELECT * FROM sponsor ";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                 sponsor=new Sponsor();
                 sponsor.setIdSponsor(rs.getInt(1));
                 sponsor.setMarca(rs.getString(2));
                 sponsor.setActivo(rs.getBoolean(3));
                 resultados.add(sponsor);
            }
            ps.close();
            }
        catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
        return resultados;
  }
     
     public List<Sponsor> buscarActivos(){
        List<Sponsor> resultados;
        resultados = new ArrayList<>();
        Sponsor sponsor= null;
        String sql = "SELECT * FROM sponsor Where activo=true";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                 sponsor=new Sponsor();
                 sponsor.setIdSponsor(rs.getInt(1));
                 sponsor.setMarca(rs.getString(2));
                 sponsor.setActivo(rs.getBoolean(3));
                 resultados.add(sponsor);
            }
            ps.close();
            }
        catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
        return resultados;
  }
     
     public List<Sponsor> buscarInactivos(){
         
        List<Sponsor> resultados;
        resultados = new ArrayList<>();
        Sponsor sponsor= null;
        String sql = "SELECT * FROM sponsor Where activo=false";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        while(rs.next()){
                 sponsor=new Sponsor();
                 sponsor.setIdSponsor(rs.getInt(1));
                 sponsor.setMarca(rs.getString(2));
                 sponsor.setActivo(rs.getBoolean(3));
                 resultados.add(sponsor);
            }
            ps.close();
            }
        catch(SQLException ex){
               JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" + ex);
            }
        return resultados;
  }
    }


