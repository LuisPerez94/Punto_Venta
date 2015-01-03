/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JLabel titulo;
    private JComboBox busqueda;
    private JTextField tbusqueda;
    private JTable productos;
    private JScrollPane scrollProductos;

    public PanelCatalogo(JTable productos) {
        this.productos = productos;
        addComponentes();
    }

    public PanelCatalogo() {
        addComponentes();
    }
    

    private void addComponentes() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        String busquedas[] = new String []{"Id","Nombre","Precio","Descripción"};
        JPanel panelNorte = new JPanel();
        JPanel panelCentro = new JPanel();
        JLabel lbusqueda = new JLabel("Buscar: ");
        
        Border bordejpanel = new TitledBorder(new EtchedBorder(10), "Realizar una Busqueda");
        panelNorte.setBorder(bordejpanel);

        busqueda = new JComboBox(busquedas);
        tbusqueda = new JTextField("Ingresa el texto a buscar", 35);
        
        try {
            scrollProductos = new JScrollPane(productos);
            scrollProductos.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
            scrollProductos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollProductos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
            scrollProductos.setPreferredSize(new Dimension(900, 400));
            
            panelCentro.add(scrollProductos);
//            panelCentro.add(add(new JScrollPane(productos)));
        
        } catch (Exception e) {
            panelCentro.add(new JLabel("No hay registros"));
        }
        
        busqueda.setSelectedIndex(1);
        
        panelNorte.add(lbusqueda);
        panelNorte.add(tbusqueda);
        panelNorte.add(new JLabel("Buscar por:"));
        panelNorte.add(busqueda);
        
        titulo = new JLabel("Catálogo de productos");
        titulo.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));

        this.add(panelNorte, "North");
        this.add(panelCentro,"Center");
        this.add(titulo, "South");

    }
    
    public void addEventos(OyenteReportes o){
            tbusqueda.addKeyListener(o);
        }

    public JComboBox getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(JComboBox busqueda) {
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
