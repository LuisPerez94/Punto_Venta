package com.puntoVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Luis Created on 17/12/2014, 11:31:19 AM
 */
public class OyenteLogin extends KeyAdapter implements ActionListener, WindowListener {
    private final PanelLogin panel;
    private Conexion vendedor;
    private final Login ventanaLogin;
    
    OyenteLogin(PanelLogin panel,Login ventanaLogin) {
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
        int idUsuario = 0;
        String isAdmin = "";
        
        //inicio sesion con root para ver si en vendedor hay un usuario valido
        Conexion cprueba = new Conexion("poslogin", "poslogin", "3306", "127.0.0.1", "punto_venta");
        cprueba.iniciarConexion();
        try {
            cprueba.setResult(cprueba.getStament().executeQuery("select idVendedor,isAdmin \n"
                    + "from  Vendedor v\n"
                    + "where v.usuario=\'" + panel.getUsuario().getText() + "\' and v.contrasena=\'" + panel.getContrasena().getText() + "\';"));
            //si el recordset tiene algo quiere decir que si hay un usuario 
            if (cprueba.getResult().next()) {

                idUsuario = cprueba.getResult().getInt(1);
                isAdmin=cprueba.getResult().getNString(2);
                cprueba.cerrarConexion(); //cierro a root
                //creamos segun lo que haya en isAdmin
                switch (isAdmin) {
                    case "T":
                        {
                            vendedor = new Conexion("administrador", "123pass", "3306", "127.0.0.1", "punto_venta");
                            Reportes reporte = new Reportes(isAdmin);
                            OyenteReportes or = new OyenteReportes(reporte,vendedor);
                            or.setNombreVendedor(panel.getUsuario().getText());
                            reporte.addEventos(or);
                            ventanaLogin.dispose();
                            break;
                        }
                    case "F":
                        {
                            vendedor = new Conexion("vendedor", "123pass", "3306", "127.0.0.1", "punto_venta");
                            Reportes reporte = new Reportes(isAdmin);
                            OyenteReportes or = new OyenteReportes(reporte,vendedor);
                            or.setNombreVendedor(panel.getUsuario().getText());
                            reporte.addEventos(or);
                            ventanaLogin.dispose();
                            break;
                        }
                }

            } else {
                JOptionPane.showMessageDialog(panel, "Usuario y/o contraseña incorrectos");
                limpiardatos();
            }
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }


    }

    public void limpiardatos() {
        panel.getUsuario().setText("");
        panel.getContrasena().setText("");
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
