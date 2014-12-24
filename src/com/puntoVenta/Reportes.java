/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.UIManager;

/**
 *
 * @author JR
 */
public class Reportes extends JFrame{
    private JMenuItem ventas, ventasVendedor, productosMas, acercaDe, salir;
    private PanelVentas pVentas=null; 
    private PanelVendedores pVendedores=null; 
    private PanelProductos pProductos=null;
    
    public Reportes(){
        super("Reportes");
        setSize(640, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addComponents();
        addEventos();
        this.setVisible(true);
    }

    private void addComponents() {
        JMenu archivo = new JMenu ("Archivo");
        JMenu ayuda = new JMenu ("Ayuda");
        
        ventas = new JMenuItem("Ventas");
        ventasVendedor = new JMenuItem("Ventas por Vendedor");
        productosMas = new JMenuItem ("Productos mas vendidos");
        salir = new JMenuItem("Salir");
        acercaDe = new JMenuItem ("Acerca de");
        
        archivo.add(ventas);
        archivo.add(ventasVendedor);
        archivo.add(productosMas);
        archivo.add(new JSeparator());
        archivo.add(salir);
        
        ayuda.add(acercaDe);
        
        JMenuBar menuP = new JMenuBar();
        menuP.add(archivo);
        menuP.add(ayuda);
        
        this.setJMenuBar(menuP);
        
    }
    
    private void addEventos(){
        OyenteReportes o = new OyenteReportes(this);
        ventas.addActionListener(o);
        ventasVendedor.addActionListener(o);
        productosMas.addActionListener(o);
        salir.addActionListener(o);
        acercaDe.addActionListener(o);
        
    }

    public PanelVentas getpVentas() {
        return pVentas;
    }

    public void setpVentas(PanelVentas pVentas) {
        this.pVentas = pVentas;
    }

    public PanelVendedores getpVendedores() {
        return pVendedores;
    }

    public void setpVendedores(PanelVendedores pVendedores) {
        this.pVendedores = pVendedores;
    }

    public PanelProductos getpProductos() {
        return pProductos;
    }

    public void setpProductos(PanelProductos pProductos) {
        this.pProductos = pProductos;
    }
    
    
    
    
    
}
//
//class Main{
//    public static void main(String[] args) {
//        setLookAndFeel();
//        Reportes p  = new Reportes();
//    }
//    
//    public static void setLookAndFeel(){
//        try{
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }catch(Exception E){}
//        
//    }
//    
//}
