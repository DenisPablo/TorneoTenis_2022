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
    private String indumentaria;
    private boolean activo;

    public Sponsor(int idPatrocinadores, String marca, String indumentaria, boolean activo) {
        this.idPatrocinadores = idPatrocinadores;
        this.marca = marca;
        this.indumentaria = indumentaria;
        this.activo = activo;
    }

    public Sponsor(String marca, String indumentaria, boolean activo) {
        this.marca = marca;
        this.indumentaria = indumentaria;
        this.activo = activo;
    }

    public Sponsor() {
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

    public String getIndumentaria() {
        return indumentaria;
    }

    public void setIndumentaria(String indumentaria) {
        this.indumentaria = indumentaria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
