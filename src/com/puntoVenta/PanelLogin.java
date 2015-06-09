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

public class PanelLogin extends PanelImagen{
    private JButton ok;
    private JTextField usuario;
    private JPasswordField contrasena;
    private JTextField ip;
    
    public PanelLogin(){
        addComponentes();
    }
    
    public final void addComponentes(){
        this.setLayout(new BorderLayout());
        JPanel sur = new JPanel();
        sur.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        ok = new JButton("Ok");
        usuario = new JTextField(9);
        contrasena = new JPasswordField(9);
        ip=new JTextField(15);
        
        JLabel etUsuario = new JLabel("Usuario");
        JLabel etPass = new JLabel("Contraseña");
        JLabel etIp=new JLabel("IP del servidor");
        sur.add(etUsuario);
        sur.add(usuario);
        sur.add(etPass);
        sur.add(contrasena);
        sur.add(etIp);
        sur.add(ip);
        sur.add(ok);
        
        this.add(sur, "South");
    }
    
    public void addEventos(OyenteLogin oyente){
        ok.addActionListener(oyente);
        contrasena.addKeyListener(oyente);
        ip.addKeyListener(oyente);
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

    public JTextField getIp() {
        return ip;
    }
    
    
}
