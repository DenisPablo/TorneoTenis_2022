/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author martinbordon
 */
public class Jugador {
    private int idJugador;
    private String nombre;
    private int dni;
    private LocalDate fechaNac;
    private double altura;
    private double peso;
    private String estilo;
    private String manoHabil;
    private int torneoGanados=0;
    private int ranking=0;
    private int puntaje=0;
    private boolean activo;
    private int encuentrosGanados = 0;

    public Jugador(int idJugador, String nombre, int dni, LocalDate fechaNac, double altura, double peso, String estilo, String manoHabil, int torneoGanados, int ranking, int puntaje, boolean activo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.manoHabil = manoHabil;
        this.torneoGanados = torneoGanados;
        this.ranking = ranking;
        this.puntaje = puntaje;
        this.activo = activo;
    }

    public Jugador(String nombre, int dni, LocalDate fechaNac, double altura, double peso, String estilo, String manoHabil, int torneoGanados, int ranking, int puntaje, boolean activo) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.manoHabil = manoHabil;
        this.torneoGanados = torneoGanados;
        this.ranking = ranking;
        this.puntaje = puntaje;
        this.activo = activo;
    }

    public Jugador() {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getManoHabil() {
        return manoHabil;
    }

    public void setManoHabil(String manoHabil) {
        this.manoHabil = manoHabil;
    }

    public int getTorneoGanados() {
        return torneoGanados;
    }

    public void setTorneoGanados(int torneoGanados) {
        this.torneoGanados = torneoGanados;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }


    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    

    public void sumarPuntos(int puntos) {
        puntaje += puntos;
    }
    
    public void restarPuntos(int puntos) {
        puntaje -= puntos;
    }

    public void ganarTorneo() {
        torneoGanados++;
    }
    
    public void ganarEncuentro() {
        encuentrosGanados++;
    }

    public int getEncuentrosGanados() {
        return encuentrosGanados;
    }

    public void setEncuentrosGanados(int encuentrosGanados) {
        this.encuentrosGanados = encuentrosGanados;
    }
    
    
    @Override
      public String toString() {
        return ("Nombre: " + nombre + " DNI: " + dni);
    }

  
 

    
}
