/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;



/**
 *
 * @author JR
 */
public class BuscarVendedor extends JFrame{
    private JButton buscar = new JButton ("Buscar");
    private Conexion conexion = new Conexion("administrador", "123pass", "3306", "localhost");
    private ArrayList v = new ArrayList <String []> ();
    private ArrayList Atributos = new ArrayList <String>();
    private JComboBox vendedores, anio, mes, dia, anio2, mes2, dia2;
    private ArrayList ids = new ArrayList<>();
    
    public BuscarVendedor() throws SQLException {
        super("Ventas por vendedor");
        this.setSize(480, 210);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addComponents();
        addListeners();
        this.setLocationRelativeTo(null);
        this.addWindowListener(new OyenteBuscarVendedor(this));
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
    }

    private void addComponents() throws SQLException {
        conexion.iniciarConexion();
        String consulta = "select vendedor.idVendedor, vendedor.nombreVendedor, vendedor.apPaterno, vendedor.apMaterno from Vendedor;";
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
        
        JPanel norte = new JPanel();
        
        // Llenamos los combobox...
        Calendar calendario = new GregorianCalendar();

        String[] anios = new String[calendario.get(Calendar.YEAR)-(2013-1)],
                meses = new String[12], 
                dias = new String[31];
        
        
        for(int i = 0; i <= calendario.get(Calendar.YEAR)-2013; i++){
            anios[i] = ((calendario.get(Calendar.YEAR)) - (i))+"";
//            System.out.println("Calendariooooo");
        }
        
        for(int i = 0; i < 12; i++){
            meses[i] = (i+1)+"";
        }
        
        for(int i = 0; i < 31; i++){
            dias[i] = (i+1)+"";
        }
        
        anio = new JComboBox(anios);
        anio2 = new JComboBox(anios);
        mes = new JComboBox(meses);
        mes2 = new JComboBox(meses);
        dia = new JComboBox(dias);
        dia2 = new JComboBox(dias);

        JPanel subCentroN = new JPanel();
        JPanel subCentroS = new JPanel();
        
        subCentroN.add(new JLabel("Límite superior"));
        subCentroN.add(anio);
        subCentroN.add(new JLabel(" / "));
        subCentroN.add(mes);
        subCentroN.add(new JLabel(" / "));
        subCentroN.add(dia);
        
        subCentroS.add(new JLabel("Límite inferior"));
        subCentroS.add(anio2);
        subCentroS.add(new JLabel(" / "));
        subCentroS.add(mes2);
        subCentroS.add(new JLabel(" / "));
        subCentroS.add(dia2);
        
        JPanel centro = new JPanel();
        centro.add(subCentroN);
        centro.add(subCentroS);
        
        norte.add(new JLabel("Vendedor: "));
        norte.add(vendedores);

        JPanel sur = new JPanel();
        sur.add(buscar);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(this.getBackground(), 15));

        
        panel.add(norte, "North");
        panel.add(centro, "Center");
        panel.add(sur, "South");
        
        this.add(panel);
//        pack();
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

    public JComboBox getAnio() {
        return anio;
    }

    public JComboBox getMes() {
        return mes;
    }

    public JComboBox getDia() {
        return dia;
    }

    public JComboBox getAnio2() {
        return anio2;
    }

    public JComboBox getMes2() {
        return mes2;
    }

    public JComboBox getDia2() {
        return dia2;
    }
    
    
    
    
}

