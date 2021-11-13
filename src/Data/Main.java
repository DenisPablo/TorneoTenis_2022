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
import Modelo.Patrocinio;
import Modelo.Sponsor;
import Modelo.Torneo;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Romi
 */
public class Main {
      public static void main(String[] args) {
          
////Guardar Sponsor          
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
//        
// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////Guardar Jugador          
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
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////Guardar Patrocinio          
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
//              PatrocinioData patD=new PatrocinioData(con);
//              Patrocinio pat = patD.buscarPatrocinio(1);
//              System.out.println(pat.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////////modificar Patrocinio
//        try {
//              Conexion con = new Conexion();
//              PatrocinioData patD=new PatrocinioData(con);
//              Patrocinio pat = patD.buscarPatrocinio(1);
//               System.out.println("Patrocinio sin modificar:"+pat.toString());
//              pat.setIndumentaria("indumentaria");
//              patD.modificadarPatrocicio(pat);
//              Patrocinio pat1 =patD.buscarPatrocinio(1);
//              System.out.println("Patrocinio Modificado: "+pat1.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//// //Desactivar y activar Patrocinio
// try {
//              Conexion con = new Conexion();
//              
//              PatrocinioData patD=new PatrocinioData(con);
//              patD.bajaPatrocinio(1);
//              Patrocinio pat =patD.buscarPatrocinio(1);
//              System.out.println("Desactivar: "+pat.toString());
//              patD.altaSponsor(1);
//              Patrocinio pat1 =patD.buscarPatrocinio(1);
//              System.out.println("Activar: "+pat1.toString());
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////Guardar Estadio          
//          try {
//              Conexion con = new Conexion();
//              EstadioData estD = new EstadioData(con);
//              Estadio est = new Estadio("Juan Gilberto Funes","La Punta","Cemento",true,"Av Los Tilos","20*30");
//              Estadio est1 = new Estadio("La Lucha","San Luis","cesped",true,"Av Los puqios","25*30");
//              estD.guardarEstadio(est);
//              estD.guardarEstadio(est1);
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////Buscar Estadio
//    try {
//              Conexion con = new Conexion();
//               EstadioData estD = new EstadioData(con);
//              Estadio est  = estD.buscarEstadio(3);
//              System.out.println(est.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////////modificar Estadio
//        try {
//              Conexion con = new Conexion();
//              EstadioData estD = new EstadioData(con);
//              Estadio est  = estD.buscarEstadio(3); 
//              est.setCategoria("Cemento");
//              estD.modificadarEstadio(est);
//              System.out.println(est.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//// //Desactivar y activar Estadio
// try {
//              Conexion con = new Conexion();
//             EstadioData estD = new EstadioData(con);
//              estD.bajaEstadio(3);
//              Estadio est  = estD.buscarEstadio(3); 
//              System.out.println(est.toString());
//              estD.altaEstadio(3);
//              Estadio est1  = estD.buscarEstadio(3); 
//              System.out.println(est1.toString());
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Guardar Encuentro        
//         try {
//              Conexion con = new Conexion();
//              
//              EncuentroData encuD = new EncuentroData(con);
//              JugadorData juD = new JugadorData(con);
//              Jugador j1 = juD.buscarJugador(4);
//              Jugador j2 = juD.buscarJugador(5);
//              EstadioData estD = new EstadioData(con);
//              Estadio est1 = estD.buscarEstadio(3);
//              Torneo t=new Torneo();
//              TorneoData  td=new TorneoData(con);
//              t=td.buscarTorneo(2);
//              Encuentro e1 = new Encuentro(j1, j2,LocalDate.parse("1999-03-11"), "5-4",j1,"activo", est1, true,t);
//              encuD.agregarEncuentro(e1);
//              
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////Buscar Encuentro
// try {
//              Conexion con = new Conexion();
//               EncuentroData encuD = new EncuentroData(con);
//              Encuentro e1 =  encuD.buscarEncuentro(2);
//              System.out.println(e1.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//////////modificar Encuentro
//        try {
//              Conexion con = new Conexion();
//              EncuentroData encuD = new EncuentroData(con);
//              Encuentro e1 = encuD.buscarEncuentro(2);
//              e1.setResultado("60-30");
//              encuD.modificarEncuentro(e1);
//              Encuentro e11 = encuD.buscarEncuentro(2);
//              System.out.println(e11.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//// //Desactivar y activar Encuentro
// try {
//              Conexion con = new Conexion();
//              EncuentroData encuD = new EncuentroData(con);
//              encuD.darBajaEncuentro(2);
//              Encuentro enc  = encuD.buscarEncuentro(2);
//              System.out.println(enc.toString());
//              encuD.darAltaEncuentro(2);
//              Encuentro enc1  = encuD.buscarEncuentro(2);
//              System.out.println(enc1.toString());
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//          
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Guardar Torneo        
//         try {
//              Conexion con = new Conexion();
//              TorneoData torD = new TorneoData(con);
//              Torneo tor = new Torneo("The Champion",LocalDate.parse("2021-03-11"),LocalDate.parse("2022-03-11"),true);
//              torD.agregarTorneo(tor);
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
////Buscar Torneo
// try {
//              Conexion con = new Conexion();
//               TorneoData torD = new TorneoData(con);
//              Torneo tor =  torD.buscarTorneo(2);
//              System.out.println(tor.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//////////modificar Torneo
//        try {
//              Conexion con = new Conexion();
//              TorneoData torD = new TorneoData(con);
//              Torneo tor = torD.buscarTorneo(2);
//              tor.setFechaNacInicio(LocalDate.parse("2021-01-11"));
//              torD.modificadarTorneo(tor);
//              Torneo t1 = torD.buscarTorneo(2);
//              System.out.println(t1.toString());
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
//// //Desactivar y activar Torneo
 try {
              Conexion con = new Conexion();
               TorneoData torD = new TorneoData(con);
              torD.darBajaTorneo(2);
              Torneo t  = torD.buscarTorneo(2);
              System.out.println(t.toString());
              torD.darAltaTorneo(2);
               Torneo t1  = torD.buscarTorneo(2);
              System.out.println(t1.toString());
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
          
}

}
