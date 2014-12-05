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
public class Vendedor {
    private int idVendedor;

    public Vendedor() {
    }

    public Vendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "idVendedor=" + idVendedor + '}';
    }
    
    
}
