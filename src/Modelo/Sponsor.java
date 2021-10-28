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
    private int idPatrocinadores;
    private String marca;
    private boolean activo;

    @Override
    public String toString() {
        return "Sponsor{" + "idPatrocinadores=" + idPatrocinadores + ", marca=" + marca + ", activo=" + activo + '}';
    }

    public int getIdPatrocinadores() {
        return idPatrocinadores;
    }

    public void setIdPatrocinadores(int idPatrocinadores) {
        this.idPatrocinadores = idPatrocinadores;
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

    public Sponsor() {
    }

    public Sponsor(String marca, boolean activo) {
        this.marca = marca;
        this.activo = activo;
    }

    public Sponsor(int idPatrocinadores, String marca, boolean activo) {
        this.idPatrocinadores = idPatrocinadores;
        this.marca = marca;
        this.activo = activo;
    }

    
}
