/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author luis
 */
public class VentanaDeTabla extends JFrame{
       private  JTable tabla;
       private JScrollPane s;
       private Double  totalArticulos;
       private Double totalEfectivo;
       private String fecha1;
       private String fecha2;
       
    public VentanaDeTabla(JTable tabla,Double totalArticulos, Double totalEfectivo,String fecha1, String fecha2) {
        super("Resultados");
        this.tabla = tabla;
        this.totalArticulos = totalArticulos;
        this.totalEfectivo = totalEfectivo;
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        setSize(700,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        addComponentes();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        this.setResizable(false);
        setVisible(true);
    }

    
    private void addComponentes() {
        s = new JScrollPane(tabla);
        s.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        s.setPreferredSize(new Dimension(700, 390));
        
        JPanel panelNorte = new JPanel();
        panelNorte.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JLabel labelNorte = new JLabel("Reporte de ventas del " + fecha1 + " al " + fecha2);
        panelNorte.add(labelNorte);
        
        JPanel panelCentro = new JPanel();
        
        JPanel panelSur =new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JLabel labelTotal = new JLabel("Total de artículos vendidos: " + totalArticulos);
        panelSur.add(labelTotal, "North");
        labelTotal.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JLabel labelIngresos = new JLabel("Total de ingresos en el período:  $" + totalEfectivo);
        panelSur.add(labelIngresos, "South");
        labelIngresos.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        
        panelCentro.add(s);
        
        this.add(panelNorte, "North");
        this.add(panelCentro,"Center");
        this.add(panelSur,"South");
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }
    
}
