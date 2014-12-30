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
        
        etiqueta.setBackground(Color.WHITE);
     
         
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
