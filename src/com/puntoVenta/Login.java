package com.puntoVenta;

import javax.swing.JFrame;

/**
 * @author Luis
 * Created on 17/12/2014, 10:53:59 AM
 */

public class Login extends JFrame{
    private PanelLogin log;
    
    public Login() {
        
        super("PiñaSports");
        setSize(500, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
       
    }

    
    
    
    public static void main(String[] args) {
        Login log = new Login();
        PanelLogin panel = new PanelLogin();
        OyenteLogin oyente = new OyenteLogin(panel);
        log.addWindowListener(oyente);
        panel.addEventos(oyente);
        log.add(panel);
        log.setVisible(true);
    }
}
