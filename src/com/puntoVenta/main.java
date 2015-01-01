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
        mostrarLogin();
    }
    
    public static void  mostrarLogin(){
        Login ventanaLogin = new Login();
        PanelLogin panel = new PanelLogin();
        OyenteLogin oyente = new OyenteLogin(panel,ventanaLogin);
        
        
        ventanaLogin.addWindowListener(oyente);
        panel.addEventos(oyente);
        ventanaLogin.add(panel);
        
        ventanaLogin.setVisible(true);
    }
    
    public static void setLookAndFeel(){
       try{
            //Poner el nombre de la aplicacion en la barra de tareas (OS X)
            System.setProperty( "com.apple.mrj.application.apple.menu.about.name", "PiñaSports" );
            
            //Poner el JMenuBar en la barra de tareas de OS X
            System.setProperty( "com.apple.macos.useScreenMenuBar", "true" );
            
            //Poner el JMenuBar en la barra de tareas de OS X -Versiones antiguas de Java
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            
            //Colocar el look and feel del sistema operativo que se esté usando
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch(UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
                | IllegalAccessException e){
            
        }
         
    }

   
    
}
