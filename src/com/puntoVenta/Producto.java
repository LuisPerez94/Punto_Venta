/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author JR
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private float precio;
    private String ruta;
    private ImageIcon img;
    private String descripcion;
    private int existencia;

    public Producto(int idProducto, String nombreProducto, float precio, String ruta, String descripcion
                    , int existencia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.ruta = ruta;
         img=new ImageIcon(ruta);
        this.descripcion = descripcion;
        this.existencia = existencia;
    }
   public Producto(Object []array){
       this.idProducto=(int) array[0];
       this.nombreProducto=(String)array[1];
       this.precio=(float)array[2];
       this.ruta=(String)array[3];
       img=new ImageIcon(ruta);
       this.descripcion=(String)array[4];
       this.existencia = (int) array[5];
   }

    public Producto() {
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(float precio) {
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

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
   

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio + '}';
    }

   
    
    
}
