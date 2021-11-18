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
public class Encuentro {
    private int idEncuentro; 
    private Jugador jugador1;
    private Jugador jugador2;
    private LocalDate fechaEncuentro; 
    private String resultado= "0-0";
    private Jugador jugadorGanador;
    private String estado = "Pendiente";
    private Estadio estadio;
    private boolean activo;
    private Torneo torneo;

    public Encuentro(int idEncuentro, Jugador jugador1, Jugador jugador2, LocalDate fechaEncuentro, String resultado, Jugador jugadorGanador, String estado, Estadio idEstadio, boolean activo, Torneo idTorneo) {
        this.idEncuentro = idEncuentro;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fechaEncuentro = fechaEncuentro;
        this.resultado = resultado;
        this.jugadorGanador = jugadorGanador;
        this.estado = estado;
        this.estadio = idEstadio;
        this.activo = activo;
        this.torneo = idTorneo;
    }

    public Encuentro(Jugador jugador1, Jugador jugador2, LocalDate fechaEncuentro, String resultado, Jugador jugadorGanador, String estado, Estadio idEstadio, boolean activo, Torneo idTorneo) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fechaEncuentro = fechaEncuentro;
        this.resultado = resultado;
        this.jugadorGanador = jugadorGanador;
        this.estado = estado;
        this.estadio = idEstadio;
        this.activo = activo;
        this.torneo = idTorneo;
    }

    public Encuentro() {
    }

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public LocalDate getFechaEncuentro() {
        return fechaEncuentro;
    }

    public void setFechaEncuentro(LocalDate fechaEncuentro) {
        this.fechaEncuentro = fechaEncuentro;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    @Override
    public String toString() {
        return ("Encuentro:" + " ID: " + idEncuentro + " Jugador 1: " + jugador1 + " Jugador 2 " + jugador2 + " Fecha: " + fechaEncuentro + " Resultado: " + resultado + " jugadorGanador: " + jugadorGanador );
    }
    
}

