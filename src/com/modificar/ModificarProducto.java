/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import com.puntoVenta.Producto;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private JTextField existencia;
   
    private JButton ruta = new JButton("Seleccionar ruta");
    private JTextArea descripcion;
    private JLabel imagen;
    private String rutaImagen;
    
    private Producto producto = new Producto();
    
    
    private ArrayList Atributos;
    private ArrayList ids = new ArrayList<>();
    private ArrayList v = new ArrayList <String []> ();
    
    public ModificarProducto(Conexion c) {
        this.setTitle("Modificar Producto");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setSize(320, 390);
        this.setResizable(false);
        addComponentes();
        addEventos(new OyenteModificarProducto(c, this));
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
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
        GridLayout gl2 = new GridLayout(7, 2);
        panelCentro.setLayout(gl2);
        panelCentro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 15));
        
        cancelar = new JButton("Cancelar");
        registrar = new JButton("Modificar");
        
        nombre = new JTextField();
        precio = new JTextField();
        existencia = new JTextField();
        
        descripcion = new JTextArea(13, 30);
        descripcion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        descripcion.setWrapStyleWord(true);
        descripcion.setLineWrap(true);
        
        panelCentro.add(new JLabel("Modificar a:"));
        panelCentro.add(productos);
        
        imagen = new JLabel();
        imagen.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon aux = new ImageIcon("src/img/sistema/preview.png");
        ImageIcon img = new ImageIcon(aux.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        imagen.setIcon(img);
        
        JScrollPane scrollDescripcion = new JScrollPane(descripcion);
        scrollDescripcion.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDescripcion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        nombre.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        precio.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        existencia.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        scrollDescripcion.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        
        panelCentro.add(new JLabel("Nombre: "));
        panelCentro.add(nombre);
        panelCentro.add(new JLabel("Precio: "));
        panelCentro.add(precio);
        panelCentro.add(new JLabel("Ruta de la imagen: "));
        JPanel panelRuta = new JPanel();
        panelRuta.add(ruta);
        panelCentro.add(panelRuta);
        panelCentro.add(new JLabel("Imagen: "));
        panelCentro.add(imagen);
        panelCentro.add(new JLabel("Descripcion: "));
        panelCentro.add(scrollDescripcion);
        panelCentro.add(new JLabel("Existencia: "));
        panelCentro.add(existencia);
        
        
        panelSur.add(cancelar);
        panelSur.add(registrar);
        
        this.add(panelSur,"South");
        this.add(panelCentro, "Center");
        
        agregarCampos(Integer.parseInt(ids.get(0).toString()));
    }

    private void addEventos(OyenteModificarProducto o) {
        cancelar.addActionListener(o);
        registrar.addActionListener(o);
        ruta.addActionListener(o);
        precio.addKeyListener(o);
        productos.addItemListener(o);
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

    public JLabel getImagen() {
        return imagen;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JTextField getExistencia() {
        return existencia;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
    void agregarCampos (int producto){
        c.iniciarConexion();
            String consulta = "select * from Producto where idProducto="+producto;
            System.out.println(consulta);
            try {
            c.setResult(c.getStament().executeQuery(consulta));
            while(c.getResult().next()){
                getProducto().setNombreProducto(c.getResult().getString(2));
                getProducto().setPrecio(Float.parseFloat(c.getResult().getString(3)));
                
                getProducto().setDescripcion(c.getResult().getString(5));
                getProducto().setExistencia(Integer.parseInt(c.getResult().getString(6)));

                this.rutaImagen = c.getResult().getObject(4)+"";
                
                OyenteModificarProducto.colocarDestino(this.rutaImagen);
                
                ImageIcon aux = new ImageIcon(c.getResult().getObject(4)+"");
                ImageIcon img = new ImageIcon(aux.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                imagen.setIcon(img);
                
                
                System.out.println(c.getResult().getString(2));
                System.out.println(c.getResult().getString(3));
                System.out.println(c.getResult().getString(4));
                System.out.println(c.getResult().getString(5));
                System.out.println(c.getResult().getString(6));
                System.out.println(c.getResult().getString(7));
             
                
                               
                               
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        c.cerrarConexion();
        
       
        String precioString=""+getProducto().getPrecio();
        String exString = ""+getProducto().getExistencia();
        getNombre().setText(getProducto().getNombreProducto());
        getPrecio().setText(precioString);
        getDescripcion().setText(getProducto().getDescripcion());
        getExistencia().setText(exString);
        
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    
}
