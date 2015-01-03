/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import static com.modificar.ModificarVendedor.ListToArray;
import com.puntoVenta.Conexion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author JR
 */
public class EliminarVendedor extends ModificarVendedor{
    
    public EliminarVendedor(Conexion c) {
        super(c);
        this.setTitle("Eliminar Vendedor");
        this.setSize(320, 120);
        this.setLocationRelativeTo(null);
    }
    
    @Override
    public void addComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JPanel p = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        c.iniciarConexion();
        String consulta = "select Vendedor.idVendedor, Vendedor.nombreVendedor, Vendedor.apPaterno, Vendedor.apMaterno from Vendedor;;";
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
        super.setVendedores(new JComboBox(ListToArray(super.getV())));
        super.getRegistrar().setText("Eliminar");
        
        p.add(super.getVendedores());
        
        p2.add(super.getCancelar());
        p2.add(super.getRegistrar());
        
        panel.add(p, "North");
        panel.add(p2, "South");
        
        this.add(panel, "Center");
    }
    
    
    
}
