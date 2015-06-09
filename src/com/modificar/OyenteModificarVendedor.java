/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author JR
 */
public class OyenteModificarVendedor implements ActionListener,ItemListener , KeyListener{
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
                if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cancelar?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                    mv.dispose();
                break;
            case "Modificar":
                EmailValidator ev= new EmailValidator();
                System.out.println("Update");
                if(ev.validate(mv.getCorreo().getText())){
                     if(isDate(mv.getFechaIngreso().getText()) && isDate(mv.getFechanacimiento().getText())){
                         try {
                             if(ejecutarConsulta(true)){
                                 JOptionPane.showMessageDialog(null, "Se modificó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                             }
                             else
                                 JOptionPane.showMessageDialog(null, "Error en la modificación", "Error", JOptionPane.ERROR_MESSAGE);
                         } catch (SQLException ex) {
                             Logger.getLogger(OyenteModificarVendedor.class.getName()).log(Level.SEVERE, null, ex);
                         }
                mv.dispose();
                }else{
                           JOptionPane.showMessageDialog(mv, "Las Fechas no son validas");
                         
                     }
                     
                 }else{
                         JOptionPane.showMessageDialog(mv, "El Correo no es valido");
                 }
                break;
            
            case "Eliminar":
                System.out.println("Drop");
                if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres eliminar?", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            try {
                if(ejecutarConsulta(false)){
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Error en la modificación", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteModificarVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
                    mv.dispose();
                }
                
                
                break;
        }
        
        
    }
    
    public boolean ejecutarConsulta(boolean hacer) throws SQLException{
        String consulta, preconsulta="", preconsulta2="";
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
            preconsulta = "DELETE Detalle_fact FROM Detalle_fact, Cab_fact, Vendedor\n" +
            "WHERE Detalle_fact.Cab_fact_idCab_fact = Cab_fact.idCab_fact\n" +
            "and Vendedor.idVendedor = Cab_fact.Vendedor_idVendedor and\n" +
            "Vendedor.idVendedor="+mv.getIds().get(mv.getVendedores().getSelectedIndex()).toString()+";";
            preconsulta2 = "DELETE Cab_fact FROM Cab_fact, Vendedor\n" +
            "WHERE Cab_fact.Vendedor_idVendedor = Vendedor.idVendedor and\n" +
            "Vendedor.idVendedor ="+mv.getIds().get(mv.getVendedores().getSelectedIndex()).toString()+";";
            consulta = "delete from punto_venta.Vendedor where idVendedor="
                    +mv.getIds().get(mv.getVendedores().getSelectedIndex()).toString()+";";
            
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
        System.out.println(e.getKeyChar());
        JTextField campo = (JTextField) e.getSource();
        String accion = campo.getName();
        char car = e.getKeyChar();
        switch (accion) {
            case "sueldo":

                if (mv.getSueldo().getText().length() >= 7) {
                    e.consume();
                }
                if ((car < '0' || car > '9')) {
                    e.consume();
                }
                break;
            case "sexo":
                if (mv.getSexo().getText().length() == 1) {
                    e.consume();
                }
                if (car == 'M' || (car == 'F') || (car == 'f') || (car == 'm')) {
                } else {
                    e.consume();
                }
                break;
            case "admin":
                if(mv.getAdmin().getText().length()==1)e.consume();
               if(car=='t'||(car=='T')||(car=='f')||(car=='F')) {
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
        if(e.getSource().equals(mv.getVendedores())){
            
            try {
                mv.c.iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteModificarVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            String consulta = "select * from Vendedor where idVendedor="+(mv.getIds().get(mv.getVendedores().getSelectedIndex()).toString());
            System.out.println(consulta);
            try {
            c.setResult(c.getStament().executeQuery(consulta));
            while(c.getResult().next()){
                mv.getVendedor().setNombreVendedor(c.getResult().getString(2));
                mv.getVendedor().setApPaterno(c.getResult().getString(3));
                mv.getVendedor().setApMaterno(c.getResult().getString(4));
                mv.getVendedor().setFechaNac(c.getResult().getString(5).replace("-", "/"));
                mv.getVendedor().setCorreoVendedor(c.getResult().getString(6));
                mv.getVendedor().setDireccion(c.getResult().getString(7));
                mv.getVendedor().setSexo(c.getResult().getString(8).charAt(0));
                mv.getVendedor().setSueldo(Float.parseFloat(c.getResult().getString(9)));
                mv.getVendedor().setFechaIngresoVendedor(c.getResult().getString(10).replace("-", "/"));
                mv.getVendedor().setNombUsuario(c.getResult().getString(11));
                mv.getVendedor().setContrasena(c.getResult().getString(12));
               
                
                
                if(c.getResult().getString(13).equals("T")){
                    mv.getVendedor().setIsAdministrador(true);
                }else{
                    mv.getVendedor().setIsAdministrador(false);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
            try {
                c.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteModificarVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        String sueldoString =  ""+mv.getVendedor().getSueldo();
        String isAdminChar, sexoString=""+mv.getVendedor().getSexo();
        mv.getNombre().setText(mv.getVendedor().getNombreVendedor());
        mv.getApPaterno().setText(mv.getVendedor().getApPaterno());
        mv.getApMaterno().setText(mv.getVendedor().getApMaterno());
        mv.getFechanacimiento().setText(mv.getVendedor().getFechaNac());
        mv.getDireccion().setText(mv.getVendedor().getDireccion());
        mv.getCorreo().setText(mv.getVendedor().getCorreoVendedor());
        mv.getSexo().setText(sexoString);
        mv.getFechaIngreso().setText(mv.getVendedor().getFechaIngresoVendedor());
        mv.getSueldo().setText(sueldoString);
        mv.getUsuario().setText(mv.getVendedor().getNombUsuario());
        mv.getContraseña().setText(mv.getVendedor().getContrasena());
        
        if(mv.getVendedor().isIsAdministrador()){
            isAdminChar = "T";
        }else{
            isAdminChar = "F";
        }
                
        mv.getAdmin().setText(isAdminChar);
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
