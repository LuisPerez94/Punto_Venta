package com.puntoVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 * @author Luis Created on 17/12/2014, 11:31:19 AM
 */
public class OyenteLogin extends KeyAdapter implements ActionListener, WindowListener {

    private final PanelLogin panel;
    private Conexion vendedor;
    private final Login ventanaLogin;

    OyenteLogin(PanelLogin panel, Login ventanaLogin) {
        this.panel = panel;
        this.ventanaLogin = ventanaLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        iniciarSesion();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int opcion = JOptionPane.showConfirmDialog(panel, "Seguro que quieres salir?", "Advertencia", JOptionPane.OK_CANCEL_OPTION);

        if (opcion == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarSesion();
        }
    }

    public void iniciarSesion() {
        String usuario, contraseña, ip;
        usuario = panel.getUsuario().getText();
        String isAdmin = panel.getUsuario().getText();
        contraseña = new String(panel.getContrasena().getPassword());

        ip = panel.getIp().getText();
        if ("".equals(usuario) || "".equals(contraseña) || "".equals(ip)) {
            JOptionPane.showMessageDialog(panel, "Debes acompletar todos los campos");
        } else {
            
            if ("Luis".equals(isAdmin)) {
                isAdmin = "T";
            } else {
                isAdmin = "";
            }
            try {

                vendedor = new Conexion(panel.getUsuario().getText(), new String(panel.getContrasena().getPassword()),
                        "1521", panel.getIp().getText());
                vendedor.iniciarConexion();
                Reportes reporte = new Reportes(isAdmin);
                OyenteReportes or = new OyenteReportes(reporte, vendedor);
                or.setNombreVendedor(panel.getUsuario().getText());
                reporte.addEventos(or);
                ventanaLogin.dispose();

            } catch (SQLException | NullPointerException ex) {
                JOptionPane.showMessageDialog(panel, "Usuario y/o contraseña incorrectos");
                limpiardatos();

            }
        }
    }

    public void limpiardatos() {
        panel.getUsuario().setText("");
        panel.getContrasena().setText("");
        panel.getIp().setText("");
        panel.getUsuario().requestFocus();
    }

    public Conexion getVendedor() {
        return vendedor;
    }

    public void setVendedor(Conexion vendedor) {
        this.vendedor = vendedor;
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
