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
public class Cab_fact {
    private int idCab_fact;
    private int idCliente;
    private int idVendedor;

    public Cab_fact() {
    }

    public Cab_fact(int idCab_fact) {
        this.idCab_fact = idCab_fact;
    }

    public Cab_fact(int idCab_fact, int idCliente, int idVendedor) {
        this.idCab_fact = idCab_fact;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public int getIdCab_fact() {
        return idCab_fact;
    }

    public void setIdCab_fact(int idCab_fact) {
        this.idCab_fact = idCab_fact;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "Cab_fact{" + "idCab_fact=" + idCab_fact + ", idCliente=" + idCliente + ", idVendedor=" + idVendedor + '}';
    }
    
    
    
    
}
