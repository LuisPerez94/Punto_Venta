/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JR
 */
public class OyenteEliminarAlmacen implements ActionListener{

    Conexion c;
    EliminarAlmacen aThis;        
    public OyenteEliminarAlmacen(Conexion c, EliminarAlmacen aThis) {
        
        this.c = c;
        this.aThis = aThis;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Cancelar":
                System.out.println("cancelar1");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres cancelar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                    aThis.dispose();
                break;
            
            case "Eliminar":
                System.out.println("Drop1");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                    if(ejecutarConsulta()){
                    JOptionPane.showMessageDialog(null, "Se elimino con exito", "Exito", JOptionPane.DEFAULT_OPTION);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error en la modificacion", "Alerta", JOptionPane.DEFAULT_OPTION);
                    aThis.dispose();
                }
                
                
                break;
        }
    }
    
   
    protected boolean ejecutarConsulta() {
        String consulta, preconsulta="";
        c.iniciarConexion();
            preconsulta = "delete Guarda from Guarda, Almacen where Guarda.Almacen_idAlmacen = Almacen.idAlmacen\n" +
            "and Almacen.idAlmacen = "+aThis.getIds().get(aThis.getAlmacenes().getSelectedIndex()).toString()+";";
            consulta = "delete from punto_venta.Almacen where idAlmacen="
                    +aThis.getIds().get(aThis.getAlmacenes().getSelectedIndex()).toString()+";";
            System.out.println(preconsulta);
            System.out.println(consulta);
            
        
        try {
            System.out.println(consulta);
            if(!preconsulta.equals("")){
                c.getStament().execute(preconsulta);
            }
            if(c.getStament().execute(consulta))
                return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error "+ex.toString(), "Alerta", JOptionPane.DEFAULT_OPTION);
            System.out.println(ex);
            return false;
        }
        return true;
    }
    
    
    
}
