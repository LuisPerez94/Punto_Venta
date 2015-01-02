/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.*;
import java.awt.Toolkit;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javax.swing.*;

/**
 *
 * @author JR
 */
public abstract class EliminarFactura extends JFrame{
    protected JComboBox clientes;
    protected ArrayList cliente, idsC;
    protected JButton eliminar = new JButton ("Eliminar");
    protected JButton cancelar = new JButton("Cancelar");
    protected Conexion c;
    protected ArrayList Atributos;
    protected ArrayList ids = new ArrayList<>();
    protected ArrayList v = new ArrayList <String []> ();
    protected JComboBox factura;
    public EliminarFactura(Conexion c){
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setSize(300, 100);
        this.setResizable(false);
        addComponentes();
        addEventos();
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
        
    }

    protected abstract void addComponentes();
    protected abstract void addEventos();
    
    static String [] ListToArray(ArrayList v){
        String returnThis[] = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            returnThis [i] = v.get(i).toString();
        }
        return returnThis;
    }

    
}
