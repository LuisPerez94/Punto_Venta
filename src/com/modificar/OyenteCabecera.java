/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JR
 */
public class OyenteCabecera extends OyenteEliminarFactura{

    public OyenteCabecera(Conexion c, EliminarFactura aThis) {
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
                    JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
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
        String consulta, preconsulta="";
        c.iniciarConexion();
            preconsulta = "DELETE Detalle_fact FROM Detalle_fact, Cab_fact\n" +
            "WHERE Detalle_fact.Cab_fact_idCab_fact = Cab_fact.idCab_fact\n" +
            "and Cab_fact.idCab_fact="+super.aThis.ids.get(super.aThis.factura.getSelectedIndex()).toString()+";";
            consulta = "delete from punto_venta.Cab_fact where idCab_fact="
                    +super.aThis.ids.get(super.aThis.factura.getSelectedIndex()).toString()+";";
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
