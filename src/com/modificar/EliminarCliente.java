/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import static com.modificar.ModificarVendedor.ListToArray;
import com.puntoVenta.Conexion;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author JR
 */
public class EliminarCliente extends ModificarCliente{
    public EliminarCliente(Conexion c) {
        super(c);
        this.setTitle("Eliminar Cliente");
        this.setSize(300, 100);
    }
    
    @Override
    public void addComponentes(){
        JPanel p = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        c.iniciarConexion();
        String consulta = "select Cliente.idCliente, Cliente.nombreCliente, Cliente.apPaterno, Cliente.apMaterno from Cliente;";
        try {
        c.setResult(c.getStament().executeQuery(consulta));
        while (c.getResult().next()) {
                    super.setAtributos(new ArrayList <String[]>()) ;
                    for (int i = 0; i < c.getResult().getMetaData().getColumnCount(); i++) {
                        super.getAtributos().add(c.getResult().getString(i + 1));
                        }
                    super.getIds().add(super.getAtributos().get(0).toString());
                    super.getV().add(super.getAtributos());
                    
            
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        c.cerrarConexion();
        super.setClientes(new JComboBox(ListToArray(super.getV())));
        super.getRegistrar().setText("Eliminar");
        p.add(super.getClientes());
        p2.add(super.getRegistrar());
        p2.add(super.getCancelar());
        this.add(p, "North");
        this.add(p2, "South");
        
    }
    
}