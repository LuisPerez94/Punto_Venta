package com.puntoVenta;

import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

/**
 * @author Fernando2
 * Created on Dec 30, 2014, 6:01:58 PM
 */

public class OyenteProductosMasVendidos extends WindowAdapter implements ActionListener{
    private BuscarProductosMasVendidos bpmv;
    private final Conexion conexion;
    private final PanelProductosMasVendidos panel;
    private final DefaultTableModel modelo;
    private boolean correcto;
    
    public OyenteProductosMasVendidos(PanelProductosMasVendidos panel, Conexion conexion){
        bpmv = null;
        this.panel = panel;
        this.conexion = conexion;
        correcto = true;
        modelo = (DefaultTableModel) panel.getProductos().getModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String etiqueta = e.getActionCommand();
        
        switch(etiqueta){
            case "comboBoxChanged":
        {
            try {
                ajustarRango();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteProductosMasVendidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
                
            case "Exportar":
                exportarTabla();
                break;
                
            case "Limpiar":
                limpiarTabla();
                break;
                
            case "Buscar":
                rangoPersonalizado();
                break;
                
            case "Cancelar":
                bpmv.dispose();
                break;
        }
    }
    
    public void ajustarRango() throws SQLException{
        String rango = panel.getComboFechas().getSelectedItem()+"";
        String query = "AND Detalle_fact.fechaVenta < CURDATE() AND Detalle_fact.fechaVenta"
                + " >= DATE_SUB(CURDATE(), INTERVAL";
        
        switch(rango){
            case "General":
                query = "";
                limpiarTabla();
                productosMasVendidos(query);
                break;
                
            case "Hoy":
                query = "AND Detalle_fact.fechaVenta = CURDATE()";
                limpiarTabla();
                productosMasVendidos(query);
                
                break;
                
            case "Ayer":
                query += " 1 DAY)";
                limpiarTabla();
                productosMasVendidos(query);
                break;
                
            case "Antier":
                query = "AND Detalle_fact.fechaVenta = DATE_SUB(CURDATE(), INTERVAL 2 DAY)";
                limpiarTabla();
                productosMasVendidos(query);
                break;
                
            case "La semana pasada":
                query += " 1 WEEK)";
                limpiarTabla();
                productosMasVendidos(query);
                break;
                
            case "El mes pasado":
                query += " 1 MONTH)";
                limpiarTabla();
                productosMasVendidos(query);
                break;
                
            case "El año pasado":
                query += " 1 YEAR)";
                limpiarTabla();
                productosMasVendidos(query);
                break;
                
            case "Personalizado...":
                bpmv = new BuscarProductosMasVendidos(this);
                break;
                
        }
    }
    
    public void exportarTabla(){
        if(modelo.getRowCount() > 0){
            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Libro de Excel", "xls");
            jfc.setFileFilter(filter);
            int opcion = jfc.showSaveDialog(panel);
            
            if(opcion == JFileChooser.APPROVE_OPTION){
                File file = jfc.getSelectedFile();
                ExcelExporter.fillData(panel.getProductos(), new File(file.getPath()+".xls"));
            }
        }else{
            JOptionPane.showMessageDialog(panel, "La vista de reportes está vacía",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void limpiarTabla(){
        if(panel.getProductos().getRowCount() > 0){
            try{
                while(true){
                    modelo.removeRow(0);
                }

            }catch(Exception e){}
        }
    }
    
    public void rangoPersonalizado(){
        String query = "AND Detalle_fact.fechaVenta BETWEEN '" + bpmv.getAnio2().getSelectedItem() + "-" +
                            bpmv.getMes2().getSelectedItem() + "-" + bpmv.getDia2().getSelectedItem() + "'" +
                        " AND '" + bpmv.getAnio().getSelectedItem() + "-" +
                            bpmv.getMes().getSelectedItem() + "-" + bpmv.getDia().getSelectedItem() + "'";
        
//        System.out.println("Query: " + query);
        
        limpiarTabla();
        try {
            productosMasVendidos(query);
        } catch (SQLException ex) {
            Logger.getLogger(OyenteProductosMasVendidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(correcto){
            bpmv.dispose();
        }
    }
    
    public void productosMasVendidos(String rangoFechas) throws SQLException{
        correcto = true;
        String consulta = "Select * from ProductoMasVendidos";
        
        try{
            conexion.iniciarConexion();
            
            conexion.setResult(conexion.getStament().executeQuery(consulta));
            
            while(conexion.getResult().next()){
                Object[] fila = new Object[modelo.getColumnCount()];
                
                for(int i = 0; i < modelo.getColumnCount(); i++){
                    if(i == 3 || i == 5){
                        fila[i] = "$ " + conexion.getResult().getObject(i + 1);
                    }else{
                        fila[i] = conexion.getResult().getObject(i + 1);
                    }
                }
                
                modelo.addRow(fila);
            }
            
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            panel.getProductos().getColumnModel().getColumn(0).setCellRenderer(tcr);
            
            panel.getProductos().getColumnModel().getColumn(3).setCellRenderer(tcr);
            panel.getProductos().getColumnModel().getColumn(4).setCellRenderer(tcr);
            panel.getProductos().getColumnModel().getColumn(5).setCellRenderer(tcr);

            conexion.getStament().close();
            
            if(modelo.getRowCount() == 0){
                JOptionPane.showMessageDialog(bpmv, "Vaya! No hubo ninguna venta en ese intervalo",
                                                "Aviso", JOptionPane.WARNING_MESSAGE);
                
                correcto = false;
                
            }
        }catch(SQLException e){
                JOptionPane.showMessageDialog(bpmv, "Vaya! Hubo un error al recuperar los datos \n"+e.getMessage(),
                                                "Error", JOptionPane.ERROR_MESSAGE);
                
                correcto = false;
                
        
        }finally{
            conexion.cerrarConexion();
        }
    }
}
