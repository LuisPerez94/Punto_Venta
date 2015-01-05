/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.oyentes.OyenteAgregarProducto;
import com.puntoVenta.Conexion;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luis
 */
public class AgregarProducto extends JFrame{
    private  JButton registrar;
    private JButton  cancelar;
    private JButton elegir;
    private JTextField tnombre;
    private JTextField tprecio;
    private JTextArea descripcion;
    private JLabel imagen;
    private JLabel nombreImagen;
    private JTextField texistencia;

    public AgregarProducto(){
        super("Agregar Nuevo Producto");
        this.setSize(900, 350   );
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        addComponentes();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        this.setVisible(true);
    }

    private void addComponentes() {
        JPanel panelCentro = new JPanel(new GridLayout(6, 2, 0,10));
        JPanel panelSur = new JPanel();
        JPanel panelImagen = new JPanel();
        tnombre = new JTextField(30);
        tprecio = new JTextField(30);
        texistencia = new JTextField(30);
        tprecio.setName("precio");
        descripcion = new JTextArea(15, 30);
        descripcion.setWrapStyleWord(true);
        descripcion.setLineWrap(true);
        descripcion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
        imagen = new JLabel();
        nombreImagen = new JLabel();
        elegir = new JButton("Elegir Imagen...");
        
        panelCentro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 30));
        panelCentro.add(new JLabel("Ingresa el nombre del producto:  * "));
        panelCentro.add(tnombre);
        panelCentro.add(new JLabel("Ingresa el precio unitario del producto: *  $"));
        panelCentro.add(tprecio);
        panelCentro.add(new JLabel("Ingresa un descripcion del producto: "));
        panelCentro.add(descripcion);
        panelCentro.add(new JLabel("Ingresa la existencia   *"));
        panelCentro.add(texistencia);
        panelCentro.add(new JLabel("Elegir la imagen del producto :"));
        JPanel elegirImagen = new JPanel();
        elegirImagen.add(elegir);
        panelCentro.add(elegirImagen);
        panelCentro.add(new JLabel("Imagen :"));
        
        if(imagen.getIcon() == null){
            nombreImagen.setText("Sin imagen selecionada");
            
            ImageIcon aux = new ImageIcon("src/img/sistema/preview.png");
            ImageIcon img = new ImageIcon(aux.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH));
            this.getImagen().setIcon(img);
        }
        
        panelCentro.add(nombreImagen);
        panelImagen.add(imagen);
        
        registrar = new JButton("Registrar");
        cancelar = new JButton("Cancelar");
        
        panelSur.add(cancelar);
        panelSur.add(registrar);

        this.add(panelSur,"South");
        this.add(panelImagen,"East");
        this.add(panelCentro,"Center");
       
    }
    
    public void addEventos(OyenteAgregarProducto o){
        registrar.addActionListener(o);
        cancelar.addActionListener(o);
        elegir.addActionListener(o);
        tprecio.addKeyListener(o);
    }
   

    public JButton getRegistrar() {
        return registrar;
    }

    public void setRegistrar(JButton registrar) {
        this.registrar = registrar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }

    public JButton getElegir() {
        return elegir;
    }

    public void setElegir(JButton elegir) {
        this.elegir = elegir;
    }

    public JTextField getTnombre() {
        return tnombre;
    }

    public void setTnombre(JTextField tnombre) {
        this.tnombre = tnombre;
    }

    public JTextField getTprecio() {
        return tprecio;
    }

    public void setTprecio(JTextField tprecio) {
        this.tprecio = tprecio;
    }

    public JTextField getTexistencia() {
        return texistencia;
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

    public JLabel getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(JLabel nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
    
    
    
}
