/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JR
 */
public class PanelProductos extends JPanel{
    JTable tabla;
    DefaultTableModel modelo ;
    JScrollPane desplazar ;
    JLabel productos = new JLabel("Productos mas vendidos");
    
    public PanelProductos(){
        this.setLayout(new BorderLayout());
        tabla = new JTable ();
        modelo = new DefaultTableModel();
        desplazar = new JScrollPane(tabla);
        tabla.setModel(modelo);
                  
        JButton b = new JButton("Actualizar");
        b.addActionListener(new OyenteReportes());
        
        JPanel norte = new JPanel(new BorderLayout());
        norte.add(productos, BorderLayout.NORTH);
        JPanel botonP = new JPanel();
        botonP.add(b);
        norte.add(botonP, BorderLayout.SOUTH);
        
        
        JPanel sur = new JPanel();
        sur.add(desplazar);
        
        this.add(norte, BorderLayout.NORTH);
        this.add(sur, BorderLayout.SOUTH);
        
        
    }
    
}
