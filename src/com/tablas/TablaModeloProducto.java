/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tablas;

import com.puntoVenta.Producto;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luis
 */
public class TablaModeloProducto extends AbstractTableModel {

    private String[] nombreColumnas = {"Código", "Nombre", "Precio", "Imagen",
        "Descripción", "Existencia"};
    ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        fireTableDataChanged();

    }

    public void eliminarProducto(int index) {
        productos.remove(index);
        fireTableDataChanged();
    }

    public void limpiarProductos() {
        productos.clear();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return nombreColumnas[columnIndex];
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return productos.get(rowIndex).getIdProducto();
            case 1:
                return productos.get(rowIndex).getNombreProducto();
            case 2:
                return productos.get(rowIndex).getPrecio();
            case 3:
                return productos.get(rowIndex).getImg();
            case 4:
                return productos.get(rowIndex).getDescripcion();
            case 5:
                return productos.get(rowIndex).getExistencia();
            case 10:
                return productos.get(rowIndex).getRuta();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {

        if (columnIndex == 3) {
            return ImageIcon.class;
        } else {
            return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Producto producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                producto.setIdProducto((Integer) value);

            case 1:
                producto.setNombreProducto((String) value);
            case 2:
                producto.setPrecio((Float) value);
            case 3:
                producto.setImg((ImageIcon) value);
            case 4:
                producto.setDescripcion((String) value);

        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public String[] getNombreColumnas() {
        return nombreColumnas;
    }

    public void setNombreColumnas(String[] nombreColumnas) {
        this.nombreColumnas = nombreColumnas;
    }

}
