/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
    
    JScrollPane desplazar ;
    
    

    public PanelVendedores() {
        addComponents();
    }

   
    

    public PanelVendedores(JTable tabla) {
        this.tabla = tabla;
        addComponents();
    }
    
    
    public void addComponents(){
       
       desplazar = new JScrollPane(tabla);
      
       JPanel panelInt = new JPanel(new BorderLayout());
       panelInt.add(desplazar, BorderLayout.NORTH);
      
       this.add(panelInt);
    }
}
