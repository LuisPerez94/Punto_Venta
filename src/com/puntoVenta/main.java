/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

/**
 *
 * @author luis
 */
public class main {
    
    public static void main(String[] args) {
        
        Login ventanalogin = new Login();
        PanelLogin panel = new PanelLogin();
        OyenteLogin oyente = new OyenteLogin(panel,ventanalogin);
        
        
        ventanalogin.addWindowListener(oyente);
        panel.addEventos(oyente);
        ventanalogin.add(panel);
        ventanalogin.setVisible(true);
    }
    
}
