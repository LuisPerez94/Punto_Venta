/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;



/**
 *
 * @author JR
 */
public class BuscarVendedor extends JFrame{
    
    private JButton buscar = new JButton ("Buscar");
    private Conexion conexion = new Conexion("administrador", "123pass", "3306", "localhost", "punto_venta");
    private ArrayList v = new ArrayList <String []> ();
    private ArrayList Atributos = new ArrayList <String>();
    private JComboBox vendedores;
    private ArrayList ids = new ArrayList<>();
    public BuscarVendedor() {
        
        super("Buscar vendedor");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addComponents();
        addListeners();
        this.setLocationRelativeTo(null);
        this.addWindowListener(new OyenteBuscarVendedor(this));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
    }

    private void addComponents() {
        conexion.iniciarConexion();
        String consulta = "select vendedor.idVendedor, vendedor.nombreVendedor, vendedor.apPaterno, vendedor.apMaterno from vendedor;";
        try {
        conexion.setResult(conexion.getStament().executeQuery(consulta));
        while (conexion.getResult().next()) {
                    Atributos = new ArrayList <String[]>();
                    for (int i = 0; i < conexion.getResult().getMetaData().getColumnCount(); i++) {
                        Atributos.add(conexion.getResult().getString(i + 1));
                        }
                    ids.add(Atributos.get(0).toString());
                    v.add(Atributos);
                    
            
        }
        } catch (SQLException ex) {
            
        }
        conexion.cerrarConexion();
        vendedores = new JComboBox(ListToArray(v));
        JPanel p = new JPanel();
        p.add(vendedores);
        p.add(buscar);
        this.add(p);
        pack();
    }

    private void addListeners() {
        buscar.addActionListener(new OyenteBuscarVendedor(this));
        buscar.addKeyListener(new OyenteBuscarVendedor(this));
        
    }
    
    static String [] ListToArray(ArrayList v){
        String returnThis[] = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            returnThis [i] = v.get(i).toString();
        }
        return returnThis;
    }

    public JComboBox getVendedores() {
        return vendedores;
    }

    public ArrayList getIds() {
        return ids;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public ArrayList getV() {
        return v;
    }

    public ArrayList getAtributos() {
        return Atributos;
    }
    
    
    
    
}

