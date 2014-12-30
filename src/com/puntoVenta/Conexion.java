package com.puntoVenta;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Luis Created on 19/12/2014, 09:27:57 PM
 */
public class Conexion {

    private final String usuario;
    private final String password;
    private final String puerto;
    private final String host;
    private final String bd;
    private final String url;
    private Connection conexion;
    private Statement stament;
    private ResultSet result;

    public Conexion(String usuario, String password, String puerto, String host, String bd) {
        this.usuario = usuario;
        this.password = password;
        this.puerto = puerto;
        this.host = host;
        this.bd = bd;
        url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd;
    }

    public boolean iniciarConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, usuario, password);
            stament = conexion.createStatement();
            return conexion != null;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    public void insertarDatos(String opcion, ArrayList<String> datos) {
        switch (opcion) {
            case "P":
                //insertar producto
                try {
                    int i = stament.executeUpdate("INSERT INTO Producto (nombreProducto,precio,rutaImagen,descripcionProducto) VALUES"
                            + " ('" + datos.get(0) + "','" + datos.get(1) + "','" + datos.get(2) + "','" + datos.get(3) + "')");

                    JOptionPane.showMessageDialog(null, "EXITO EN LA CONSULTA");

                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
            case "C":

                try {
                    int i = stament.executeUpdate("INSERT INTO Cliente (nombreCliente,apPaterno,apMaterno,direccionCliente,correoCliente,telefono,sexo) VALUES"
                            + " ('" + datos.get(0) + "','" + datos.get(1) + "','" + datos.get(2) + "','" + datos.get(3) +"','"+datos.get(4)+"','"+datos.get(5)+"','"+datos.get(6)+"')");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "EXITO EN LA CONSULTA");

                break;
            case "V":
        {
            try {
                int i=stament.executeUpdate("INSERT INTO punto_venta.Vendedor (nombreVendedor, apPaterno,apMaterno,fechaNac,correoVendedor,direccionVendedor, sexo,sueldo,fechaIngresoVendedor, usuario,contrasena, isAdmin) VALUES "
                        + "('"+datos.get(0)+"','"+datos.get(1)+"','"+datos.get(2)+"','"+datos.get(3)+"','"+datos.get(4)+"','"+datos.get(5)+"','"+datos.get(6)+"','"+datos.get(7)+"','"+datos.get(8)+"','"+datos.get(9)+"','"+datos.get(10)+"','"+datos.get(11)+"')");
                
                JOptionPane.showMessageDialog(null, "EXITO EN LA CONSULTA");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
        }

    }

    public Statement getStament() {
        return stament;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

}
