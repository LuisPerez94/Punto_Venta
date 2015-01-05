package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

/**
 * @author Fernando2
 * Created on Jan 5, 2015, 12:33:26 AM
 */

public class PanelCatalogoVendedores extends JPanel{
    private final JTable vendedores;
    private JScrollPane scrollVendedores;
    
    public PanelCatalogoVendedores(JTable vendedores){
        this.vendedores = vendedores;
        
        addComponentes();
    }
    
     private void addComponentes() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));

        try {
            scrollVendedores = new JScrollPane(vendedores);
            scrollVendedores.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
            scrollVendedores.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollVendedores.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           
            scrollVendedores.setPreferredSize(new Dimension(970, 400));
            
//            panelCentro.add(add(new JScrollPane(productos)));
        
        } catch (Exception e) {        
            JOptionPane.showMessageDialog(null, "Ocurrió un error al generar el catálogo\n"+e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        JPanel centro = new JPanel();
        centro.add(scrollVendedores);

        this.add(centro, "Center");
    }
}
