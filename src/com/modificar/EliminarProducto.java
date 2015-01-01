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
public class EliminarProducto extends ModificarProducto{
    public EliminarProducto(Conexion c) {
       super(c);
       this.setTitle("Eliminar Producto");
       this.setSize(300, 100);
    }

    
    
    @Override
    public void addComponentes(){
        JPanel p = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        c.iniciarConexion();
        String consulta = "select Producto.idProducto, Producto.nombreProducto  from Producto;";
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
        super.setProductos(new JComboBox(ListToArray(super.getV())));
        super.getRegistrar().setText("Eliminar");
        p.add(super.getProductos());
        p2.add(super.getRegistrar());
        p2.add(super.getCancelar());
        this.add(p, "North");
        this.add(p2, "South");
        
    }
}
