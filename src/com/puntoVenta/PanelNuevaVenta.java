package com.puntoVenta;

import java.awt.*;
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
    private final int anchoBorde;
    
    
    public PanelNuevaVenta(){
        anchoBorde = 20;
        addComponentes();
    }

    public final void addComponentes(){
        this.setLayout(new BorderLayout());
        
        JPanel este;
        JPanel centro;
        
        /* Catalogo */
        centro = generarCatalogo();
        
        /* Ticket de compra ... */
        este = generarTicket();

        this.add(centro, "Center");
        this.add(este, "East");
    }
    
    private JPanel generarCatalogo(){
        JPanel panelCatalogo = new JPanel();
        panelCatalogo.setLayout(new BorderLayout());
        panelCatalogo.setBorder(BorderFactory.createLineBorder(this.getBackground(), anchoBorde));
        
        JPanel norte = new JPanel();
        JPanel centro = new JPanel();
        
        /* #Partida, fecha y atiende.... */
        JPanel subNorte1 = new JPanel();
        JPanel subNorte2 = new JPanel();
        JPanel subNorte3 = new JPanel();
        
        textPartida = new JTextField(4);
        textPartida.setEditable(false);
        textPartida.setText("3426");
        subNorte1.add(new JLabel("Partida #"));
        subNorte1.add(textPartida);
        
        textAtiende = new JTextField(5);
        textAtiende.setEditable(false);
        textAtiende.setText("Fernando");
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
        textBuscar = new JTextField(20);
        textBuscar.setText("Buscar producto...");
        buttonBuscar = new JButton("Buscar");
        buttonAgregar = new JButton("Agregar");
        
        norte.add(textBuscar);
        norte.add(buttonBuscar);
        norte.add(buttonAgregar);

        norte.setPreferredSize(new Dimension(400, 90));
        
        /* Panel con la lista de productos */
        centro.setLayout(new GridLayout(10,5));
        JPanel panelProducto;
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 5; j++){
                panelProducto = new JPanel();
                panelProducto.setBackground(new Color((int) (Math.random() * 255),
                                                (int) (Math.random() * 255),
                                                    (int) (Math.random() * 255)));
                panelProducto.setPreferredSize(new Dimension(85, 75));
                centro.add(panelProducto);
            }
        }
        
        scrollProductos = new JScrollPane(centro);
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
        Object[][] filas = {
                                {1, "Camiseta de algodón talla M", 200, 2, 400}, 
                                {2, "Balón de basquetbol tamaño 5", 250, 1, 250}, 
                                {3, "Rodilleras de bronce", 300, 3, 900}, 
                                {4, "Coderas de bronce", 300, 3, 900},
                                {5, "SmartBand marca Microsoft", 4000, 1, 4000}
                            };
        
        // Indicamos que solo las celdas de la columna 3 serán editables...
        modelo = new DefaultTableModel(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 3) return true;
                else return false;
            }
        };
        
        ticket = new JTable(modelo);
        
        // Anchos individuales a las columnas...
        ticket.getColumnModel().getColumn(0).setPreferredWidth(20);
        ticket.getColumnModel().getColumn(1).setPreferredWidth(185);
        ticket.getColumnModel().getColumn(2).setPreferredWidth(45);
        ticket.getColumnModel().getColumn(3).setPreferredWidth(55);
        ticket.getColumnModel().getColumn(4).setPreferredWidth(55);
        
        scrollTicket = new JScrollPane(ticket);
        
        scrollTicket.setPreferredSize(new Dimension(360, 300));
        
        panelTicket.add(new JLabel("PinaSports ©"), "North");
        
        Font fuenteTotal = new Font("Arial", Font.BOLD, 20);
        
        textTotal = new JTextField("$6450.00");
        textTotal.setEditable(false);
        textTotal.setBorder(null);
        textTotal.setBackground(new Color(235, 231, 236));
        textTotal.setFont(fuenteTotal);
        
        subSurC.setLayout(new BorderLayout());
        subSurC.add(textTotal, "East");
        subSurC.setPreferredSize(new Dimension(360, 70));
        subSurC.setBackground(new Color(235, 231, 236));
        
        sur.add(subSurC, "Center");
        
        
        buttonNuevo = new JButton("Nueva");
        buttonGuardar = new JButton("Guardar");
        buttonPagar = new JButton("Pagar");
        
        buttonGuardar.setEnabled(false);
        
        subSurS.add(buttonNuevo);
        subSurS.add(buttonGuardar);
        subSurS.add(buttonPagar);
        
        sur.add(subSurS, "South");
        
        panelTicket.add(scrollTicket, "Center");
        panelTicket.add(sur, "South");
        
        return panelTicket;
    }
}
