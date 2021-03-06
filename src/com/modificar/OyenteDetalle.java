/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JR
 */
public class OyenteDetalle extends OyenteEliminarFactura{

    public OyenteDetalle(Conexion c, EliminarFactura aThis) {
        super(c, aThis);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Cancelar":
                System.out.println("cancelar1");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres cancelar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                    super.aThis.dispose();
                break;
            
            case "Eliminar":
                System.out.println("Drop1");
                if(JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                    if(ejecutarConsulta()){
                    JOptionPane.showMessageDialog(null, "Se elimino con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Error en la modificacion", "Alerta", JOptionPane.DEFAULT_OPTION);
                    super.aThis.dispose();
                }
                
                
                break;
        }
        
        
    }
    
    @Override
    protected boolean ejecutarConsulta() {
        String consulta;
        try {
            c.iniciarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(OyenteDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            consulta = "delete from punto_venta.Detalle_fact where idDetalle_fact="
                    +super.aThis.ids.get(super.aThis.factura.getSelectedIndex()).toString()+";";
            
        
        try {
            System.out.println(consulta);
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
