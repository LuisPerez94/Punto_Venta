/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import static com.modificar.ModificarVendedor.ListToArray;
import com.puntoVenta.Conexion;
import com.puntoVenta.Producto;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author JR
 */
public class EliminarProducto extends JFrame{
    Conexion c ;
    private JComboBox productos;
    private JButton cancelar = new JButton("Cancelar");
    private JButton registrar = new JButton("Modificar");
    
    private JTextField nombre;
    private JTextField precio;
    private JTextField existencia;
   
    private JButton ruta = new JButton("Seleccionar ruta");
    private JTextArea descripcion;
    private JLabel imagen;
    
    private Producto producto = new Producto();
    
    
    private ArrayList Atributos;
    private ArrayList ids = new ArrayList<>();
    private ArrayList v = new ArrayList <String []> ();
    public EliminarProducto(Conexion c) throws SQLException {
       this.c = c;
       this.setTitle("Eliminar Producto");
       this.setSize(320, 120);
       addComponentes();
       addEventos(new OyenteEliminarProducto(c, this));
       this.setLocationRelativeTo(null);
       this.setResizable(false);
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
        
    }

    
    
    
    public void addComponentes() throws SQLException{        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JPanel p = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        c.iniciarConexion();
        String consulta = "select Producto.idProducto, Producto.nombreProducto  from Producto;";
        try {
        c.setResult(c.getStament().executeQuery(consulta));
        while (c.getResult().next()) {
                    setAtributos(new ArrayList <String[]>()) ;
                    for (int i = 0; i < c.getResult().getMetaData().getColumnCount(); i++) {
                        getAtributos().add(c.getResult().getString(i + 1));
                        }
                    getIds().add(getAtributos().get(0).toString());
                    getV().add(getAtributos());
                    
            
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        c.cerrarConexion();
        setProductos(new JComboBox(ListToArray(getV())));
        getRegistrar().setText("Eliminar");
        
        p.add(getProductos());
        
        p2.add(getCancelar());
        p2.add(getRegistrar());
        
        panel.add(p, "North");
        panel.add(p2, "South");
        
        this.add(panel, "Center");
    }
    private void addEventos(OyenteEliminarProducto o) {
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

    public JTextField getExistencia() {
        return existencia;
    }

    public void setExistencia(JTextField existencia) {
        this.existencia = existencia;
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

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
