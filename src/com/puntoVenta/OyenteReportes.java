/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;

/**
 *
 * @author JR
 */
public class OyenteReportes implements ActionListener{
    static Reportes r;
    PanelVentas p;
    PanelVendedores p1;
    PanelProductos p2;
    
    public OyenteReportes(){
    }

    public OyenteReportes(Reportes r) {
        this.r = r;
    }
    
    public Reportes getR() {
        return r;
    }

    public void setR(Reportes r) {
        this.r = r;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Ventas":
                
                System.out.println("Ventas");
                p = new PanelVentas();
                try {
                    r.remove(p);
                    r.remove(p1);
                    r.remove(p2);
                    
                } catch (Exception ex) {
                    r.add(p);
                    
                }
                
                r.add(p);
                r.setpVentas(p);
                SwingUtilities.updateComponentTreeUI(r);
                r.validate();
               
                
                break;
            case "Ventas por Vendedor":
                    System.out.println("aqui se muestra las ventas por vendedor");
                    p1 = new PanelVendedores();
                    try {
                        r.remove(p);
                        r.remove(p1);
                        r.remove(p2);
                    
                    } catch (Exception ex) {
                        r.add(p1);

                    }
                    r.add(p1);
                    r.setpVendedores(p1);
                    SwingUtilities.updateComponentTreeUI(r);
                    r.validate();
                    break;
            case "Productos mas vendidos":
                System.out.println("Aqui se muestran los productos mas vendidos");
                p2 = new PanelProductos();
                try {
                    r.remove(p);
                    r.remove(p1);
                    r.remove(p2);
                    
                } catch (Exception ex) {
                    r.add(p2);
                    
                }
                r.add(p2);
                r.setpProductos(p2);
                SwingUtilities.updateComponentTreeUI(r);
                r.validate();
                break;
            case "Salir":
                System.out.println("Con esto puedes salir");
                r.dispose();
                break;
            case "Acerca de":
                System.out.println("Mostrara acerca del programa");
                JOptionPane.showConfirmDialog(null, "2014,2015 PiñaSports©", "Acerca de", JOptionPane.DEFAULT_OPTION);
                
                break;
            case "Actualizar":
                System.out.println("Aqui actualizara");
                break;
            case "Buscar": 
                System.out.println("Con esto buscara");
                break;
        }
    }
    
    
    
}
