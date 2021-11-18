/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author martinbordon
 */
public class Sponsor {
    private int idSponsor;
    private String marca;
    private boolean activo;

    public Sponsor(int idSponsor, String marca, boolean activo) {
        this.idSponsor = idSponsor;
        this.marca = marca;
        this.activo = activo;
    }

    public Sponsor(String marca, boolean activo) {
        this.marca = marca;
        this.activo = activo;
    }

    public Sponsor() {
    }

    public int getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(int idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return ("Sponsor" + " ID " + idSponsor + " Marca " + marca);
    }

    
    
}