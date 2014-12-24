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
public class Almacen {
    private int idAlmacen;

    public Almacen() {
    }

    public Almacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public String toString() {
        return "Almacen{" + "idAlmacen=" + idAlmacen + '}';
    }
    
    
}
