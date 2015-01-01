/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Conexion;
import java.awt.event.ActionListener;

/**
 *
 * @author JR
 */
public abstract class OyenteEliminarFactura implements ActionListener{
    Conexion c;
    EliminarFactura aThis;
    OyenteEliminarFactura(Conexion c, EliminarFactura aThis) {
        this.c = c;
        this.aThis = aThis ;
    }
    
    protected abstract boolean ejecutarConsulta();
    
}
