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
public class Torneo {
   private int idTorneo;     
   private String nombre;
   private LocalDate fechaNacInicio;
   private LocalDate fehcaNacFinal;
   private boolean activo;

    public Torneo(int idTorneo, String nombre, LocalDate fechaNacInicio, LocalDate fehcaNacFinal, boolean activo) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.fechaNacInicio = fechaNacInicio;
        this.fehcaNacFinal = fehcaNacFinal;
        this.activo = activo;
    }

    public Torneo(String nombre, LocalDate fechaNacInicio, LocalDate fehcaNacFinal, boolean activo) {
        this.nombre = nombre;
        this.fechaNacInicio = fechaNacInicio;
        this.fehcaNacFinal = fehcaNacFinal;
        this.activo = activo;
    }

    public Torneo() {
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacInicio() {
        return fechaNacInicio;
    }

    public void setFechaNacInicio(LocalDate fechaNacInicio) {
        this.fechaNacInicio = fechaNacInicio;
    }

    public LocalDate getFehcaNacFinal() {
        return fehcaNacFinal;
    }

    public void setFehcaNacFinal(LocalDate fehcaNacFinal) {
        this.fehcaNacFinal = fehcaNacFinal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
   
   
   
   
   
}
