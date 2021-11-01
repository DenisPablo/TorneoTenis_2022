/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Modelo.Conexion;
import Modelo.Jugador;
import Modelo.Sponsor;
import Modelo.Torneo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
       System.out.println("Error en la conexcion: "+ex);
    }
 }
     
     public void agregarTorneo(Torneo tor){
     
   

     }
    
     public void buscarTorneo(int id){}
     
     public void darBajaTorneo(int id){}
     
     public void darAltaTorneo(int id){}
     
     public void borrarTorneo(int id){}
     
     public List<Torneo> devolverTodosTorneos(){
     
        ArrayList<Torneo> resultados = new ArrayList();
      
        return resultados;
     }
     
     public List<Jugador> listarPuntajeTodosLosJugadores(){
         
         ArrayList<Jugador> resultados = new ArrayList();
         
         return resultados;
     }
     
     public List<Jugador> listarJugadoresDeTorneo(){
     
         ArrayList<Jugador> resultado = new ArrayList();
         
         return resultado;
     }
     
     public List<Sponsor> listarSponsors(){
     
         ArrayList<Sponsor> resultados = new ArrayList();
         
         
         return resultados;
     }
     
     
    
}
