/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import com.puntoVenta.EmailValidator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JR
 */
public class OyenteModificarCliente implements ActionListener, KeyListener, ItemListener{
    Conexion c ;
    ModificarCliente mc;

    public OyenteModificarCliente(Conexion c, ModificarCliente mc) {
        this.c = c;
        this.mc = mc;
    }

   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Cancelar":
                System.out.println("cancelar1");
                if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cancelar?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                    mc.dispose();
                break;
            case "Modificar":
                System.out.println("Update1");
                EmailValidator ev=new EmailValidator();
                if(ev.validate(mc.getCorreo().getText())){
                    if(ejecutarConsulta(true)){
                    JOptionPane.showConfirmDialog(null, "Se modificó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error en la modificación", "Errro", JOptionPane.ERROR_MESSAGE);
                    mc.dispose();
                    
                }else{
                    JOptionPane.showMessageDialog(mc, "El correo no es válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                break;
            
            case "Eliminar":
                System.out.println("Drop1");
                if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                    if(ejecutarConsulta(false)){
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error en la modificación", "Error", JOptionPane.ERROR_MESSAGE);
                    mc.dispose();
                }
                
                
                break;
        }
        
        
    }
    
    public boolean ejecutarConsulta(boolean hacer){
        String consulta, preconsulta="", preconsulta2="";
        c.iniciarConexion();
        if(hacer){
            consulta = "update punto_venta.Cliente set nombreCliente='"+
                    mc.getNombre().getText()+"', apPaterno='"+mc.getApPaterno().getText()+
                    "', apMaterno='"+mc.getApMaterno().getText()+
                    "', correoCliente='"+mc.getCorreo().getText()+"', direccionCliente='"+mc.getDireccion().getText()+
                    "', sexo='"+mc.getSexo().getText()+"', telefono='"+mc.getTelefono().getText()+"' where idCliente ="
                    +mc.getIds().get(mc.getClientes().getSelectedIndex()).toString()+";";
        }
        else{
            preconsulta="DELETE Detalle_fact FROM Detalle_fact, Cab_fact, Cliente\n" +
            "WHERE Detalle_fact.Cab_fact_idCab_fact = Cab_fact.idCab_fact\n" +
            "and Cliente.idCliente = Cab_fact.Cliente_idCliente and\n" +
            "Cliente.idCliente="+mc.getIds().get(mc.getClientes().getSelectedIndex()).toString()+";";
            preconsulta2="DELETE Cab_fact FROM Cab_fact, Cliente\n" +
            "WHERE Cab_fact.Cliente_idCliente = Cliente.idCliente and\n" +
            "Cliente.idCliente = "+mc.getIds().get(mc.getClientes().getSelectedIndex()).toString()+";";
            consulta = "delete from punto_venta.Cliente where idCliente="
                    +mc.getIds().get(mc.getClientes().getSelectedIndex()).toString()+";";
            
        }
        try {
            if(!preconsulta.equals("")&&!preconsulta2.equals("")){
                c.getStament().execute(preconsulta);
                c.getStament().execute(preconsulta2);
            }
            System.out.println(consulta);
            if(c.getStament().execute(consulta))
                return true;
        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Asegurate de eliminar registros\nde detalle de factura y de de cabecera de factura antes"
//                    + " de hacer esta operacion", "Alerta", JOptionPane.DEFAULT_OPTION);
            System.out.println(ex);
            return false;
        }    
//        catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Ocurrio un error "+ex.toString(), "Alerta", JOptionPane.DEFAULT_OPTION);
//            System.out.println(ex);
//            return false;
//        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField campo= (JTextField) e.getSource();
        String accion= campo.getName();
           char car = e.getKeyChar();
        switch(accion){
            case "telefono":
             
                if(mc.getTelefono().getText().length()>=10) e.consume();
                if((car<'0' || car>'9')) e.consume();
                break;
            case "sexo":
               if(mc.getSexo().getText().length()==1)e.consume();
               if(car=='M'||(car=='F')||(car=='f')||(car=='m')) {
        } else {
                   e.consume();
        }
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().equals(mc.getClientes())){
            mc.agregarCampos(Integer.parseInt(mc.getIds().get(mc.getClientes().getSelectedIndex()).toString()));
        }
    }
    
}
