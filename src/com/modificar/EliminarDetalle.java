/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import static com.modificar.ModificarCliente.ListToArray;
import com.puntoVenta.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author JR
 */
public class EliminarDetalle extends EliminarFactura{
    
    public EliminarDetalle(Conexion c) {
        super(c);
        super.setTitle("Eliminar Detalle de Factura");
        super.setSize(590, 115);
        super.setLocationRelativeTo(null);
    }

    @Override
    protected void addComponentes() {
        try {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
            
            JPanel p = new JPanel(new FlowLayout());
            JPanel p2 = new JPanel(new FlowLayout());
            c.iniciarConexion();
            String consulta = "select Detalle_fact.idDetalle_fact, Producto.nombreProducto, Detalle_fact.FechaVenta, \n" +
                    "Detalle_fact.cantidadProducto, Cliente.nombreCliente, Cliente.apPaterno,\n" +
                    "Vendedor.nombreVendedor, Vendedor.apPaterno\n" +
                    "from Detalle_fact, Producto, Vendedor, Cliente, Cab_fact\n" +
                    "where Producto.idProducto = Detalle_fact.Producto_idProducto and\n" +
                    "Detalle_fact.Cab_fact_idCab_fact = Cab_fact.idCab_fact and\n" +
                    "Cab_fact.Cliente_idCliente = Cliente.idCliente and\n" +
                    "Cab_fact.Vendedor_idVendedor = Vendedor.idVendedor\n" +
                    "order by Detalle_fact.idDetalle_fact;";
            try {
                c.setResult(c.getStament().executeQuery(consulta));
                while (c.getResult().next()) {
                    super.Atributos = new ArrayList <String[]>() ;
                    for (int i = 0; i < c.getResult().getMetaData().getColumnCount(); i++) {
                        super.Atributos.add(c.getResult().getString(i + 1));
                    }
                    super.ids.add(super.Atributos.get(0).toString());
                    super.v.add(super.Atributos);
                    
                    
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            c.cerrarConexion();
            super.factura = new JComboBox(super.ListToArray(super.v));
            

            p.add(factura);
            
            p2.add(super.cancelar);
            p2.add(super.eliminar);
            
            panel.add(p, "North");
            panel.add(p2, "South");
            
            this.add(panel, "Center");
        } catch (SQLException ex) {
            Logger.getLogger(EliminarDetalle.class.getName()).log(Level.SEVERE, null,ex);
        }
    }

    @Override
    protected void addEventos() {
        OyenteDetalle o = new OyenteDetalle(c, this);
        eliminar.addActionListener(o);
        cancelar.addActionListener(o);
    }
    
}   
