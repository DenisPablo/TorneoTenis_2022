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
public class Patrocinio {
    private int idPatrocinio;
    private Sponsor idPatrocinador;
    private Jugador idJugador;
    private LocalDate fechaInicioContrato;
    private LocalDate fechaFinContrato;
    private boolean activo;

    public Patrocinio(int idPatrocinio, Sponsor idPatrocinador, Jugador idJugador, LocalDate fechaInicioContrato, LocalDate fechaFinContrato, boolean activo) {
        this.idPatrocinio = idPatrocinio;
        this.idPatrocinador = idPatrocinador;
        this.idJugador = idJugador;
        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.activo = activo;
    }

    public Patrocinio(Sponsor idPatrocinador, Jugador idJugador, LocalDate fechaInicioContrato, LocalDate fechaFinContrato, boolean activo) {
        this.idPatrocinador = idPatrocinador;
        this.idJugador = idJugador;
        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.activo = activo;
    }

    public Patrocinio() {
    }

    public int getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(int idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public Sponsor getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(Sponsor idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
}

