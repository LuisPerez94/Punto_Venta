/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.awt.Color;
import java.awt.Dimension;
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
       
    public VentanaDeTabla(JTable tabla,Double totalArticulos, Double totalEfectivo) {
        super("Resultados");
        this.tabla=tabla;
        this.totalArticulos=totalArticulos;
        this.totalEfectivo=totalEfectivo;
        setSize(600,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        addComponentes();
        
        setVisible(true);
    }

    
    private void addComponentes() {
        s =new JScrollPane(tabla);
         s.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
            s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
            s.setPreferredSize(new Dimension(590, 390));
            
           
        JPanel panel= new JPanel();
        JPanel panelSur=new JPanel();
        panelSur.add(new JLabel("TOTAL DE ARTICULOS VENDIDOS:  $"+totalArticulos));
        panelSur.add(new JLabel("TOTAL DE EFECTIVO EN EL PERIODO:  $"+totalEfectivo));
        panel.add(s);
        this.add(panel,"Center");
        this.add(panelSur,"South");
       
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    
    
    
    
    
}
