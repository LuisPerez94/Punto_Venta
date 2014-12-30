/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oyentes;

import Formularios.AgregarVendedor;
import com.puntoVenta.Conexion;
import com.puntoVenta.EmailValidator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luis
 */
public class OyenteAgregarVendedor extends KeyAdapter implements ActionListener {

    Conexion usuario;
    AgregarVendedor a;
    ArrayList <String> datos;

    public OyenteAgregarVendedor(Conexion usuario, AgregarVendedor a) {
        this.usuario = usuario;
        this.a = a;
        datos=new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Cancelar":
                System.out.println("Cancelar");
                if (JOptionPane.showConfirmDialog(a, "Seguro que quieres cancelar,'Tus datos se perderan'") == JOptionPane.OK_OPTION) {
                    a.dispose();
                    limpiardatos();

                }
                break;
            case "Registrar":
                System.out.println("Registrar");
                 EmailValidator ev=new EmailValidator();
                 if(ev.validate(a.getCorreo().getText())){
                     if(isDate(a.getFechaIngreso().getText()) && isDate(a.getFechanacimiento().getText())){
                         datos.add(a.getNombre().getText());
                         datos.add(a.getApPaterno().getText());
                         datos.add(a.getApMaterno().getText());
                         datos.add(a.getFechanacimiento().getText());
                         datos.add(a.getCorreo().getText());
                         datos.add(a.getDireccion().getText());
                         datos.add(a.getSexo().getText());
                         datos.add(a.getSueldo().getText());
                         datos.add(a.getFechaIngreso().getText());
                         datos.add(a.getUsuario().getText());
                         datos.add(a.getContraseña().getText());
                         datos.add(a.getAdmin().getText());
                         
                         usuario.insertarDatos("V", datos);
                         limpiardatos();
                         datos.clear();
                     }else{
                           JOptionPane.showMessageDialog(a, "Las Fechas no son validas");
                         
                     }
                     
                 }else{
                         JOptionPane.showMessageDialog(a, "El Correo no es valido");
                 }
                break;
        }
    }

    private void limpiardatos() {
        a.getNombre().setText("");
        a.getApPaterno().setText("");
        a.getApMaterno().setText("");
        a.getCorreo().setText("");
        a.getSexo().setText("");
        a.getDireccion().setText("");
        a.getAdmin().setText("");
        a.getUsuario().setText("");
        a.getSueldo().setText("");
        a.getContraseña().setText("");
        a.getFechaIngreso().setText("");
        a.getFechanacimiento().setText("");

    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campo = (JTextField) e.getSource();
        String accion = campo.getName();
        char car = e.getKeyChar();
        switch (accion) {
            case "sueldo":

                if (a.getSueldo().getText().length() >= 7) {
                    e.consume();
                }
                if ((car < '0' || car > '9')) {
                    e.consume();
                }
                break;
            case "sexo":
                if (a.getSexo().getText().length() == 1) {
                    e.consume();
                }
                if (car == 'M' || (car == 'F') || (car == 'f') || (car == 'm')) {
                } else {
                    e.consume();
                }
                break;
            case "admin":
                if(a.getAdmin().getText().length()==1)e.consume();
               if(car=='t'||(car=='T')||(car=='f')||(car=='F')) {
        } else {
                   e.consume();
        }
                break;
        }
    }
     public boolean isDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
            formatoFecha.setLenient(false);
            java.util.Date fecha = formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

