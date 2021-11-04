/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Conexion;
import Modelo.Sponsor;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Romi
 */
public class Main {
      public static void main(String[] args) {
          
//Guardar Sponsor          
//          try {
//              Conexion con = new Conexion();
//              
//              SponsorData sponD = new SponsorData(con);
//              Sponsor spon = new Sponsor("Adidas",true); 
//              Sponsor spon1 = new Sponsor("Nike",true);
//              sponD.guardarSponsor(spon);
//              sponD.guardarSponsor(spon1);
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//Buscar Sponsor
    try {
              Conexion con = new Conexion();
              
              SponsorData sponD = new SponsorData(con);
              Sponsor spon =sponD.buscarSponsor(2);
              System.out.println(spon.toString());
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
//modificar Sponsor
        try {
              Conexion con = new Conexion();
              
              SponsorData sponD = new SponsorData(con);
              Sponsor spon = new Sponsor(2,"Adidas2",true); 
              sponD.modificadarSponsor(spon);
              Sponsor spon1 =sponD.buscarSponsor(2);
              System.out.println(spon1.toString());
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
 //Desactivar y activar
 try {
              Conexion con = new Conexion();
              
              SponsorData sponD = new SponsorData(con);
              sponD.bajaSponsor(2);
              Sponsor spon1 =sponD.buscarSponsor(2);
              System.out.println(spon1.toString());
              sponD.altaSponsor(2);
              Sponsor spon =sponD.buscarSponsor(2);
              System.out.println(spon.toString());
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
          
}

}
