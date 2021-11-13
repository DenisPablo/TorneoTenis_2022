/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Data;

import Modelo.Conexion;
import Modelo.Encuentro;
import Modelo.Estadio;
import Modelo.Jugador;
import Modelo.Torneo;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martinbordon
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//    //Guardar agregarEncuentro        
//         try {
//              Conexion con = new Conexion();
//              
//              EncuentroData encuD = new EncuentroData(con);
//              JugadorData juD = new JugadorData(con);
//              Jugador j1 = juD.buscarJugador(4);
//              Jugador j2 = juD.buscarJugador(5);
//              EstadioData estD = new EstadioData(con);
//              Estadio est1 = estD.buscarEstadio(es);
//              Encuentro e1 = new Encuentro(j1, j2,LocalDate.parse("1999-03-11"), "5-4",j1,"activo", "Monumental", true,"LigaA");
//              encuD.agregarEncuentro(en);
//              
//              encuD.agregarEncuentro(encuentro);
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          } 
         

   ////// Guardar Jugador          
//          try {
//              Conexion con = new Conexion();
//              JugadorData jugD = new JugadorData(con);
//              Jugador juga1 = new Jugador("Martin",12235235,LocalDate.parse("1996-03-19"),1.85,78.3,"agresivo","derecho",0,0,0,true);
//              Jugador juga2 = new Jugador("Denis",23565565,LocalDate.parse("1996-03-22"),1.78,78.3,"agresivo","Zurdo",0,0,0,true);
//              jugD.guardarJugador(juga1);
//              jugD.guardarJugador(juga2);
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }

//////////  Guardar Estadio          
          try {
              Conexion con = new Conexion();
              
               EstadioData estadioD = new EstadioData(con);
              Estadio es = new Estadio("Monumental", "Buens Aires", "alta",true,"alvear","300x100"); 
              estadioD.guardarEstadio(es);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
//           try {
//              Conexion con = new Conexion();
//              
//               TorneoData torneoD = new TorneoData(con);
//              Torneo to = new Torneo("LigaA",LocalDate.parse("2020-12-01"),LocalDate.parse("2020-12-29"), true); 
//              torneoD.agregarTorneo(to);
//              
//          } catch (ClassNotFoundException ex) {
//              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//          }
    }
    

}