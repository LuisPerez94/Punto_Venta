/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oyentes;

import com.formularios.AgregarProducto;
import com.puntoVenta.Conexion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 *
 * @author luis
 */
public class OyenteAgregarProducto extends KeyAdapter implements ActionListener {

    private Conexion usuario;
    private AgregarProducto a;
    private JFileChooser jfc;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "png", "jpeg", "jpg", "gif");
    private String nombreArchivo;
    private String ruta;

    private ArrayList<String> datos;

    public OyenteAgregarProducto(AgregarProducto a, Conexion usuario) {
        this.a = a;
        this.usuario = usuario;
        datos = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        if (accion.equals("Cancelar")) {
            if (JOptionPane.showConfirmDialog(a, "¿Cancelar el registro?", "Cancelar", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                a.dispose();
                limpiardatos();

            }

        } else if (accion.equals("Registrar")) {
            datos.add(a.getTnombre().getText());
            datos.add(a.getTprecio().getText());
            datos.add("src/img/productos/" + nombreArchivo);
            datos.add(a.getDescripcion().getText());
            usuario.insertarDatos("P", datos);
            limpiardatos();
            datos.clear();

        } else if (accion.equals("Elegir Imagen...")) {
            try {
                jfc = new JFileChooser();
                jfc.setFileFilter(filter);
                int opcion = jfc.showOpenDialog(jfc);
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    nombreArchivo = jfc.getSelectedFile().getName();
                    ruta = jfc.getSelectedFile().getPath();
                    ImageIcon aux = new ImageIcon(ruta);
                    ImageIcon img = new ImageIcon(aux.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH));
                    a.getImagen().setIcon(img);
                    a.getNombreImagen().setText(nombreArchivo);
                    javax.swing.SwingUtilities.updateComponentTreeUI(a);
                    Path rutaFROM = (Path) Paths.get(ruta);
                    String destino = "src/img/productos/" + nombreArchivo;
                    Path rutaTo = (Path) Paths.get(destino);
                    CopyOption[] options = new CopyOption[]{
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES
                    };
                    Files.copy(rutaFROM, rutaTo, options);
                } else {
                    System.out.println("salio del jfc");
                }

            } catch (Exception q) {
                System.out.println("Error" + q);
            }

        }
    }

    private void limpiardatos() {
        a.getTnombre().setText("");
        a.getTprecio().setText("");
        a.getDescripcion().setText("");
        a.getImagen().setIcon(null);
        a.getImagen().setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campo= (JTextField) e.getSource();
        String accion= campo.getName();
           char car = e.getKeyChar();
        switch(accion){
            case "precio":
             
                if(a.getTprecio().getText().length()>=7) e.consume();
                if((car<'0' || car>'9')) e.consume();
            
        }
        
    }

}
