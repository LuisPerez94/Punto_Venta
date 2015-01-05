package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * @author Fernando2
 * Created on Jan 4, 2015, 11:49:29 PM
 */

public class PanelCatalogoClientes extends JPanel{
    private final JTable clientes;
    private JScrollPane scrollClientes;
    
    public PanelCatalogoClientes(JTable clientes){
        this.clientes = clientes;
        
        addComponentes();
    }
    
     private void addComponentes() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));

        try {
            scrollClientes = new JScrollPane(clientes);
            scrollClientes.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
            scrollClientes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollClientes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
            scrollClientes.setPreferredSize(new Dimension(970, 400));
            
//            panelCentro.add(add(new JScrollPane(productos)));
        
        } catch (Exception e) {        
            JOptionPane.showMessageDialog(null, "Ocurrió un error al generar el catálogo\n"+e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        JPanel centro = new JPanel();
        centro.add(scrollClientes);

        this.add(centro, "Center");
    }
}
