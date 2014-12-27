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
public class Reportes extends JFrame {

    private JMenuItem ventas, ventasVendedor, productosMas, acercaDe, salir,
            nuevaVenta, productos;
    private PanelVentas pVentas = null;
    private PanelVendedores pVendedores = null;
    private PanelProductos pProductos = null;
    private final String isAdmin;
    
    Reportes(String isAdmin) {
        this.isAdmin = isAdmin;
        salir = new JMenuItem("Salir");
        acercaDe = new JMenuItem("Acerca de");
        this.setTitle("Bienvenido");
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents();
        
        this.setVisible(true);
    }

    private void addComponents() {

        JMenu archivo = new JMenu("Archivo");
        JMenu ayuda = new JMenu("Ayuda");
        if (isAdmin.equals("T")) {

            ventas = new JMenuItem("Ventas");
            ventasVendedor = new JMenuItem("Ventas por Vendedor");
            productosMas = new JMenuItem("Productos mas vendidos");

            archivo.add(ventas);
            archivo.add(ventasVendedor);
            archivo.add(productosMas);
            archivo.add(new JSeparator());
        } else {
            nuevaVenta = new JMenuItem("Nueva Venta");
            productos = new JMenuItem("Catalogo de Productos");

            archivo.add(nuevaVenta);
            archivo.add(productos);

        }

        archivo.add(salir);
        ayuda.add(acercaDe);

        JMenuBar menuP = new JMenuBar();
        menuP.add(archivo);
        menuP.add(ayuda);

        this.setJMenuBar(menuP);

    }

    public void addEventos(OyenteReportes o) {

        
        salir.addActionListener(o);
        acercaDe.addActionListener(o);
        
        if (isAdmin.equals("T")) {
            ventas.addActionListener(o);
            ventasVendedor.addActionListener(o);
            productosMas.addActionListener(o);
        } else if (isAdmin.equals("F")) {
            nuevaVenta.addActionListener(o);
            productos.addActionListener(o);
        }

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


