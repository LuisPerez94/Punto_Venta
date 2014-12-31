package com.puntoVenta;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

/**
 *
 * @author Fernando2
 */

public class PanelProductosMasVendidos extends JPanel{
    private JTable productos;
    private DefaultTableModel modelo;
    private JComboBox comboFechas;
    private JButton guardar;
    private JButton limpiar;
    
    public PanelProductosMasVendidos(){
        addComponentes();
    }
    
    public final void addComponentes(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        
        JPanel norte = new JPanel();
        JPanel norteO = new JPanel();
        JPanel norteE = new JPanel();
        JPanel centro = new JPanel();
        
        JLabel labelFechas = new JLabel("Más vendidos de:");
        labelFechas.setVerticalAlignment(JLabel.CENTER);
        
        String[] fechas = {"Escoja rango","General", "Hoy", "Ayer", "Antier", "La semana pasada",
                            "El mes pasado", "El año pasado", "Personalizado..."};
        comboFechas = new JComboBox(fechas);
        
        guardar = new JButton("Exportar");
        limpiar = new JButton("Limpiar");
        
        String[] columnas = {"Código", "Nombre", "Descripción", "Precio unitario",
                                "Cantidad vendidos", "Ingreso por producto"};
        Object[][] filas = {};
        
        modelo = new DefaultTableModel(filas, columnas);
        
        // Indicamos que las celdas de la tabla no serán editables...
        modelo = new DefaultTableModel(filas, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        productos = new JTable(modelo);
        
        JScrollPane scrollProductos = new JScrollPane(productos);
        scrollProductos.setPreferredSize(new Dimension(800, 420));
        
//        // Anchos individuales a las columnas...
//        // Ancho total: 800
        productos.getColumnModel().getColumn(0).setPreferredWidth(60);
        productos.getColumnModel().getColumn(1).setPreferredWidth(135);
        productos.getColumnModel().getColumn(2).setPreferredWidth(255);
        productos.getColumnModel().getColumn(3).setPreferredWidth(95);
        productos.getColumnModel().getColumn(4).setPreferredWidth(115);
        productos.getColumnModel().getColumn(5).setPreferredWidth(140);
        /** **/
        
        norteO.add(labelFechas);
        norteO.add(comboFechas);
        
        norteE.add(new JLabel(new ImageIcon("src/img/sistema/excel.png")));
        norteE.add(guardar);
        norteE.add(limpiar);
        
        norte.setLayout(new BorderLayout());
        norte.setBorder(BorderFactory.createLineBorder(this.getBackground(),10));
        norte.add(norteO, "West");
        norte.add(norteE, "East");
        
        centro.add(scrollProductos);
        centro.setBorder(BorderFactory.createLineBorder(this.getBackground(),10));
        
        /** **/
        
        this.add(norte, "North");
        this.add(centro, "Center");
    }
    
    public void addEventos(OyenteProductosMasVendidos oyente){
        comboFechas.addActionListener(oyente);
        guardar.addActionListener(oyente);
        limpiar.addActionListener(oyente);
    }

    public JTable getProductos() {
        return productos;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JComboBox getComboFechas() {
        return comboFechas;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public JButton getLimpiar() {
        return limpiar;
    }
    
    
}
