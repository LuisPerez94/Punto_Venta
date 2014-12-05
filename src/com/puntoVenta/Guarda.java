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
public class Guarda {
    private String idGuarda;
    private int idAlmacen;
    private int idProducto;

    public Guarda() {
    }

    public Guarda(String idGuarda) {
        this.idGuarda = idGuarda;
    }

    public Guarda(String idGuarda, int idAlmacen, int idProducto) {
        this.idGuarda = idGuarda;
        this.idAlmacen = idAlmacen;
        this.idProducto = idProducto;
    }

    public String getIdGuarda() {
        return idGuarda;
    }

    public void setIdGuarda(String idGuarda) {
        this.idGuarda = idGuarda;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Guarda{" + "idGuarda=" + idGuarda + ", idAlmacen=" + idAlmacen + ", idProducto=" + idProducto + '}';
    }
    
    
}
