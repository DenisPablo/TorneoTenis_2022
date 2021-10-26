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
    private int idPartido; 
    private Jugador jugador1;
    private Jugador jugador2;
    private LocalDate fechaEncuentro;
    private int resultado;
    private Jugador jugadorGanador;
    private String estado;
    private Estadio idEstadio;
    private boolean activo;
    private Torneo idTorneo;

    public Encuentro(int idPartido, Jugador jugador1, Jugador jugador2, LocalDate fechaEncuentro, int resultado, Jugador jugadorGanador, String estado, Estadio idEstadio, boolean activo, Torneo idTorneo) {
        this.idPartido = idPartido;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fechaEncuentro = fechaEncuentro;
        this.resultado = resultado;
        this.jugadorGanador = jugadorGanador;
        this.estado = estado;
        this.idEstadio = idEstadio;
        this.activo = activo;
        this.idTorneo = idTorneo;
    }

    public Encuentro(Jugador jugador1, Jugador jugador2, LocalDate fechaEncuentro, int resultado, Jugador jugadorGanador, String estado, Estadio idEstadio, boolean activo, Torneo idTorneo) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.fechaEncuentro = fechaEncuentro;
        this.resultado = resultado;
        this.jugadorGanador = jugadorGanador;
        this.estado = estado;
        this.idEstadio = idEstadio;
        this.activo = activo;
        this.idTorneo = idTorneo;
    }

    public Encuentro() {
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
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

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
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

    public Estadio getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(Estadio idEstadio) {
        this.idEstadio = idEstadio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }
    
    
}

