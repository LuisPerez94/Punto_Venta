/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

/**
 *
 * @author JR
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private float precio;
    private String ruta;
    private String descripcion;

    public Producto(int idProducto, String nombreProducto, float precio, String ruta, String descripcion) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.ruta = ruta;
        this.descripcion = descripcion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public String getRuta() {
        return ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
   

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio + '}';
    }

   
    
    
}
