package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Luis
 * Created on 17/12/2014, 11:14:57 AM
 */

public class PanelLogin extends JPanel{
    private JButton ok;
    private JTextField usuario;
    private JPasswordField contrasena;
    
    public PanelLogin(){
        addComponentes();
    }
    
    public final void addComponentes(){
        this.setLayout(new BorderLayout());
        JPanel sur = new JPanel();
        sur.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        ok = new JButton("Ok");
        usuario = new JTextField(10);
        contrasena = new JPasswordField(10);
        
        JLabel etUsuario = new JLabel("Usuario");
        JLabel etPass = new JLabel("Contraseña");
        
        sur.add(etUsuario);
        sur.add(usuario);
        sur.add(etPass);
        sur.add(contrasena);
        sur.add(ok);
        
        this.add(sur, "South");
    }
    
    public void addEventos(OyenteLogin oyente){
        ok.addActionListener(oyente);
        contrasena.addKeyListener(oyente);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
    
        String ruta = "/img/sistema/pina.png";
        ImageIcon im = new ImageIcon(getClass().getResource(ruta));
        Image imagen = im.getImage();
        g.drawImage(imagen, 0, 0, this);
       
    }

    public JButton getOk() {
        return ok;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public JPasswordField getContrasena() {
        return contrasena;
    }
    
    
}