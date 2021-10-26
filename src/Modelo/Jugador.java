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
    private int torneoGanados;
    private int ranking;
    private Torneo torneo;
    private int puntaje;
    private boolean activo;

    public Jugador(int idJugador, String nombre, int dni, LocalDate fechaNac, double altura, double peso, String estilo, String manoHabil, int torneoGanados, int ranking, Torneo torneo, int puntaje, boolean activo) {
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
        this.torneo = torneo;
        this.puntaje = puntaje;
        this.activo = activo;
    }

    public Jugador(String nombre, int dni, LocalDate fechaNac, double altura, double peso, String estilo, String manoHabil, int torneoGanados, int ranking, Torneo torneo, int puntaje, boolean activo) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.manoHabil = manoHabil;
        this.torneoGanados = torneoGanados;
        this.ranking = ranking;
        this.torneo = torneo;
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

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
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

    

    

    @Override
    public String toString() {
        return "Jugador{" + " idJugador= " + idJugador + "nombre=" + nombre + ", dni=" + dni + ", altura=" + altura + ", estilo=" + estilo + ", ranking=" + ranking + ", activo=" + activo + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
