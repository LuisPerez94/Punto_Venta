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
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Path rutaFROM;
    Path rutaTo;
    CopyOption[] options;

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
            if(verificar()){
            datos.add(a.getTnombre().getText());
            datos.add(a.getTprecio().getText());
            datos.add("src/img/productos/" + nombreArchivo);
            datos.add(a.getDescripcion().getText());
            datos.add(a.getTexistencia().getText());
            
            for(int i = 0; i < datos.size(); i++){
                System.out.println("Datos Prod: " +datos.get(i));
            }
            try {
                Files.copy(rutaFROM, rutaTo, options);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(a, "Error al guardar la imagen", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            usuario.insertarDatos("P", datos);
            limpiardatos();
            datos.clear();
            }else{
                JOptionPane.showMessageDialog(a,"Debe llenar los campos obligatorios -> *", "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
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
                    rutaFROM = (Path) Paths.get(ruta);
                    String destino = "src/img/productos/" + nombreArchivo;
                    rutaTo = (Path) Paths.get(destino);
                    options = new CopyOption[]{
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES
                    };

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
        ImageIcon aux = new ImageIcon("src/img/sistema/preview.png");
        ImageIcon img = new ImageIcon(aux.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH));
        a.getImagen().setIcon(img);
        a.getImagen().setText("");
        a.getNombreImagen().setText("Sin imagen seleccionada");
        a.getTexistencia().setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campo = (JTextField) e.getSource();
        String accion = campo.getName();
        char car = e.getKeyChar();
        switch (accion) {
            case "precio":

                if (a.getTprecio().getText().length() >= 7) {
                    e.consume();
                }
                if ((car < '0' || car > '9')) {
                    e.consume();
                }

        }

    }

    private boolean verificar() {
       int cont=0;
       if (!"".equals(a.getTnombre().getText())){
           cont++;
       }
       if(!"".equals(a.getTprecio().getText())){
           cont++;
       }
       if(!"".equals(a.getTexistencia().getText())){
           cont++;
       }
        return cont==3;
    }

}
