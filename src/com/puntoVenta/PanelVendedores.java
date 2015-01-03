/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JR
 */
public class PanelVendedores extends JPanel{
    JTable tabla = new JTable();
    JPanel datos;
    JScrollPane desplazar ;

    public PanelVendedores() {
        addComponents();
    }

    public PanelVendedores(JTable tabla, JPanel datos) {
        this.tabla = tabla;
        this.datos = datos;
        addComponents();
    }
    
    public void addComponents(){
       this.setLayout(new BorderLayout());
       this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 20));
       desplazar = new JScrollPane(tabla);
       desplazar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       desplazar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
       desplazar.setPreferredSize(new Dimension(this.getWidth(), 200));
      
       this.add(desplazar, BorderLayout.CENTER);
       this.add(datos, BorderLayout.NORTH);
    }
}
