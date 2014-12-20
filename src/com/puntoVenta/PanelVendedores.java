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
    JTable tabla;
    DefaultTableModel modelo ;
    JScrollPane desplazar ;
    JLabel idVendedorL;
    JTextField idVendedorT;
    JButton buscar = new JButton ("Buscar");
    public PanelVendedores(){
        this.setLayout(new BorderLayout());
        tabla = new JTable ();
        modelo = new DefaultTableModel();
        desplazar = new JScrollPane(tabla);
        tabla.setModel(modelo);
        
        idVendedorL = new JLabel("id del Vendedor");
        idVendedorT = new JTextField(20);
        buscar.addActionListener(new OyenteReportes());
        
        JPanel panelNorte = new JPanel();
        panelNorte.add(idVendedorL);
        panelNorte.add(idVendedorT);
        panelNorte.add(buscar);
        this.add(panelNorte, BorderLayout.NORTH);
        
        JPanel panelSur = new JPanel();
        panelSur.add(desplazar);
        this.add(panelSur, BorderLayout.SOUTH);
        
        
    }
}
