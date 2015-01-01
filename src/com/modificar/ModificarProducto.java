/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author JR
 */
public class ModificarProducto extends JFrame{
    Conexion c ;
    private JComboBox productos;
    private JButton cancelar = new JButton("Cancelar");
    private JButton registrar = new JButton("Modificar");
    
    private JTextField nombre;
    private JTextField precio;
   
    private JButton ruta = new JButton("Seleccionar ruta");
    private JTextArea descripcion;
    
    
    
    private ArrayList Atributos;
    private ArrayList ids = new ArrayList<>();
    private ArrayList v = new ArrayList <String []> ();
    
    public ModificarProducto(Conexion c) {
        this.setTitle("Modificar Producto");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setSize(300, 400);
        //this.setResizable(false);
        addComponentes();
        addEventos(new OyenteModificarProducto(c, this));
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    
    protected void addComponentes(){
        c.iniciarConexion();
        String consulta = "select Producto.idProducto, Producto.nombreProducto from Producto;";
        try {
        c.setResult(c.getStament().executeQuery(consulta));
        while (c.getResult().next()) {
                    Atributos = new ArrayList <String[]>();
                    for (int i = 0; i < c.getResult().getMetaData().getColumnCount(); i++) {
                        Atributos.add(c.getResult().getString(i + 1));
                        }
                    ids.add(Atributos.get(0).toString());
                    v.add(Atributos);
                    
            
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        c.cerrarConexion();
        productos = new JComboBox(ListToArray(v));
        
        JPanel panelSur = new JPanel();
        JPanel panelCentro = new JPanel();
        GridLayout gl1 = new GridLayout(1, 2);
        panelSur.setLayout(gl1);
        JPanel panelIzqSur = new JPanel();
        JPanel panelDerSur = new JPanel();
        GridLayout gl2=new GridLayout(12, 2);
        panelCentro.setLayout(gl2);
        cancelar=new JButton("Cancelar");
        registrar=new JButton("Modificar");
        
        nombre = new JTextField();
        precio = new JTextField();
        
        
        descripcion = new JTextArea(15, 30);
        
        
        
        
        JPanel norte  =new JPanel(new BorderLayout());
        norte.add(new JLabel("Modificar a:"), "West");
        norte.add(productos, "East");
        
        
        panelCentro.add(new JLabel("Nombre :"));
        panelCentro.add(nombre);
        panelCentro.add(new JLabel("Precio :"));
        panelCentro.add(precio);
        panelCentro.add(new JLabel("Ruta de la imagen :"));
        panelCentro.add(ruta);
        
        panelCentro.add(new JLabel("Descripcion :"));
        panelCentro.add(descripcion);
       
       
        
        
        
        panelIzqSur.add(cancelar);
        panelDerSur.add(registrar);
        
        panelSur.add(panelIzqSur);
        panelSur.add(panelDerSur);
        this.add(norte, "North");
        this.add(panelSur,"South");
        this.add(panelCentro, "Center");
    }

    private void addEventos(OyenteModificarProducto o) {
        cancelar.addActionListener(o);
        registrar.addActionListener(o);
        ruta.addActionListener(o);
    }
    
    static String [] ListToArray(ArrayList v){
        String returnThis[] = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            returnThis [i] = v.get(i).toString();
        }
        return returnThis;
    }

    public Conexion getC() {
        return c;
    }

    public void setC(Conexion c) {
        this.c = c;
    }

    public JComboBox getProductos() {
        return productos;
    }

    public void setProductos(JComboBox productos) {
        this.productos = productos;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }

    public JButton getRegistrar() {
        return registrar;
    }

    public void setRegistrar(JButton registrar) {
        this.registrar = registrar;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JTextField getPrecio() {
        return precio;
    }

    public void setPrecio(JTextField precio) {
        this.precio = precio;
    }

    public JButton getRuta() {
        return ruta;
    }

    public void setRuta(JButton ruta) {
        this.ruta = ruta;
    }

    public JTextArea getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(JTextArea descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList getAtributos() {
        return Atributos;
    }

    public void setAtributos(ArrayList Atributos) {
        this.Atributos = Atributos;
    }

    public ArrayList getIds() {
        return ids;
    }

    public void setIds(ArrayList ids) {
        this.ids = ids;
    }

    public ArrayList getV() {
        return v;
    }

    public void setV(ArrayList v) {
        this.v = v;
    }
    
    
}
