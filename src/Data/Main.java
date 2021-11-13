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
////Buscar Sponsor
//    try {
//              Conexion con = new Conexion();
//              
//              SponsorData sponD = new SponsorData(con);
//              Sponsor spon =sponD.buscarSponsor(2);
//              System.out.println(spon.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////modificar Sponsor
//        try {
//              Conexion con = new Conexion();
//              
//              SponsorData sponD = new SponsorData(con);
//              Sponsor spon = new Sponsor(2,"Adidas2",true); 
//              sponD.modificadarSponsor(spon);
//              Sponsor spon1 =sponD.buscarSponsor(2);
//              System.out.println(spon1.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
// //Desactivar y activar Sponsor
// try {
//              Conexion con = new Conexion();
//              
//              SponsorData sponD = new SponsorData(con);
//              sponD.bajaSponsor(2);
//              Sponsor spon1 =sponD.buscarSponsor(2);
//              System.out.println(spon1.toString());
//              sponD.altaSponsor(2);
//              Sponsor spon =sponD.buscarSponsor(2);
//              System.out.println(spon.toString());
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
        
// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Guardar Jugador          
//          try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador jug = new Jugador("Julio",12235235,LocalDate.parse("1996-03-23"),1.78,78.3,"agresivo","derecho",0,0,0,true);
//              Jugador jug1 = new Jugador("Mario",23565565,LocalDate.parse("1996-03-23"),1.78,78.3,"agresivo","Zurdo",0,0,0,true);
//              jugD.guardarJugador(jug);
//              jugD.guardarJugador(jug1);
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////Buscar Jugador
//    try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador jug = jugD.buscarJugador(4);
//              System.out.println(jug.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//////modificar Jugador
//        try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador jug = new Jugador(4,"Julio",12235235,LocalDate.parse("1996-03-23"),1.78,78.3,"agresivo","derecho",0,0,0,true); 
//              jugD.actualizarJugador(jug);
//              Jugador jug1 =jugD.buscarJugador(4);
//              System.out.println(jug1.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
// //Desactivar y activar Jugador
// try {
//              Conexion con = new Conexion();
//              
//              JugadorData jugD = new JugadorData(con);
//              jugD.desactivarJugador(4);
//              Jugador jug =jugD.buscarPorID(4);
//              System.out.println(jug.toString());
//              jugD.activarJugador(4);
//              Jugador jug1 =jugD.buscarPorID(4);
//              System.out.println(jug1.toString());
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//          
// 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Guardar Patrocinio          
//          try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador jug = jugD.buscarJugador(4);
//              SponsorData sponD = new SponsorData(con);
//              Sponsor spon1 =sponD.buscarSponsor(2);
//              PatrocinioData patD=new PatrocinioData(con);
//              Patrocinio pat = new Patrocinio(spon1,jug,"Calsado",LocalDate.parse("2021-03-05"),LocalDate.parse("2025-03-05"),true);
//              Jugador jug2 = jugD.buscarJugador(5);
//              Sponsor spon2 =sponD.buscarSponsor(3);
//              Patrocinio pat1 = new Patrocinio(spon2,jug2,"Indumentaria",LocalDate.parse("2021-03-05"),LocalDate.parse("2025-03-05"),true);
//              patD.guardarPatrocinio(pat);
//              patD.guardarPatrocinio(pat1);
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////Buscar Patrocinio
//    try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador jug = jugD.buscarJugador(4);
//              System.out.println(jug.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//////modificar Patrocinio
//        try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador jug = new Jugador(4,"Julio",12235235,LocalDate.parse("1996-03-23"),1.78,78.3,"agresivo","derecho",0,0,0,true); 
//              jugD.actualizarJugador(jug);
//              Jugador jug1 =jugD.buscarJugador(4);
//              System.out.println(jug1.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
// //Desactivar y activar Patrocinio
// try {
//              Conexion con = new Conexion();
//              
//              JugadorData jugD = new JugadorData(con);
//              jugD.desactivarJugador(4);
//              Jugador jug =jugD.buscarPorID(4);
//              System.out.println(jug.toString());
//              jugD.activarJugador(4);
//              Jugador jug1 =jugD.buscarPorID(4);
//              System.out.println(jug1.toString());
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//  

}

}
