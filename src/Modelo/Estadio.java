/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author martinbordon
 */
public class Estadio {
    private int idEstadio;
    private String nombre;    
    private String ciudad;
    private String categoria;
    private boolean activo;
    private String direccionComercial;
    private String dimension;
    private boolean estado;
    
    public Estadio() {
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDireccionComercial() {
        return direccionComercial;
    }

    public void setDireccionComercial(String direccionComercial) {
        this.direccionComercial = direccionComercial;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    @Override
    public String toString() {
        return ( "Nombre: " + nombre + " Ciudad: " + ciudad);
    }

    public Estadio(int idEstadio, String nombre, String ciudad, String categoria, boolean activo, String direccionComercial, String dimension, boolean estado) {
        this.idEstadio = idEstadio;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.activo = activo;
        this.direccionComercial = direccionComercial;
        this.dimension = dimension;
        this.estado = estado;
    }

    public Estadio(String nombre, String ciudad, String categoria, boolean activo, String direccionComercial, String dimension, boolean estado) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.categoria = categoria;
        this.activo = activo;
        this.direccionComercial = direccionComercial;
        this.dimension = dimension;
        this.estado = estado;
    }
    
    
    
    
    
}
