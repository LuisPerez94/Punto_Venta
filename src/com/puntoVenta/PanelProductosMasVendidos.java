package com.puntoVenta;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

/**
 *
 * @author Fernando2
 */
public class PanelProductosMasVendidos extends JPanel {

    private JTable productos;
    private DefaultTableModel modelo;
    private JComboBox comboFechas;
    private JButton guardar;
    private JButton limpiar;
    private JButton ejecutar;
    String opcion;

    public PanelProductosMasVendidos(String opcion) {
        addComponentes(opcion);
    }

    public final void addComponentes(String opcion) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        String[] columnas;
        Object[][] filas={};
          JScrollPane scrollProductos = null;
        JPanel norte = new JPanel();
        JPanel norteO = new JPanel();
        JPanel norteE = new JPanel();
        JPanel centro = new JPanel();

        JLabel labelFechas = new JLabel("Más vendidos de:");
        labelFechas.setVerticalAlignment(JLabel.CENTER);

        guardar = new JButton("Exportar");
        limpiar = new JButton("Limpiar");
        ejecutar = new JButton("Ejecutar vista");

        switch (opcion) {
            case "masVendidos":
                columnas = new String[]{"Código","Nombre","Cantidad vendidos"};
 
            modelo = new DefaultTableModel(filas, columnas);

            // Indicamos que las celdas de la tabla no serán editables...
            modelo = new DefaultTableModel(filas, columnas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            productos = new JTable(modelo);

            scrollProductos = new JScrollPane(productos);
            scrollProductos.setPreferredSize(new Dimension(800, 320));

//        // Anchos individuales a las columnas...
//        // Ancho total: 800
            productos.getColumnModel().getColumn(0).setPreferredWidth(60);
            productos.getColumnModel().getColumn(1).setPreferredWidth(135);
            productos.getColumnModel().getColumn(2).setPreferredWidth(255);
            break;
            case "ventasXVendedor":
                columnas = new String[]{"IdVendedor", "Numero De Ventas","AP PATERNO","AP MATERNO"
                ,"NOMBRE"};
          

            modelo = new DefaultTableModel(filas, columnas);

            // Indicamos que las celdas de la tabla no serán editables...
            modelo = new DefaultTableModel(filas, columnas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            productos = new JTable(modelo);

             scrollProductos = new JScrollPane(productos);
            scrollProductos.setPreferredSize(new Dimension(800, 320));

//        // Anchos individuales a las columnas...
//        // Ancho total: 800
            int ancho=800/5;
            productos.getColumnModel().getColumn(0).setPreferredWidth(ancho);
            productos.getColumnModel().getColumn(1).setPreferredWidth(ancho);
            productos.getColumnModel().getColumn(2).setPreferredWidth(ancho);
            productos.getColumnModel().getColumn(3).setPreferredWidth(ancho);
            productos.getColumnModel().getColumn(4).setPreferredWidth(ancho);

            break;
        }
        /**
         * *
         */

//        norteO.add(labelFechas);
//        norteO.add(comboFechas);
        norteO.add(ejecutar);

        norteE.add(new JLabel(new ImageIcon("src/img/sistema/excel.png")));
        norteE.add(guardar);
        norteE.add(limpiar);

        norte.setLayout(new BorderLayout());
        norte.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        norte.add(norteO, "West");
        norte.add(norteE, "East");

        centro.add(scrollProductos);
        centro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));

        /**
         * *
         */
        this.add(norte, "North");
        this.add(centro, "Center");
    }

    public void addEventos(OyenteProductosMasVendidos oyente) {
       
        guardar.addActionListener(oyente);
        limpiar.addActionListener(oyente);
        ejecutar.addActionListener(oyente);
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
