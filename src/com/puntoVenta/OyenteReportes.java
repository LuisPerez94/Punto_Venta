/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import Formularios.AgregarCliente;
import Formularios.AgregarProducto;
import Formularios.AgregarVendedor;
import Oyentes.OyenteAgregarCliente;
import Oyentes.OyenteAgregarProducto;
import Oyentes.OyenteAgregarVendedor;
import Oyentes.OyenteReporteVentas;
import Tablas.TablaModeloProducto;
import Tablas.TablaRenderizadorProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JR
 */
public class OyenteReportes implements KeyListener, ActionListener, WindowListener  {
    private Conexion usuario;
    static Reportes ventanaReporte;
    private JTable productos;
    private PanelVentas p;
    private PanelVendedores p1;
    private PanelProductosMasVendidos ppmv;
    private PanelProductos p2;
    private PanelCatalogo catalogo;
    private PanelNuevaVenta panelNuevaVenta;
    private VentanaEmergente ventana;
    private TableRowSorter trsfiltro;
    private Tablas.TablaModeloProducto modelo;
    private String nombreVendedor;
    private boolean ctrl=false;
    private boolean alt=false;

    
    OyenteReportes() {

    }

    OyenteReportes(Reportes ventaReportes, Conexion usuario) {
        this.ventanaReporte = ventaReportes;
        this.usuario = usuario;
    }

    public void setVentanaReporte(Reportes ventanaReporte) {
        this.ventanaReporte = ventanaReporte;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Ventas":

                System.out.println("Ventas");
                p = new PanelVentas();
                p.addEventos(new OyenteReporteVentas(p,usuario));

                ventana = new VentanaEmergente("Ventas");
                ventana.add(p);
                ventana.addWindowListener(this);
                ventana.setSize(700, 400);
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                ventanaReporte.validate();

                break;
                
            case "Ventas por Vendedor":
                BuscarVendedor busqueda = new BuscarVendedor();
                
                break;
            case "Productos mas vendidos":
                
                System.out.println("Aqui se muestran los productos mas vendidos");
                
                ppmv = new PanelProductosMasVendidos();

                ventana = new VentanaEmergente("Productos más vendidos");
                OyenteProductosMasVendidos oppmv = new OyenteProductosMasVendidos(ppmv, usuario);
                ppmv.addEventos(oppmv);
                
                ventana.setSize(850, 550);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
                ventana.add(ppmv);
                
                ventana.addWindowListener(oppmv);
                ventana.setVisible(true);
                
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                ventanaReporte.validate();
                break;
                
            case "Salir":
                System.out.println("Con esto puedes salir");
                ventanaReporte.dispose();
                break;
                
            case "Acerca de":
                System.out.println("Mostrara acerca del programa");
                JOptionPane.showConfirmDialog(null, "2014,2015 PiñaSports©", "Acerca de", JOptionPane.DEFAULT_OPTION);

                break;
                
            case "Actualizar":
                System.out.println("Aqui actualizara");
                break;
                
            
            case "Nueva Venta":
               
                JTable prods = generarCatalogo();
                panelNuevaVenta = new PanelNuevaVenta(prods, usuario);
                panelNuevaVenta.getTextAtiende().setText(nombreVendedor);
                
                OyenteNuevaVenta oyenteNV = new OyenteNuevaVenta(panelNuevaVenta);
                
                panelNuevaVenta.addEventos(oyenteNV);
                
                ventana = new VentanaEmergente("Ventas");
                ventana.add(panelNuevaVenta);
                ventana.setSize(900, 555);
                ventana.setLocationRelativeTo(null);
                ventana.addWindowListener(this);
                ventana.setVisible(true);
                
               

                break;
                
                
            case "Catalogo de Productos":
                productos = generarCatalogo();
                catalogo = new PanelCatalogo(productos);
                catalogo.addEventos(this);
                trsfiltro = new TableRowSorter(modelo);
                productos.setRowSorter(trsfiltro);

                ventana = new VentanaEmergente("Ventas");
                ventana.add(catalogo);
                ventana.addWindowListener(this);
                ventana.setVisible(true);
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                break;
                case "Agrega un Producto":
                    AgregarProducto aP =new AgregarProducto();
                    usuario.iniciarConexion();
                    
                    aP.addEventos(new OyenteAgregarProducto(aP, usuario));
                   
                    break;
                case "Agregar un Cliente":
                    AgregarCliente aC=new AgregarCliente();
                    usuario.iniciarConexion();
                    aC.addEventos(new OyenteAgregarCliente(aC, usuario));
                    break;
                case "Agregar un Vendedor":
                    AgregarVendedor aV=new AgregarVendedor();
                    usuario.iniciarConexion();
                    aV.addEventos(new OyenteAgregarVendedor(usuario,aV));
                    break;
        }
        
        
    }
     
   
    public void filtro(){
        String filtro =catalogo.getTbusqueda().getText();
        switch(catalogo.getBusqueda().getSelectedIndex()){
            case 0:
                 trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)"+filtro, 0));
                break;
            case 1:
                 trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)"+filtro, 1));
                break;
            case 2:
                 trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)"+filtro, 2));
                 break;
            case 3: 
                 trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)"+filtro, 4));
                 break;
                    
        }
       
    }
    
    private JTable generarCatalogo() {
        String query = "SELECT * FROM Producto";
        modelo = new TablaModeloProducto();
        TablaRenderizadorProducto render = new TablaRenderizadorProducto();
        
        JTable tablaProductos = new JTable(modelo);
        tablaProductos.setRowHeight(100);
        tablaProductos.setDefaultRenderer(ImageIcon.class, render);
       

        try {
            usuario.iniciarConexion();
            usuario.setResult(usuario.getStament().executeQuery(query));

//            // Bucle para cada resultado en la consulta
            while (usuario.getResult().next()) {
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[modelo.getColumnCount()]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    fila[i] = usuario.getResult().getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                Producto p = new Producto(fila);
                modelo.agregarProducto(p);

            }
            
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(55);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(130);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(85);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(120);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(510);
            
            // Para alinear el texto de la primera celda al centro...
            DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
            alinear.setHorizontalAlignment(SwingConstants.CENTER);
            tablaProductos.getColumnModel().getColumn(0).setCellRenderer(alinear);
            
            usuario.getStament().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        } finally {
            usuario.cerrarConexion();
        }

        return tablaProductos;

    }
    
    
     
    ////////////////////////////GETTER Y SETTER ////////////////////////////////////    
    public Conexion getUsuario() {
        return usuario;
    }

    public void setUsuario(Conexion usuario) {
        this.usuario = usuario;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    /* **********   */
    
    @Override
    public void keyTyped(KeyEvent e) {
      //filtro();
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //filtro();
        if(e.getKeyCode()==KeyEvent.VK_CONTROL ){
            ctrl = true;
            
        }
        if(e.getKeyCode()==KeyEvent.VK_ALT ){
            alt =true;
            
        }
        if(ctrl&&alt&&e.getKeyCode()==KeyEvent.VK_C){
            System.out.println("Area de consulta oculta");
            AreaConsulta a = new AreaConsulta();
            ctrl=false;
            alt=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
       
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource().getClass().isInstance(ventana)) {
            ventana.dispose();

            
        } else if (e.getSource().getClass().isInstance(ventanaReporte)) {
            int opcion = JOptionPane.showConfirmDialog(null, "Se cerrará el programa", "Advertencia", JOptionPane.OK_CANCEL_OPTION);

            if (opcion == JOptionPane.OK_OPTION) {
                ventanaReporte.dispose();
            }
        }
    }

}
