/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import com.formularios.AgregarCliente;
import com.formularios.AgregarProducto;
import com.formularios.AgregarVendedor;
import com.oyentes.OyenteAgregarCliente;
import com.oyentes.OyenteAgregarProducto;
import com.oyentes.OyenteAgregarVendedor;
import com.oyentes.OyenteReporteVentas;
import com.tablas.TablaModeloProducto;
import com.tablas.TablaRenderizadorProducto;
import com.modificar.*;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class OyenteReportes implements KeyListener, ActionListener, WindowListener {

    private Conexion usuario;
    static Reportes ventanaReporte;
    private JTable tablaCatalogo;
    private PanelVentas p;
    private PanelVendedores p1;
    private PanelProductosMasVendidos ppmv;
    private PanelProductos p2;
    private PanelCatalogoProductos catalogoProductos;
    private PanelCatalogoClientes catalogoClientes;
    private PanelCatalogoVendedores catalogoVendedores;
    private PanelNuevaVenta panelNuevaVenta;
    private VentanaEmergente ventana;
    private TableRowSorter trsfiltro;
    private com.tablas.TablaModeloProducto modelo;
    private DefaultTableModel modeloTabla;
    private String nombreVendedor;
    private boolean ctrl = false;
    private boolean alt = false;

    OyenteReportes() {
        panelNuevaVenta = null;
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
                p = new PanelVentas();

                ventana = new VentanaEmergente("Ventas");
                ventana.add(p);
                ventana.addWindowListener(this);
                ventana.setSize(570, 210);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
                ventana.setVisible(true);
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                ventanaReporte.validate();

                p.addEventos(new OyenteReporteVentas(p, usuario, ventana));

                break;

            case "Ventas por vendedor":
        {
            try {
                BuscarVendedor busqueda = new BuscarVendedor();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

                break;

            case "Productos más vendidos":

                System.out.println("Aqui se muestran los productos mas vendidos");

                ppmv = new PanelProductosMasVendidos();

                ventana = new VentanaEmergente("Productos más vendidos");
                OyenteProductosMasVendidos oppmv = new OyenteProductosMasVendidos(ppmv, usuario);
                ppmv.addEventos(oppmv);

                ventana.setSize(850, 450);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
                ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventana.add(ppmv);

                ventana.addWindowListener(oppmv);
                ventana.setVisible(true);

                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                ventanaReporte.validate();
                break;

            case "Cerrar sesión":
                int opcion = JOptionPane.showConfirmDialog(ventanaReporte, "Se cerrará la sesión actual",
                        "Cerrar sesión", JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    ventanaReporte.dispose();
                    main.mostrarLogin();
                }
                break;

            case "Manual técnico":
                if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File("src/help/manualTecnico.pdf");
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException ex) {
                        // no application registered for PDFs
                        JOptionPane.showMessageDialog(ventana, "Ocurrió un error al abrir el manual",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(ventana, "Ocurrió un error al abrir el manual",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;

            case "Manual de usuario":
                if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File("src/help/manualUsuario.pdf");
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException ex) {
                        // no application registered for PDFs
                        JOptionPane.showMessageDialog(ventana, "Ocurrió un error al abrir el manual",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(ventana, "Ocurrió un error al abrir el manual",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }

                break;

            case "Acerca de":
                System.out.println("Mostrara acerca del programa");
                JOptionPane.showMessageDialog(null, "PiñaSports®"
                        + "\nVersión 1.0.0"
                        + "\nCopyright© 2014 - 2015"
                        + "\nTodos los derechos reservados"
                        + "\nEste software fue desarrollado por:"
                        + "\n     Bobadilla Contreras Miguel Fernando"
                        + "\n     Márquez Solano José Ramón"
                        + "\n     Pérez Muñoz Luis Ángel"
                        + "\n     Pérez Rodríguez José Rubén",
                        "Acerca de", JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("src/img/sistema/acercaDe.png"));

                break;

            // Este qué hace? :v
            case "Actualizar":
                System.out.println("Aqui actualizara");
                break;

            case "Nueva venta":
                ventana = new VentanaEmergente("Ventas");

                JTable prods = null;
        try {
            prods = generarCatalogoProductos();
        } catch (SQLException ex) {
            Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        {
            try {
                panelNuevaVenta = new PanelNuevaVenta(prods, usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                panelNuevaVenta.getTextAtiende().setText(nombreVendedor);

                OyenteNuevaVenta oyenteNV = new OyenteNuevaVenta(ventana, panelNuevaVenta);

                panelNuevaVenta.addEventos(oyenteNV);

                ventana.add(panelNuevaVenta);
                ventana.setSize(900, 555);
                ventana.setLocationRelativeTo(null);
                ventana.addWindowListener(this);
                ventana.setVisible(false);
        {
            try {
                oyenteNV.validarNuevaVenta();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Clientes":
        {
            try {
                tablaCatalogo = generarCatalogoClientes();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                catalogoClientes = new PanelCatalogoClientes(tablaCatalogo);
//                catalogoClientes.addEventos(this);

                ventana = new VentanaEmergente("Clientes");
                ventana.add(catalogoClientes);
                ventana.addWindowListener(this);
                ventana.setSize(980, 460);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
                ventana.setVisible(true);

                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                break;

            case "Vendedores":
        {
            try {
                tablaCatalogo = generarCatalogoVendedores();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                catalogoVendedores = new PanelCatalogoVendedores(tablaCatalogo);
//                catalogoClientes.addEventos(this);

                ventana = new VentanaEmergente("Vendedores");
                ventana.add(catalogoVendedores);
                ventana.addWindowListener(this);
                ventana.setSize(980, 460);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
                ventana.setVisible(true);

                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                break;

            case "Productos":
        
            try {
                tablaCatalogo = generarCatalogoProductos();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                catalogoProductos = new PanelCatalogoProductos(tablaCatalogo);
                catalogoProductos.addEventos(this);
                trsfiltro = new TableRowSorter(modelo);
                tablaCatalogo.setRowSorter(trsfiltro);

                ventana = new VentanaEmergente("Productos");
                ventana.add(catalogoProductos);
                ventana.addWindowListener(this);
                ventana.setSize(900, 520);
                ventana.setLocationRelativeTo(null);
                ventana.setResizable(false);
                ventana.setVisible(true);
                SwingUtilities.updateComponentTreeUI(ventanaReporte);
                break;

            case "Agregar un producto":
                AgregarProducto aP = new AgregarProducto();
        {
            try {
                usuario.iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

                aP.addEventos(new OyenteAgregarProducto(aP, usuario));

                break;

            case "Agregar un cliente":
                AgregarCliente aC = new AgregarCliente();
        {
            try {
                usuario.iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                aC.addEventos(new OyenteAgregarCliente(aC, usuario));
                break;

            case "Agregar un vendedor":
                AgregarVendedor aV = new AgregarVendedor();
        {
            try {
                usuario.iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                aV.addEventos(new OyenteAgregarVendedor(usuario, aV));
                break;

            case "Modificar un cliente":
        {
            try {
                //                System.out.println("Mod cliente");
                ModificarCliente mc = new ModificarCliente(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Modificar un vendedor":
                System.out.println("Mod vendedor");
        {
            try {
                usuario.iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        {
            try {
                ModificarVendedor mv = new ModificarVendedor(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Modificar un producto":
                System.out.println("Mod producto");
        {
            try {
                ModificarProducto mp = new ModificarProducto(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Eliminar un cliente":
        {
            try {
                EliminarCliente ec = new EliminarCliente(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                System.out.println("DEl cliente");
                break;

            case "Eliminar un vendedor":
                System.out.println("del vendedor");
        {
            try {
                EliminarVendedor ev = new EliminarVendedor(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "Eliminar un producto":
                System.out.println("del producto");
        {
            try {
                EliminarProducto ep = new EliminarProducto(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "Eliminar cabecera factura":
                System.out.println("Eliminar cabecera");
                EliminarCabecera EC = new EliminarCabecera(usuario);
                break;

            case "Eliminar detalle factura":
                System.out.println("Eliminar detalle ");
                EliminarDetalle ed = new EliminarDetalle(usuario);
                break;

            case "Almacén":
        {
            try {
                usuario.iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                String consulta = "select Producto.idProducto, Producto.nomProducto, Almacen.idAlmacen\n"
                        + "from Producto, Almacen, Guarda\n"
                        + "where Producto.idProducto = Guarda.idProducto\n"
                        + "and Almacen.idAlmacen = Guarda.idAlmacen";
                TablaConsulta tc = new TablaConsulta(usuario.getStament(), consulta, 1);
        {
            try {
                usuario.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "Agregar almacen":
                int x = 0;
                if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(ventana, "Agregar un nuevo almacen?",
                        "Advertencia", JOptionPane.OK_CANCEL_OPTION)) {
                    try {
                        usuario.iniciarConexion();
                        usuario.setResult(usuario.getStament().executeQuery("SELECT count(Almacen.idAlmacen) FROM Almacen"));
                        while (usuario.getResult().next()) {
                            x = usuario.getResult().getInt(1);

                        }
                        usuario.getStament().execute("INSERT INTO Almacen (idAlmacen) VALUES ('"
                                + (x + 1) + "');");

                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                    JOptionPane.showMessageDialog(ventana, "Se agrego registro",
                            "Agregado", JOptionPane.DEFAULT_OPTION);
                }

                break;
            case "Eliminar almacen":
        {
            try {
                EliminarAlmacen ea = new EliminarAlmacen(usuario);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteReportes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

                break;

        }
    }

    public void filtro() {
        try {
            String filtro = catalogoProductos.getTbusqueda().getText();
            switch (catalogoProductos.getBusqueda().getSelectedIndex()) {
                case 0:
                    trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)" + filtro, 0));
                    break;
                case 1:
                    trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)" + filtro, 1));
                    break;
                case 2:
                    trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)" + filtro, 2));
                    break;
                case 3:
                    trsfiltro.setRowFilter(RowFilter.regexFilter("(?i)" + filtro, 4));
                    break;

            }

        } catch (NullPointerException e) {
        }

    }

    private JTable generarCatalogoClientes() throws SQLException {
        String query = "SELECT * FROM Cliente";
        String[] columnas = {"ID", "Nombre", "Ap. paterno", "Ap. materno", "Dirección",
            "Correo electrónico", "Teléfono", "Sexo"};
        Object[][] filas = {};

        modeloTabla = new DefaultTableModel(filas, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tablaClientes = new JTable(modeloTabla);

        Object[] auxFila = new Object[modeloTabla.getColumnCount()];

        try {
            usuario.iniciarConexion();
            usuario.setResult(usuario.getStament().executeQuery(query));

            while (usuario.getResult().next()) {
                for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
                    auxFila[i] = usuario.getResult().getObject((i + 1)) + "";
                }
                modeloTabla.addRow(auxFila);
            }

            usuario.getStament().close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ventana, "Ocurrió un error al generar el catálogo\n" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        } finally {
            usuario.cerrarConexion();
        }

        return tablaClientes;
    }

    private JTable generarCatalogoVendedores() throws SQLException {
        String query = "SELECT * FROM Vendedor";
        String[] columnas = {"ID", "Nombre", "Ap. paterno", "Ap. materno", "Fecha nacimiento",
            "Correo electrónico", "Dirección", "Sueldo",
            "Fecha ingreso", "Sexo"};
        Object[][] filas = {};

        modeloTabla = new DefaultTableModel(filas, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tablaVendedores = new JTable(modeloTabla);

        Object[] auxFila = new Object[modeloTabla.getColumnCount()];

        try {
            usuario.iniciarConexion();
            usuario.setResult(usuario.getStament().executeQuery(query));

            while (usuario.getResult().next()) {
                for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
                  
                        auxFila[i] = usuario.getResult().getObject((i + 1)) + "";
                   
                }
                modeloTabla.addRow(auxFila);
            }

            usuario.getStament().close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ventana, "Ocurrió un error al generar el catálogo\n" + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        } finally {
            usuario.cerrarConexion();
        }

        return tablaVendedores;
    }

    private JTable generarCatalogoProductos() throws SQLException {
        String query = "SELECT * FROM Producto";

        modelo = new TablaModeloProducto() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
//                    System.out.println("CATALOGO PRODUCTOS: " + usuario.getResult().getObject((1+i)).toString());
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
            JOptionPane.showMessageDialog(ventana, "Ocurrió un error al generar el catálogo\n" + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
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
        try {
            filtro();

        } catch (NullPointerException ex) {
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //filtro();
        try {
            if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
                ctrl = true;

            }
            if (e.getKeyCode() == KeyEvent.VK_ALT) {
                alt = true;

            }

            if (ctrl && alt && e.getKeyCode() == KeyEvent.VK_C) {
                System.out.println("Area de consulta oculta");
                AreaConsulta a = new AreaConsulta();
                ctrl = false;
                alt = false;
            }
        } catch (NullPointerException ex) {
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
            int opcion = JOptionPane.showConfirmDialog(ventanaReporte,
                    "Se cerrará la sesión actual", "Advertencia", JOptionPane.OK_CANCEL_OPTION);

            if (opcion == JOptionPane.OK_OPTION) {
                ventanaReporte.dispose();
                main.mostrarLogin();
            }
        }
    }

}
