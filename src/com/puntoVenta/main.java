/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author luis
 */
public class main {
    
    public static void main(String[] args) {
        setLookAndFeel();
        Login ventanalogin = new Login();
        PanelLogin panel = new PanelLogin();
        OyenteLogin oyente = new OyenteLogin(panel,ventanalogin);
        
        
        ventanalogin.addWindowListener(oyente);
        panel.addEventos(oyente);
        ventanalogin.add(panel);
        
        ventanalogin.setVisible(true);
    }
    
    static void setLookAndFeel(){
         try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception E){}
    }

   
    
}
