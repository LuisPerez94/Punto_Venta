/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

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
import javax.swing.JFrame;
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
    private PanelProductos p2;
    private PanelCatalogo catalogo;
    private PanelNuevaVenta panelNuevaVenta;
    private VentanaEmergente ventana;
    private TableRowSorter trsfiltro;
    private Tablas.TablaModeloProducto modelo;
    private String nombreVendedor;

    
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
//                try {
//                    ventanaReporte.remove(p);
//                    ventanaReporte.remove(p1);
//                    ventanaReporte.remove(p2);
//
//                } catch (Exception ex) {
//                    ventanaReporte.add(p);
//
//                }
//
//                ventanaReporte.add(p);
//                ventanaReporte.setpVentas(p);
                ventana = new VentanaEmergente("Ventas");
                ventana.add(p);
                ventana.addWindowListener(this);
                ventana.setVisible(true);
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                ventanaReporte.validate();

                break;
                
            case "Ventas por Vendedor":
                System.out.println("aqui se muestra las ventas por vendedor");
                String busca="";
                int x, y;
                boolean isID=true;
                boolean noSalir=true; //Para salir del do-while
                do {                    
                    busca = JOptionPane.showInputDialog("Escribe la id o el nombre de usuario que se buscará");
                    isID=true;
                    int id;
                    if(busca== null ||busca.equals("")){
                        x = JOptionPane.showConfirmDialog(null, "El campo de texto esta vacio", "Aviso", JOptionPane.OK_CANCEL_OPTION);
                        if(x != JOptionPane.OK_OPTION){
                            if(JOptionPane.showConfirmDialog(null, "Vas hacer la consulta sin datos, ¿Deseas seguir haciendola?", "Aviso", JOptionPane.YES_NO_OPTION)
                                    != JOptionPane.YES_OPTION){
                                noSalir = false;
                            }
                            
                            
                        }
                    }
                    else
                        try {
                            id = Integer.parseInt(busca);
                            isID = true;
                            noSalir=false;
                        } catch (Exception ex) {
                            isID = false;
                            noSalir=false;
                        }
                } while (noSalir);
                
                
                p1 = new PanelVendedores(vVendedor(busca, isID));

//                try {
//                    ventanaReporte.remove(p);
//                    ventanaReporte.remove(p1);
//                    ventanaReporte.remove(p2);
//                    ventanaReporte.remove(panelNuevaVenta);
//
//                } catch (Exception ex) {
//                    ventanaReporte.add(p1);
//
//                }
//                ventanaReporte.add(p1);
//                ventanaReporte.setpVendedores(p1);
//                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                ventana = new VentanaEmergente("Ventas por vendedores");
                ventana.add(p1);
                ventana.addWindowListener(this);
                ventana.setSize(640, 480);
                ventana.setVisible(true);
                ventanaReporte.validate();
                break;
            case "Productos mas vendidos":
                System.out.println("Aqui se muestran los productos mas vendidos");
                p2 = new PanelProductos();
//                try {
//                    ventanaReporte.remove(p);
//                    ventanaReporte.remove(p1);
//                    ventanaReporte.remove(p2);
//
//                } catch (Exception ex) {
//                    ventanaReporte.add(p2);
//
//                }
//                ventanaReporte.add(p2);
//                ventanaReporte.setpProductos(p2);
                ventana = new VentanaEmergente("Ventas");
                ventana.add(p2);
                ventana.addWindowListener(this);
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
                System.out.println("NUEVA VENTA! YEY");
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
                
                SwingUtilities.updateComponentTreeUI(ventanaReporte);

                break;
                
                
            case "Catalogo de Productos":
                productos = generarCatalogo();
                catalogo = new PanelCatalogo(productos);
                catalogo.addEventos(this);
                trsfiltro = new TableRowSorter(modelo);
                productos.setRowSorter(trsfiltro);
//                ventanaReporte.add(catalogo, "Center");
//                ventanaReporte.setSize(900, 555);
                ventana = new VentanaEmergente("Ventas");
                ventana.add(catalogo);
                ventana.addWindowListener(this);
                ventana.setVisible(true);
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
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
    
    private JTable vVendedor(String busca, boolean isID){
        //busca sera la cadena que buscara la consulta
        //isID buscara en true si se buscará por id y false si se bucara por nombre de usuario 
        DefaultTableModel modeloTabla = new DefaultTableModel();
        JTable tablaVendedor = new JTable();
        String query;
        //depende del id, hara la consulta
        if(isID)
            query = "select detalle_fact.idDetalle_fact, producto.nombreProducto, producto.precio " +
            "from detalle_fact, producto, cab_fact " +
            "where producto.idProducto = detalle_fact.Producto_idProducto and " +
            "cab_fact.idCab_fact = detalle_fact.Cab_fact_idCab_fact and " +
            "cab_fact.Vendedor_idVendedor = "+busca+";";
        else{
             query = "select detalle_fact.idDetalle_fact, producto.nombreProducto, producto.precio " +
            "from detalle_fact, producto, cab_fact, vendedor " +
            "where producto.idProducto = detalle_fact.Producto_idProducto and " +
            "cab_fact.idCab_fact = detalle_fact.Cab_fact_idCab_fact and " +
            "cab_fact.Vendedor_idVendedor = vendedor.idVendedor and "+
            "vendedor.usuario = '"+busca+"';";
             System.out.println(query);
        }
        
       
        try {
            usuario.iniciarConexion();
            usuario.setResult(usuario.getStament().executeQuery(query));
                String columnas [] = new String [usuario.getResult().getMetaData().getColumnCount()];
                for (int i = 0; i < usuario.getResult().getMetaData().getColumnCount(); i++) {
                    columnas[i] = usuario.getResult().getMetaData().getColumnName(i + 1);
                    System.out.println(usuario.getResult().getMetaData().getColumnName(i + 1));
                }

                modeloTabla.setColumnIdentifiers(columnas);
                
                
                String fila[] = new String[usuario.getResult().getMetaData().getColumnCount()];

                while (usuario.getResult().next()) {
                    for (int i = 0; i < usuario.getResult().getMetaData().getColumnCount(); i++) {
                        fila[i] = usuario.getResult().getString(i + 1);
                        System.out.println(usuario.getResult().getString(i + 1));
                    }

                    modeloTabla.addRow(fila);
                }
//            // Bucle para cada resultado en la consulta
           
            tablaVendedor.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            tablaVendedor.setFillsViewportHeight(true);
            tablaVendedor.setModel(modeloTabla);
          
            
            usuario.getStament().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        } finally {
            usuario.cerrarConexion();
        }

        return tablaVendedor;

        
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
      filtro();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        filtro();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       filtro();
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
                System.exit(-1);
            }
        }
    }

}
