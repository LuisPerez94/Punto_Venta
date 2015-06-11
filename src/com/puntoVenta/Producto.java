/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.Image;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.swing.ImageIcon;

/**
 *
 * @author JR
 */
public class Producto {
    private String idProducto;
    private String nombreProducto;
    private BigDecimal precio;
    private String ruta;
    private ImageIcon img;
    private String descripcion;
    private BigDecimal existencia;

    public Producto(String idProducto, String nombreProducto, BigDecimal precio, String ruta, String descripcion
                    , BigDecimal existencia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.ruta = ruta;
         img=new ImageIcon(ruta);
        this.descripcion = descripcion;
        this.existencia = existencia;
    }
   public Producto(Object []array){
       this.idProducto=(String)array[0];
       this.nombreProducto=(String)array[1];
       this.precio=(BigDecimal)array[2];
       this.ruta=(String)array[4];
       img=new ImageIcon(ruta);
       this.descripcion=(String)array[3];
       this.existencia = (BigDecimal) array[5];
   }

    public Producto() {
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getRuta() {
        return ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImg() {
        ImageIcon aux=new ImageIcon(img.getImage().getScaledInstance(70, 90, Image.SCALE_DEFAULT));
        return aux;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public BigDecimal getExistencia() {
        return existencia;
    }

    public void setExistencia(BigDecimal existencia) {
        this.existencia = existencia;
    }
   

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio + '}';
    }

   
    
    
}
