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
import oracle.jdbc.OracleDriver;

/**
 * @author Luis Created on 19/12/2014, 09:27:57 PM
 */
public class Conexion {
    private final String usuario;
    private final String password;
    private final String SID;
    private final String puerto;
    private final String host;
    private final String url;
    private Connection conexion;
    private Statement stament;
    private ResultSet result;

    public Conexion(String usuario, String password, String puerto, String host) {
        this.usuario = usuario;
        this.password = password;
        this.puerto = puerto;
        this.host = host;
        this.SID="XE";
        url = "jdbc:oracle:thin:@" + host + ":" + puerto + ":" + SID;
    }

   
     public void registrarDriver()throws SQLException{
      OracleDriver oracleDriver=new OracleDriver();
            DriverManager.registerDriver(oracleDriver);
            
     }
    
    public void iniciarConexion() throws SQLException {
        if(conexion==null || conexion.isClosed()==true){
        registrarDriver();
        conexion = DriverManager.getConnection(url,usuario,password);
        stament=conexion.createStatement();
        }
    }

    public void cerrarConexion() throws SQLException {
         if (conexion != null && conexion.isClosed() == false) {
            conexion.close();
        }
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void insertarDatos(String opcion, ArrayList<String> datos) {
        switch (opcion) {
            case "P":
                //insertar producto
                try {
                    int i = stament.executeUpdate("INSERT INTO Producto (nombreProducto,precio,rutaImagen,descripcionProducto,existencias) VALUES"
                            + " ('" + datos.get(0) + "','" + datos.get(1) + "','" + datos.get(2) + "','" + datos.get(3) + "','" + datos.get(4) + "')");

                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Correcto",
                            JOptionPane.INFORMATION_MESSAGE);

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

                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);

                break;
            case "V":
        {
            try {
                int i=stament.executeUpdate("INSERT INTO punto_venta.Vendedor (nombreVendedor, apPaterno,apMaterno,fechaNac,correoVendedor,direccionVendedor, sexo,sueldo,fechaIngresoVendedor, usuario,contrasena, isAdmin) VALUES "
                        + "('"+datos.get(0)+"','"+datos.get(1)+"','"+datos.get(2)+"','"+datos.get(3)+"','"+datos.get(4)+"','"+datos.get(5)+"','"+datos.get(6)+"','"+datos.get(7)+"','"+datos.get(8)+"','"+datos.get(9)+"','"+datos.get(10)+"','"+datos.get(11)+"')");
                
                JOptionPane.showMessageDialog(null, "Vendedor agregado correctamente", "Correcto",
                        JOptionPane.INFORMATION_MESSAGE);
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
 public Connection getConexion() {
        return conexion;
    }

    /**
     * @return the puerto
     */
    public String getPuerto() {
        return puerto;
    }
}
