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
    private Sponsor sponsor;
    private Jugador jugador;
    private String indumentaria;
    private LocalDate fechaInicioContrato;
    private LocalDate fechaFinContrato;
    private boolean activo;

  
    
    @Override
    public String toString() {
        return "Patrocinio{" + "idPatrocinio=" + idPatrocinio + ", Patrocinador=" + sponsor + ", Jugador=" + jugador + ", indumentaria=" + indumentaria + ", fechaInicioContrato=" + fechaInicioContrato + ", fechaFinContrato=" + fechaFinContrato + ", activo=" + activo + '}';
    }

    public Patrocinio(int idPatrocinio, Sponsor sponsor, Jugador jugador, String indumentaria, LocalDate fechaInicioContrato, LocalDate fechaFinContrato, boolean activo) {
        this.idPatrocinio = idPatrocinio;
        this.sponsor = sponsor;
        this.jugador = jugador;
        this.indumentaria = indumentaria;
        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.activo = activo;
    }

    public Patrocinio(Sponsor sponsor, Jugador jugador, String indumentaria, LocalDate fechaInicioContrato, LocalDate fechaFinContrato, boolean activo) {
        this.sponsor = sponsor;
        this.jugador = jugador;
        this.indumentaria = indumentaria;
        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.activo = activo;
    }

    public int getIdPatrocinio() {
        return idPatrocinio;
    }

    public void setIdPatrocinio(int idPatrocinio) {
        this.idPatrocinio = idPatrocinio;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public String getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(String indumentaria) {
        this.indumentaria = indumentaria;
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

