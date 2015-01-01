/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;


import com.puntoVenta.*;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author JR
 */
public class EliminarCabecera extends EliminarFactura{

    public EliminarCabecera(Conexion c) {
        super(c);
        super.setTitle("Eliminar Detalle de Factura");
    }

    @Override
    protected void addComponentes() {
        JPanel p = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        c.iniciarConexion();
        String consulta = "select Cab_fact.idCab_fact, Vendedor.nombreVendedor, Vendedor.apPaterno, Cliente.nombreCliente, Cliente.apPaterno"
                + " from Cab_fact, Vendedor, Cliente where Vendedor.idVendedor = Cab_fact.Vendedor_idVendedor and Cliente.idCliente=Cab_fact.Cliente_idCliente"
                + " order by Cab_fact.idCab_fact;";
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
        
        p2.add(super.eliminar);
        p2.add(super.cancelar);
        this.add(p, "North");
        this.add(p2, "South");
        
    }

    @Override
    protected void addEventos() {
        OyenteCabecera o = new OyenteCabecera(c, this);
        eliminar.addActionListener(o);
        cancelar.addActionListener(o);
    }
    
}
