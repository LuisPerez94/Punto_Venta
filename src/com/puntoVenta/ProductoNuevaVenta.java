package com.puntoVenta;

import java.awt.*;
import javax.swing.*;

/**
 * @author Fernando2
 * Created on Dec 26, 2014, 8:32:17 PM
 */

public class ProductoNuevaVenta extends JPanel{
    private JLabel nombre;
    private JLabel id;
    private PanelImg imagen;
    private String rutaImg;
    private double precio;
    private String descripcion;
    private JPanel subNorte;
    private JPanel subSur;
    
    public ProductoNuevaVenta(){
        rutaImg = "";
        addComponentes();
    }
    
    public final void addComponentes(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100, 200));
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 5));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        subNorte = new JPanel();
        subSur = new JPanel();
        
        id = new JLabel("");
        nombre = new JLabel("");
        imagen = new PanelImg();
        
        subNorte.add(id);
        subSur.add(nombre);
        
        this.add(subNorte, "North");
        this.add(imagen, "Center");
        this.add(subSur, "South");
    }
    
    // Para colocar la imagen del producto en el panel...
    class PanelImg extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            try{
                ImageIcon img = new ImageIcon(getClass().getResource(rutaImg));
                
                ImageIcon aux = new ImageIcon(img.getImage().getScaledInstance(150, 180, Image.SCALE_SMOOTH));
                
                g.drawImage(aux.getImage(), 0, 0, this);
            }catch(Exception e){
                System.out.println("Hubo un error al colocar la imagen " + e.getMessage());
                System.out.println("Ruta: " + rutaImg);
            }
        }
    }

    public void hover(){
        subNorte.setBackground(Color.LIGHT_GRAY);
        subSur.setBackground(Color.LIGHT_GRAY);
        
//        this.updateUI();
    }
    
    public void out(){
        subNorte.setBackground(this.getBackground());
        subSur.setBackground(this.getBackground());
        
//        this.updateUI();
    }
    
    public JLabel getNombre() {
        return nombre;
    }

    public JLabel getId() {
        return id;
    }

    public PanelImg getImagen() {
        return imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    
}
