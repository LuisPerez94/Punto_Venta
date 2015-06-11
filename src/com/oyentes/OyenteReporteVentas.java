/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oyentes;

import com.tablas.VentanaDeTabla;
import com.puntoVenta.Conexion;
import com.puntoVenta.PanelVentas;
import com.puntoVenta.VentanaEmergente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis
 */
public class OyenteReporteVentas implements ActionListener {
    private PanelVentas p;
    private Conexion usuario;
    private VentanaEmergente ventana;
    
    JTable tabla;
    
    private Double totalArticulos;
    private Double totalEfectivo;

    public OyenteReporteVentas(PanelVentas p, Conexion usuario, VentanaEmergente ventana) {
        this.totalEfectivo = 0.0;
        this.totalArticulos = 0.0;
        this.p = p;
        this.usuario = usuario;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        String fecha2 = p.getAnio2().getSelectedItem()+"/"+(p.getMes2().getSelectedIndex()+1)+"/"+p.getDia2().getSelectedItem();
        String fecha1= p.getAnio1().getSelectedItem()+"/"+(p.getMes1().getSelectedIndex()+1)+"/"+p.getDia1().getSelectedItem();

        System.out.println(fecha1 + " " + fecha2);
        
        if (accion.equals("Ver el reporte")) {
            if (isDate(fecha1) && isDate(fecha2)) {
                //CONSULTA DE VENTAS POR DIA 
                String query = "SELECT Producto.idProducto, Producto.nomProducto,Producto.precioproducto, SUM(Detallefactura.cantidadProducto) vendidos,"
                        + "SUM(Producto.precioproducto * Detallefactura.cantidadProducto) ventaPorProducto " + "FROM Cabfactura, Detallefactura, Producto"
                        + " WHERE Cabfactura.idCabfactura = Detallefactura.idCabfactura AND Detallefactura.idProducto = Producto.idProducto "
                        + "AND Detallefactura.fechaVenta BETWEEN '" + fecha1 + "' AND '" + fecha2 + "'GROUP BY 1 ORDER BY 1,2,3 DESC";

                generarTabla(query);
                
                VentanaDeTabla vt = new VentanaDeTabla(tabla,totalArticulos,totalEfectivo,fecha1,fecha2);
                totalArticulos=0.0;
                totalEfectivo=0.0;
                
                ventana.dispose();

            } else {
                JOptionPane.showMessageDialog(p, "Las fechas no son válidas");
            }

        }
    }

    public boolean isDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
            formatoFecha.setLenient(false);
            java.util.Date fecha = formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void generarTabla(String query) {
        DefaultTableModel modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modelo);
        try {
            usuario.iniciarConexion();
            usuario.setResult(usuario.getStament().executeQuery(query));
            modelo.addColumn("IdProducto");
            modelo.addColumn("Producto");
            modelo.addColumn("Precio unitario");
            modelo.addColumn("Total Vendidos");
            modelo.addColumn("Total $ Vendidos");

            // Bucle para cada resultado en la consulta
            while (usuario.getResult().next()) {
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[5]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 5; i++) {
                    fila[i] = usuario.getResult().getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                totalArticulos=totalArticulos+Double.parseDouble(fila[3].toString());
                totalEfectivo=totalEfectivo+Double.parseDouble(fila[4].toString());
                
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            System.out.println("Error"+ex);
        }

    }

}
