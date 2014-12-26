/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author luis
 */
public class TablaRenderizadorProducto implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);
        if (row % 2 == 0) {
            etiqueta.setBackground(new Color(255, 255, 200));
        } else {
            etiqueta.setBackground(Color.white);
        }
        if (value instanceof String) {
            String nombre = (String) value;
            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            if (nombre.startsWith("#")) { //Hombre
                etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/recursos/user.png"))); // NOI18N
            } else if (nombre.startsWith("&")) { //Mujer
                etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/blogspot/rolandopalermo/recursos/user2.png"))); // NOI18N
            }
            etiqueta.setText(value.toString().substring(1, nombre.length()));
        } else {
            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            etiqueta.setText(value.toString());
        }
         
        if (value  instanceof  ImageIcon) {
             ImageIcon icon = (ImageIcon) value;
            etiqueta.setIcon(icon);
            
        }
        
        if (isSelected) {
            etiqueta.setBackground(new Color(151, 193, 215));
        }
        return etiqueta;
    }
    
    
    
}
