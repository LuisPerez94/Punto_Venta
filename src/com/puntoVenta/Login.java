package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        
    }
    
    
    public static void main(String[] args) {
        Login log = new Login();
        PanelLogin panel = new PanelLogin();
        OyenteLogin oyente = new OyenteLogin(panel);
        log.addWindowListener(oyente);
        panel.addEventos(oyente);
        
        log.add(panel);
    }
}
