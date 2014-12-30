/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Oyentes.OyenteAgregarProducto;
import com.puntoVenta.Conexion;
import java.awt.GridLayout;
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
    public AgregarProducto(){
        super("Agregar Nuevo Producto");
        this.setSize(600,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        addComponentes();
        this.setVisible(true);
        
    }

    private void addComponentes() {
        JPanel panelCentro=new JPanel(new GridLayout(5, 2,0,10));
        JPanel panelSur=new JPanel(new GridLayout(1, 2));
        JPanel panelImagen=new JPanel();
        tnombre=new JTextField(30);
        tprecio=new JTextField(30);
        tprecio.setName("precio");
        descripcion=new JTextArea(15, 30);
        imagen=new JLabel();
        nombreImagen=new JLabel();
        elegir=new JButton("Elegir Imagen...");
        panelCentro.add(new JLabel("Ingresa el nombre del producto: "));
        panelCentro.add(tnombre);
        panelCentro.add(new JLabel("Ingresa el precio unitario del producto: $"));
        panelCentro.add(tprecio);
        panelCentro.add(new JLabel("Ingresa un descripcion del producto: "));
        panelCentro.add(descripcion);
        panelCentro.add(new JLabel("Elegir la imagen del producto :"));
        panelCentro.add(elegir);
        panelCentro.add(new JLabel("Imagen :"));
        if(imagen.getIcon()==null){
            
            nombreImagen.setText("sin imagen selecionada");
        }
        panelCentro.add(nombreImagen);
        panelImagen.add(imagen);
        
        registrar=new JButton("Registrar");
        cancelar=new JButton("Cancelar");
        panelSur.add(registrar);
        panelSur.add(cancelar);
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
