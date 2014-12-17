package com.puntoVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

/**
 * @author Luis
 * Created on 17/12/2014, 11:31:19 AM
 */

public class OyenteLogin extends KeyAdapter implements ActionListener, WindowListener{
    private final PanelLogin panel;
    
    OyenteLogin(PanelLogin panel){
        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        iniciarSesion();
    }
    
    @Override
    public void windowClosing(WindowEvent e) {
        int opcion = JOptionPane.showConfirmDialog(panel, "Seguro que quieres salir?", "Advertencia", JOptionPane.OK_CANCEL_OPTION);

        if(opcion == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(panel, "Pues no :c");
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            iniciarSesion();
        }
    }
    
    public void iniciarSesion(){
        JOptionPane.showMessageDialog(panel, "You shall not pass", "No", JOptionPane.ERROR_MESSAGE);
        System.out.println("Usuario: " + panel.getUsuario().getText()
                            + "\nContraseña: " + panel.getContrasena().getText());
    }
    
    // Métodos sin usar de la implementación de WindowListener
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
