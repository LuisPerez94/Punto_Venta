/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.Toolkit;
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

    private JMenuItem ventas, ventasVendedor, productosMas, acercaDe, cerrarSesion,
            nuevaVenta, productos,agregarCliente,agregarProducto,agregarVendedor, 
            modificarVendedor, modificarCliente, modificarProducto
            , eliminarVendedor, eliminarCliente, eliminarProducto
            , eliminarCabeceraFactura, eliminarDetalleFactura, clientes, almacen, vendedores,
            devoluciones, manualTecnico, manualUsuario;
    private PanelVentas pVentas = null;
    private PanelVendedores pVendedores = null;
    private PanelProductos pProductos = null;
    private PanelImagen i = new PanelImagen();
    private final String isAdmin;
    private JMenuItem agregarAlmacen;
    private JMenuItem eliminarAlmacen;
    
    Reportes(String isAdmin) {
        this.isAdmin = isAdmin;
        this.setTitle("Bienvenido");
        this.setSize(500, 500);
        setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        addWindowListener(new OyenteReportes());
        
        this.setVisible(true);
    }

    public Reportes() {
        this.isAdmin = "";
    }
    
    

    private void addComponents() {
        JMenuBar menuP;
        add(i);
        
        cerrarSesion = new JMenuItem("Cerrar sesión");
        acercaDe = new JMenuItem("Acerca de");
        
        JMenu catalogos = new JMenu("Catálogos");
        JMenu procesos = new JMenu("Procesos");
        JMenu reportes = new JMenu("Reportes");
        JMenu administrar = new JMenu("Administrar");
        JMenu ayuda = new JMenu("Ayuda");
        JMenu salir = new JMenu("Salir");
        
//        reportes.add(salir);
        manualTecnico = new JMenuItem("Manual técnico");
        manualUsuario = new JMenuItem("Manual de usuario");
        ayuda.add(manualTecnico);
        ayuda.add(new JSeparator());
        ayuda.add(manualUsuario);
        ayuda.add(new JSeparator());
        ayuda.add(acercaDe);
        salir.add(cerrarSesion);
        
        if (isAdmin.equals("T")) {
            // Catálogos...
            clientes = new JMenuItem("Clientes");
            almacen = new JMenuItem("Almacén");
            vendedores = new JMenuItem("Vendedores");
            productos = new JMenuItem("Productos");
            
            catalogos.add(clientes);
//            catalogos.add(new JSeparator());
//            catalogos.add(almacen);
            catalogos.add(new JSeparator());
            catalogos.add(vendedores);
            catalogos.add(new JSeparator());
            catalogos.add(productos);
            catalogos.add(new JSeparator());
            catalogos.add(almacen);
            
            // Procesos...
            nuevaVenta = new JMenuItem("Nueva venta");
            devoluciones = new JMenuItem("Devoluciones");

            procesos.add(nuevaVenta);
//            procesos.add(new JSeparator());
//            procesos.add(devoluciones);
            
            // Reportes..
            ventas = new JMenuItem("Ventas");
            ventasVendedor = new JMenuItem("Ventas por vendedor");
            productosMas = new JMenuItem("Productos más vendidos");
            
            reportes.add(ventas);
            reportes.add(new JSeparator());
            reportes.add(ventasVendedor);
            reportes.add(new JSeparator());
            reportes.add(productosMas);
            reportes.add(new JSeparator());
            
            // Administrar...
            agregarCliente = new JMenuItem("Agregar un cliente");
            agregarVendedor = new JMenuItem("Agregar un vendedor");
            agregarProducto = new JMenuItem("Agregar un producto");
            modificarCliente = new JMenuItem("Modificar un cliente");
            modificarVendedor = new JMenuItem("Modificar un vendedor");
            modificarProducto = new JMenuItem("Modificar un producto");
            eliminarCliente = new JMenuItem("Eliminar un cliente");
            eliminarVendedor = new JMenuItem("Eliminar un vendedor");
            eliminarProducto = new JMenuItem("Eliminar un producto");
            eliminarCabeceraFactura = new JMenuItem("Eliminar cabecera factura");
            eliminarDetalleFactura = new JMenuItem("Eliminar detalle factura");
            agregarAlmacen = new JMenuItem("Agregar almacen");
            eliminarAlmacen = new JMenuItem("Eliminar almacen");
            
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
            administrar.add(new JSeparator());
            administrar.add(agregarAlmacen);
            administrar.add(eliminarAlmacen);
            
            
            menuP = new JMenuBar();
            menuP.add(catalogos);
            menuP.add(procesos);
            menuP.add(reportes);
            menuP.add(administrar);
            menuP.add(ayuda);
            menuP.add(salir);
            
        } else {
            nuevaVenta = new JMenuItem("Nueva venta");
            productos = new JMenuItem("Productos");

            procesos.add(nuevaVenta);
            procesos.add(new JSeparator());
            
            catalogos.add(productos);
            catalogos.add(new JSeparator());
            
            menuP = new JMenuBar();
            
            menuP.add(catalogos);
            menuP.add(procesos);
            menuP.add(ayuda);
            menuP.add(salir);
            
        }

        
        this.setJMenuBar(menuP);
    }

    public void addEventos(OyenteReportes o) {
        cerrarSesion.addActionListener(o);
        acercaDe.addActionListener(o);
        manualTecnico.addActionListener(o);
        manualUsuario.addActionListener(o);
        
        if (isAdmin.equals("T")) {
           nuevaVenta.addActionListener(o);
           productos.addActionListener(o);
           
           clientes.addActionListener(o);
           almacen.addActionListener(o);
           vendedores.addActionListener(o);
           devoluciones.addActionListener(o);
           
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
           agregarAlmacen.addActionListener (o);
           eliminarAlmacen.addActionListener (o);
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


