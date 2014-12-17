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
public class Detalle_fact {
    private int idDetalle_fact;
    private int idCab_fact;
    private int idProducto;
    private String fechaVenta;
    private int cantidaProducto;

    public Detalle_fact() {
    }

    public Detalle_fact(int idDetalle_fact) {
        this.idDetalle_fact = idDetalle_fact;
    }

    public Detalle_fact(int idDetalle_fact, int idCab_fact, int idProducto) {
        this.idDetalle_fact = idDetalle_fact;
        this.idCab_fact = idCab_fact;
        this.idProducto = idProducto;
    }

    public int getIdDetalle_fact() {
        return idDetalle_fact;
    }

    public void setIdDetalle_fact(int idDetalle_fact) {
        this.idDetalle_fact = idDetalle_fact;
    }

    public int getIdCab_fact() {
        return idCab_fact;
    }

    public void setIdCab_fact(int idCab_fact) {
        this.idCab_fact = idCab_fact;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidaProducto() {
        return cantidaProducto;
    }

    public void setCantidaProducto(int cantidaProducto) {
        this.cantidaProducto = cantidaProducto;
    }

    @Override
    public String toString() {
        return "Detalle_fact{" + "idDetalle_fact=" + idDetalle_fact + ", idCab_fact=" + idCab_fact + ", idProducto=" + idProducto + ", fechaVenta=" + fechaVenta + ", cantidaProducto=" + cantidaProducto + '}';
    }
    
    

    
    
    
}
