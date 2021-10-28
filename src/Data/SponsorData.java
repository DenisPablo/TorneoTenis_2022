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
            System.out.println("Error en la conexion");
        }
    }

    SponsorData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void guardarSponsor(Sponsor sponsor) {
     
            String sql = "INSERT INTO `sponsor`(`idPatrocinadores`, `marca`, `indumentaria`, `activo`) VALUES (?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(1, sponsor.getIdPatrocinadores());
                ps.setString(2, sponsor.getMarca());
                ps.setBoolean(3, sponsor.isActivo());
                ps.executeUpdate();
                
                System.out.println("Sposor guardado con exito.");
        } catch (SQLException ex) {
            System.out.println("Error al guardar Sponsor "+ex);
        }}
        
   public Sponsor buscarSponsor (int ID){
         Sponsor spon = new Sponsor();
         String sql = "SELECT * FROM sponsor Where idPatrocinadores=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, ID);
         ResultSet rs = ps.executeQuery();
         if(rs.next()) {
            spon = new Sponsor();
            spon.setIdPatrocinadores(rs.getInt(1));
            spon.setMarca(rs.getString(2));
            spon.setActivo(rs.getBoolean(3));
           
 
        }
        }
        catch(SQLException ex){
         System.out.println("Sponsor no encontrado: " + ex);
        }
        return spon;
}   
    public void modificadarSponsor (Sponsor s) {
        String sql = "UPDATE sponsor SET marca=? , activo=? Where idMateria=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,s.getMarca());
            ps.setBoolean(2, s.isActivo());
            ps.setInt(3, s.getIdPatrocinadores());

            ps.executeUpdate();
            ps.close();
                System.out.println("Materia modificada con exito.");
        }
        catch (SQLException ex){
                System.out.println("Error al actualizar materia: "+ex);
        }

 }
      public Sponsor bajaSponsor (int id){
         Sponsor spon = new Sponsor();
         String sql = "UPDATE sponsor SET activo=? WHERE idPatrocinadores=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
         System.out.println("Sponsor no encontrado: " + ex);
        }
        return spon;
}   
         public Sponsor altaSponsor (int id){
         Sponsor spon = new Sponsor();
         String sql = "UPDATE sponsor SET activo=? WHERE idPatrocinadores=?";
         try{
         PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
         System.out.println("Sponsor no encontrado: " + ex);
        }
        return spon;
}
      public void borrarSponsor(int id){
            String sql="DELETE FROM sponsor WHERE idPatrocinadores=?";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();

                System.out.println("Sponsor borrado definitivamente");
            } catch (SQLException ex) {
                 System.out.println("Error al borrar "+ex);
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
                 sponsor.setIdPatrocinadores(rs.getInt(1));
                 sponsor.setMarca(rs.getString(2));
                 sponsor.setActivo(rs.getBoolean(3));
                 resultados.add(sponsor);
            }
            ps.close();
            }
        catch(SQLException ex){
                System.out.println("No se encontraron resultados: "+ ex);
            }
        return resultados;
  }
    }


