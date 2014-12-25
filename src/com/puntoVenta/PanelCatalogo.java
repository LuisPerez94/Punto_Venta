/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luis
 */
public class PanelCatalogo extends JPanel {

    private final JLabel titulo = new JLabel("Catalogo de productos");
    private JButton busqueda;
    private JTextField tbusqueda;
    private JTable productos;

    public PanelCatalogo(JTable productos) {
        this.productos=productos;
        addComponentes();
    }

    private void addComponentes() {
        this.setLayout(new BorderLayout());
        JPanel panelNorte = new JPanel();
        JPanel panelCentro =new JPanel();
        panelCentro.setBackground(Color.cyan);
        JLabel lbusqueda = new JLabel("Buscar : ");
        
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Realizar una Busqueda");
        panelNorte.setBorder(bordejpanel);
        busqueda = new JButton("Buscar");
        tbusqueda = new JTextField("Ingresa el texto a buscar", 35);
        try {
            panelCentro.add(add(new JScrollPane(productos)));
        } catch (Exception e) {
            panelCentro.add(new JLabel("No hay registros"));
        }
        
        
        panelNorte.add(lbusqueda);
        panelNorte.add(tbusqueda);
        panelNorte.add(busqueda);

        this.add(panelNorte, "North");
        this.add(panelCentro,"Center");
        this.add(titulo, "South");

    }
    
    public void addEventos(){
            }

    public JButton getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(JButton busqueda) {
        this.busqueda = busqueda;
    }

    public JTextField getTbusqueda() {
        return tbusqueda;
    }

    public void setTbusqueda(JTextField tbusqueda) {
        this.tbusqueda = tbusqueda;
    }

    public JTable getProductos() {
        return productos;
    }

    public void setProductos(JTable productos) {
        this.productos = productos;
    }

}
