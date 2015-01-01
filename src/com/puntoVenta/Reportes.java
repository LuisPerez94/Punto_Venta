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
            nuevaVenta, productos,agregarCliente,agregarProducto,agregarVendedor, 
            modificarVendedor, modificarCliente, modificarProducto
            , eliminarVendedor, eliminarCliente, eliminarProducto
            , eliminarCabeceraFactura, eliminarDetalleFactura;
    private PanelVentas pVentas = null;
    private PanelVendedores pVendedores = null;
    private PanelProductos pProductos = null;
    private PanelImagen i = new PanelImagen();
    private final String isAdmin;
    
    Reportes(String isAdmin) {
        this.isAdmin = isAdmin;
        salir = new JMenuItem("Salir");
        acercaDe = new JMenuItem("Acerca de");
        this.setTitle("Bienvenido");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addComponents();
        addWindowListener(new OyenteReportes());
        
        this.setVisible(true);
    }

    public Reportes() {
        this.isAdmin = "";
    }
    
    

    private void addComponents() {
        JMenuBar menuP;
        add(i);
        JMenu archivo = new JMenu("Reportes");
        JMenu ayuda = new JMenu("Ayuda");
        JMenu administrar = new JMenu("Administrar");
        
        if (isAdmin.equals("T")) {
            
            JMenu caja = new JMenu("Caja");
            
            nuevaVenta = new JMenuItem("Nueva Venta");
            productos = new JMenuItem("Catalogo de Productos");

            ventas = new JMenuItem("Ventas");
            ventasVendedor = new JMenuItem("Ventas por Vendedor");
            productosMas = new JMenuItem("Productos mas vendidos");
            agregarCliente=new JMenuItem("Agregar un Cliente");
            agregarVendedor=new JMenuItem("Agregar un Vendedor");
            agregarProducto=new JMenuItem("Agrega un Producto");
            modificarCliente=new JMenuItem("Modificar un Cliente");
            modificarVendedor=new JMenuItem("Modificar un Vendedor");
            modificarProducto=new JMenuItem("Modificar un Producto");
            eliminarCliente=new JMenuItem("Eliminar un Cliente");
            eliminarVendedor=new JMenuItem("Eliminar un Vendedor");
            eliminarProducto=new JMenuItem("Eliminar un Producto");
            eliminarCabeceraFactura=new JMenuItem("Eliminar Cabecera Factura");
            eliminarDetalleFactura=new JMenuItem("Eliminar Detalle Factura");
            
            caja.add(nuevaVenta);
            caja.add(new JSeparator());
            caja.add(productos);
            
            administrar.add(agregarCliente);
            administrar.add(agregarProducto);
            administrar.add(agregarVendedor);
            administrar.add(new JSeparator());
            administrar.add(modificarCliente);
            administrar.add(modificarProducto);
            administrar.add(modificarVendedor);
            administrar.add(new JSeparator());
            administrar.add(eliminarCliente);
            administrar.add(eliminarProducto);
            administrar.add(eliminarVendedor);
            
            administrar.add(new JSeparator());
            administrar.add(eliminarCabeceraFactura);
            administrar.add(eliminarDetalleFactura);
            
            archivo.add(ventas);
            archivo.add(ventasVendedor);
            archivo.add(new JSeparator());
            archivo.add(productosMas);
            archivo.add(new JSeparator());
            
            menuP = new JMenuBar();
            
            menuP.add(archivo);
            menuP.add(caja);
            menuP.add(administrar);
            menuP.add(ayuda);
            
        } else {
            archivo = new JMenu("Caja");
            
            nuevaVenta = new JMenuItem("Nueva Venta");
            productos = new JMenuItem("Catalogo de Productos");

            archivo.add(nuevaVenta);
            archivo.add(new JSeparator());
            archivo.add(productos);
            archivo.add(new JSeparator());
            menuP = new JMenuBar();
            
            menuP.add(archivo);
            
            menuP.add(ayuda);
            
        }

        archivo.add(salir);
        ayuda.add(acercaDe);
        
        this.setJMenuBar(menuP);

    }

    public void addEventos(OyenteReportes o) {
        salir.addActionListener(o);
        acercaDe.addActionListener(o);
        
        if (isAdmin.equals("T")) {
           nuevaVenta.addActionListener(o);
           productos.addActionListener(o);
            
           ventas.addActionListener(o);
           ventasVendedor.addActionListener(o);
           productosMas.addActionListener(o);
           agregarCliente.addActionListener(o);
           agregarProducto.addActionListener(o);
           agregarVendedor.addActionListener(o);
          
           modificarCliente.addActionListener(o);
           modificarVendedor.addActionListener(o);
           modificarProducto.addActionListener(o);
           
           eliminarCliente.addActionListener(o);
           eliminarVendedor.addActionListener(o);
           eliminarProducto.addActionListener(o);
           eliminarCabeceraFactura.addActionListener(o);
           eliminarDetalleFactura.addActionListener (o);
           this.addKeyListener(new OyenteReportes());
           
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


