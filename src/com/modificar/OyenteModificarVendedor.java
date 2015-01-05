/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.formularios.AgregarVendedor;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.puntoVenta.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JR
 */
public class OyenteModificarVendedor implements ActionListener{
    Conexion c ;
    ModificarVendedor mv;

    public OyenteModificarVendedor(Conexion c, ModificarVendedor mv) {
        this.c = c;
        this.mv = mv;
    }

   
   
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Cancelar":
                System.out.println("cancelar");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres cancelar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                    mv.dispose();
                break;
            case "Modificar":
                System.out.println("Update");
                if(ejecutarConsulta(true)){
                    JOptionPane.showConfirmDialog(null, "Se modifico con exito", "Exito", JOptionPane.DEFAULT_OPTION);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error en la modificacion", "Exito", JOptionPane.DEFAULT_OPTION);
                mv.dispose();
                break;
            
            case "Eliminar":
                System.out.println("Drop");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                    if(ejecutarConsulta(false)){
                    JOptionPane.showMessageDialog(null, "Se elimino con exito", "Exito", JOptionPane.DEFAULT_OPTION);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error en la modificacion", "Alerta", JOptionPane.DEFAULT_OPTION);
                    mv.dispose();
                }
                
                
                break;
        }
        
        
    }
    
    public boolean ejecutarConsulta(boolean hacer){
        String consulta;
        c.iniciarConexion();
        if(hacer){
            consulta = "update punto_venta.Vendedor set nombreVendedor='"+
                    mv.getNombre().getText()+"', apPaterno='"+mv.getApPaterno().getText()+
                    "', apMaterno='"+mv.getApMaterno().getText()+"', fechaNac='"+mv.getFechanacimiento().getText()+
                    "', correoVendedor='"+mv.getCorreo().getText()+"', direccionVendedor='"+mv.getDireccion().getText()+
                    "', sexo='"+mv.getSexo().getText()+"', sueldo='"+mv.getSueldo().getText()+"', fechaIngresoVendedor='"+
                    mv.getFechaIngreso().getText()+"', usuario='"+mv.getUsuario().getText()+"', contrasena='"+mv.getContraseña().getText()+
                    "', isAdmin='"+mv.getAdmin().getText()+"' where idVendedor ="
                    +mv.getIds().get(mv.getVendedores().getSelectedIndex()).toString()+";";
        }
        else{
            consulta = "delete from punto_venta.Vendedor where idVendedor="
                    +mv.getIds().get(mv.getVendedores().getSelectedIndex()).toString()+";";
            
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
