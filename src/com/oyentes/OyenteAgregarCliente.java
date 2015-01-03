/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oyentes;

import com.formularios.AgregarCliente;
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
public class OyenteAgregarCliente extends KeyAdapter implements ActionListener{
     Conexion usuario ;
     AgregarCliente c;
     
    private ArrayList<String> datos;
    public OyenteAgregarCliente(AgregarCliente c,Conexion usuario) {
        this.c=c;
        this.usuario=usuario;
        datos=new ArrayList<>();
    }
            
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion=e.getActionCommand();
        switch(accion){
            case "Cancelar":
                System.out.println("Cancelar");
                if (JOptionPane.showConfirmDialog(null, "¿Cancelar el registro?", "Cancelar", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    c.dispose();
                    limpiardatos();
                }
                break;
            case "Registrar":
                EmailValidator ev=new EmailValidator();
                if(ev.validate(c.gettCorreo().getText())){
                    
                
                System.out.println("registrar");
                datos.add(c.gettNombre().getText());
                datos.add(c.gettAptPaterno().getText());
                datos.add(c.gettAptMaterno().getText());
                datos.add(c.gettDireccion().getText());
                datos.add(c.gettCorreo().getText());
                datos.add(c.gettTelefono().getText());
                datos.add(c.gettSexo().getText());
                usuario.insertarDatos("C",datos);
                limpiardatos();
                datos.clear();
                }else{
                    JOptionPane.showMessageDialog(c, "El Correo no es valido");
                }
                break;
        }
    }

    private void limpiardatos() {
     c.gettAptMaterno().setText("");
     c.gettAptPaterno().setText("");
     c.gettNombre().setText("");
     c.gettTelefono().setText("");
     c.gettSexo().setText("");
     c.gettDireccion().setText("");
     c.gettCorreo().setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campo= (JTextField) e.getSource();
        String accion= campo.getName();
           char car = e.getKeyChar();
        switch(accion){
            case "telefono":
             
                if(c.gettTelefono().getText().length()>=10) e.consume();
                if((car<'0' || car>'9')) e.consume();
                break;
            case "sexo":
               if(c.gettSexo().getText().length()==1)e.consume();
               if(car=='M'||(car=='F')||(car=='f')||(car=='m')) {
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