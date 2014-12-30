package com.puntoVenta;

import java.awt.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Fernando2
 * Created on Dec 26, 2014, 10:54:26 AM
 */

public class PanelNuevaVenta extends JPanel{
    private JTable ticket;
    private DefaultTableModel modelo;
    private JPanel productos;
    private JPanel panelProductos;
    private JScrollPane scrollTicket;
    private JScrollPane scrollProductos;
    private JTextField textPartida;
    private JTextField textBuscar;
    private JTextField textAtiende;
    private JTextField textTotal;
    private JTextField textPago;
    private JTextField textCambio;
    private JButton buttonBuscar;
    private JButton buttonAgregar;
    private JButton buttonNuevo;
    private JButton buttonGuardar;
    private JButton buttonPagar;
    private final ArrayList<ProductoNuevaVenta> listaProductos;
    private final JTable catalogo;
    private final int anchoBorde;
    private final Conexion conexion;
    
    
    public PanelNuevaVenta(JTable catalogo, Conexion conexion){
        this.catalogo = catalogo;
        this.conexion = conexion;
        anchoBorde = 20;
        listaProductos = new ArrayList<>();
        addComponentes();
    }

    public final void addComponentes(){
        this.setLayout(new BorderLayout());
        
        JPanel este;
//        JPanel centro;
        
        /* Catalogo */
        productos = generarCatalogo();
        
        /* Ticket de compra ... */
        este = generarTicket();

        this.add(productos, "Center");
        this.add(este, "East");
        
        colocarEncabezado();
    }
    
    private JPanel generarCatalogo(){
        JPanel panelCatalogo = new JPanel();
        panelCatalogo.setLayout(new BorderLayout());
        panelCatalogo.setBorder(BorderFactory.createLineBorder(this.getBackground(), anchoBorde));
        
        JPanel norte = new JPanel();
        panelProductos = new JPanel();
        
        /* #Partida, fecha y atiende.... */
        JPanel subNorte1 = new JPanel();
        JPanel subNorte2 = new JPanel();
        JPanel subNorte3 = new JPanel();
        
        textPartida = new JTextField(4);
        textPartida.setEditable(false);
//        textPartida.setText("3426");
        subNorte1.add(new JLabel("Partida #"));
        subNorte1.add(textPartida);
        
        textAtiende = new JTextField(5);
        textAtiende.setEditable(false);
//        textAtiende.setText("Fernando");
        subNorte2.add(new JLabel("Atiende: "));
        subNorte2.add(textAtiende);
        
        Calendar fecha = new GregorianCalendar();
        subNorte3.add(new JLabel("Hoy es: "));
        JTextField textFecha = new JTextField(fecha.get(Calendar.DATE) +
                    "/" + (fecha.get(Calendar.MONTH)+1) + "/" + fecha.get(Calendar.YEAR));
        textFecha.setEditable(false);
        subNorte3.add(textFecha);
        
        norte.add(subNorte1);
        norte.add(subNorte2);
        norte.add(subNorte3);
        
        
        /* Buscar artículos por ID... */
        textBuscar = new JTextField();
        textBuscar.setPreferredSize(new Dimension(350, 30));
        textBuscar.setText("Buscar producto...");
        buttonBuscar = new JButton("Buscar");
        buttonAgregar = new JButton("Agregar");
        
        norte.add(textBuscar);
        norte.add(buttonBuscar);
//        norte.add(buttonAgregar);

        norte.setPreferredSize(new Dimension(400, 90));
        
        /* Panel con la lista de productos */
//        centro.setLayout(new GridLayout(5,5));
        panelProductos.setLayout(new GridLayout(catalogo.getRowCount()/3, 3));
        ProductoNuevaVenta panelProducto;
        
        for(int i = 0; i < catalogo.getRowCount(); i++){
                panelProducto = new ProductoNuevaVenta();
                panelProducto.getId().setText(catalogo.getModel().getValueAt(i, 0) + "");
                panelProducto.getNombre().setText(catalogo.getModel().getValueAt(i, 1) + "");
                panelProducto.setRutaImg((catalogo.getModel().getValueAt(i, 10) + "").replace("src",""));

                panelProducto.getImagen().repaint();
                
                panelProducto.setPrecio(Double.parseDouble(catalogo.getModel().getValueAt(i, 2) + ""));
                panelProducto.setDescripcion(catalogo.getModel().getValueAt(i,4) + "");
                
                listaProductos.add(panelProducto);
                panelProductos.add(panelProducto);
        }
        
        panelProductos.updateUI();
        
        scrollProductos = new JScrollPane(panelProductos);
        scrollProductos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollProductos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        /* Agregamos al panel... */
        panelCatalogo.add(norte, "North");
        panelCatalogo.add(scrollProductos, "Center");
        
        return panelCatalogo;
    }
    
    
    private JPanel generarTicket(){
        JPanel panelTicket = new JPanel();
        panelTicket.setLayout(new BorderLayout());
        panelTicket.setBorder(BorderFactory.createLineBorder(this.getBackground(), anchoBorde));
        
        JPanel sur = new JPanel();
        sur.setLayout(new BorderLayout());
        JPanel subSurC = new JPanel();
        JPanel subSurS = new JPanel();
        
        String[] columnas = {"ID", "Descripción", "Precio", "Cantidad", "Importe"};
        // Filas va vacío para que el ticket aparezca vacío...
        Object[][] filas = {};
        
        // Indicamos que las celdas de la tabla no serán editables...
        modelo = new DefaultTableModel(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        ticket = new JTable(modelo);
        
        // Anchos individuales a las columnas...
        // Ancho total: 360
        ticket.getColumnModel().getColumn(0).setPreferredWidth(20);
        ticket.getColumnModel().getColumn(1).setPreferredWidth(181);
        ticket.getColumnModel().getColumn(2).setPreferredWidth(53);
        ticket.getColumnModel().getColumn(3).setPreferredWidth(43);
        ticket.getColumnModel().getColumn(4).setPreferredWidth(63);
        
        scrollTicket = new JScrollPane(ticket);
        
        scrollTicket.setPreferredSize(new Dimension(360, 300));
        
        panelTicket.add(new JLabel("PinaSports ©"), "North");
        
        Font fuenteTotal = new Font("Arial", Font.PLAIN, 20);
        Font fuentePago = new Font("Arial", Font.PLAIN, 16);
        Font fuenteEt = new Font("Arial", Font.PLAIN, 14);
        
        JPanel subSurPago = new JPanel();
        JPanel subSurCambio = new JPanel();
        
        JLabel labelPago = new JLabel("Su pago:");
        labelPago.setFont(fuenteEt);
        subSurPago.add(labelPago);

        JLabel labelCambio = new JLabel("Su cambio:");
        labelCambio.setFont(fuenteEt);
        subSurCambio.add(labelCambio);
        
        textPago = new JTextField("$ 0.00");
        textCambio = new JTextField("$ 0.00");
        
        textPago.setFont(fuentePago);
        textPago.setEnabled(false);
        textPago.setColumns(6);
        textCambio.setFont(fuentePago);
        textCambio.setEnabled(false);
        textCambio.setEditable(false);
        textCambio.setColumns(6);
        
        subSurPago.add(textPago);
        subSurCambio.add(textCambio);
        
        JPanel subSurCompra = new JPanel();
        subSurCompra.add(subSurPago);
        subSurCompra.add(subSurCambio);
        
        textTotal = new JTextField("$ 0.00");
//        textTotal.setColumns(18);
        textTotal.setPreferredSize(new Dimension(100, 30));
        textTotal.setHorizontalAlignment(JTextField.RIGHT);
        textTotal.setEditable(false);
        textTotal.setBackground(this.getBackground());
        textTotal.setBorder(BorderFactory.createEmptyBorder());
        textTotal.setFont(fuenteTotal);
        
        JPanel subSurTotal = new JPanel();
        JLabel labelTotal = new JLabel("Su total es de: ");
        labelTotal.setFont(fuentePago);
        
        subSurTotal.add(labelTotal);
        subSurTotal.add(textTotal);
        
        subSurC.setLayout(new BorderLayout());
        subSurC.add(subSurCompra, "North");
        subSurC.add(subSurTotal, "East");
        subSurC.setPreferredSize(new Dimension(360, 90));
        
        sur.add(subSurC, "Center");
        sur.setBackground(new Color(235, 231, 236));
        
        buttonNuevo = new JButton("Nueva");
        buttonGuardar = new JButton("Guardar");
        buttonPagar = new JButton("Pagar");
        
        buttonGuardar.setEnabled(false);
        
        subSurS.add(buttonNuevo);
//        subSurS.add(buttonGuardar);
        subSurS.add(buttonPagar);
        
        sur.add(subSurS, "South");
        
        panelTicket.add(scrollTicket, "Center");
        panelTicket.add(sur, "South");
        
        return panelTicket;
    }
    
    // Colocamos el nombre de la persona que atiende y el número de partida...
    public final void colocarEncabezado(){
        String consulta = "SELECT MAX(idCab_fact) FROM Cab_fact";
        int idPartida = 0;
        
        try{
            conexion.iniciarConexion();
            conexion.setResult(conexion.getStament().executeQuery(consulta));
            
            if(conexion.getResult().next()){
                System.out.println("Numero de partida: " + conexion.getResult().getObject(1) + " + 1");
                // Parseo intenso... Recuperamos el valor más alto de idCab_fact y le sumamos 1
                // porque será una nueva partida...

                // Pero si no hay partidas guardadas tratará de parsea un null...
                // entonces lo tomaríamos como un 1.
                try{
                    idPartida = Integer.parseInt(conexion.getResult().getObject(1)+"") + 1;
                }catch(NumberFormatException e){
                    idPartida = 1;
                }finally{
                    textPartida.setText(idPartida+"");
                }
            }
            
            conexion.getStament().close();
        }catch(SQLException e){
            System.out.println("Hubo un error al colocar el encabezado en PanelNuevaVenta: " + e.getMessage());

        } finally{
            conexion.cerrarConexion();
        }
    }
    
    public void addEventos(OyenteNuevaVenta onv){
        textBuscar.addKeyListener(onv);
        textPago.addKeyListener(onv);
        
        textBuscar.addMouseListener(onv);
        textPago.addMouseListener(onv);
        
        ticket.addKeyListener(onv);
        
        buttonBuscar.addActionListener(onv);
        buttonNuevo.addActionListener(onv);
        buttonPagar.addActionListener(onv);
        
        for(ProductoNuevaVenta pnv: listaProductos){
            pnv.addMouseListener(onv);
        }
//    private JTextField textBuscar;
//    private JButton buttonBuscar;
//    private JButton buttonAgregar;
//    private JButton buttonNuevo;
//    private JButton buttonPagar;
    }

    public JButton getButtonPagar() {
        return buttonPagar;
    }
    
    public JTextField getTextPartida() {
        return textPartida;
    }

    public JTextField getTextBuscar() {
        return textBuscar;
    }

    public JTextField getTextAtiende() {
        return textAtiende;
    }

    public JTextField getTextTotal() {
        return textTotal;
    }

    public JTextField getTextPago() {
        return textPago;
    }

    public JTextField getTextCambio() {
        return textCambio;
    }

    public JTable getTicket() {
        return ticket;
    }

    public ArrayList<ProductoNuevaVenta> getListaProductos() {
        return listaProductos;
    }

    public JPanel getPanelProductos() {
        return panelProductos;
    }

    public void setPanelProductos(JPanel panelProductos) {
        this.panelProductos = panelProductos;
    }
    
    public Conexion getConexion() {
        return conexion;
    }
}
