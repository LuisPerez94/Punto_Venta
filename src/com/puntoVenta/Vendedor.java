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
    private String nombreVendedor;
    private String apPaterno;
    private String apMaterno;
    private String fechaNac;
    private String correoVendedor;
    private String direccion;
    private char sexo;
    private float sueldo;
    private String fechaIngresoVendedor;
   
    

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

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getFechaIngresoVendedor() {
        return fechaIngresoVendedor;
    }

    public void setFechaIngresoVendedor(String fechaIngresoVendedor) {
        this.fechaIngresoVendedor = fechaIngresoVendedor;
    }

   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return "Vendedor{" + "idVendedor=" + idVendedor + '}';
    }
    
    
}
