/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.puntoVenta.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JR
 */
public class OyenteModificarCliente implements ActionListener{
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
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres cancelar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                    mc.dispose();
                break;
            case "Modificar":
                System.out.println("Update1");
                if(ejecutarConsulta(true)){
                    JOptionPane.showConfirmDialog(null, "Se modifico con exito", "Exito", JOptionPane.DEFAULT_OPTION);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error en la modificacion", "Exito", JOptionPane.DEFAULT_OPTION);
                mc.dispose();
                break;
            
            case "Eliminar":
                System.out.println("Drop1");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                    if(ejecutarConsulta(false)){
                    JOptionPane.showMessageDialog(null, "Se elimino con exito", "Exito", JOptionPane.DEFAULT_OPTION);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error en la modificacion", "Alerta", JOptionPane.DEFAULT_OPTION);
                    mc.dispose();
                }
                
                
                break;
        }
        
        
    }
    
    public boolean ejecutarConsulta(boolean hacer){
        String consulta;
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
            consulta = "delete from punto_venta.Cliente where idCliente="
                    +mc.getIds().get(mc.getClientes().getSelectedIndex()).toString()+";";
            
        }
        try {
            System.out.println(consulta);
            if(c.getStament().execute(consulta))
                return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Asegurate de eliminar registros\nde detalle de factura y de de cabecera de factura antes"
                    + " de hacer esta operacion", "Alerta", JOptionPane.DEFAULT_OPTION);
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
    
}
