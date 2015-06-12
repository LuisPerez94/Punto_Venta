package com.puntoVenta;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
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
    private CallableStatement cst;

    public Conexion(String usuario, String password, String puerto, String host) {
        this.usuario = usuario;
        this.password = password;
        this.puerto = puerto;
        this.host = host;
        this.SID = "XE";
        url = "jdbc:oracle:thin:@" + host + ":" + puerto + ":" + SID;
    }

    public void registrarDriver() throws SQLException {
        OracleDriver oracleDriver = new OracleDriver();
        DriverManager.registerDriver(oracleDriver);

    }

    public void iniciarConexion() throws SQLException {
        if (conexion == null || conexion.isClosed() == true) {
            registrarDriver();
            conexion = DriverManager.getConnection(url, usuario, password);
            stament = conexion.createStatement();
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
//                    int i = stament.executeUpdate("INSERT INTO Producto (nombreProducto,precio,rutaImagen,descripcionProducto,existencias) VALUES"
//                            + " ('" + datos.get(0) + "','" + datos.get(1) + "','" + datos.get(2) + "','" + datos.get(3) + "','" + datos.get(4) + "')");
//
//                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Correcto",
//                            JOptionPane.INFORMATION_MESSAGE);
//
//                } catch (SQLException | HeadlessException e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }

                    cst = conexion.prepareCall("{call producto_ins (?,?,?,?,?,?)}");
                    cst.setString(1, idMax(opcion));
                    cst.setString(2, datos.get(0));
                    cst.setFloat(3, Float.parseFloat(datos.get(1)));
                    cst.setString(4, datos.get(2));
                    cst.setString(5, datos.get(3));
                    cst.setString(6, datos.get(4));

                    cst.execute();
                    cst.close();
                    JOptionPane.showMessageDialog(null, "Consulta realizada con exito");
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                break;
            case "C": {
                try {
                    //
//                try {
//                    int i = stament.executeUpdate("INSERT INTO Cliente (nombreCliente,apPaterno,apMaterno,direccionCliente,correoCliente,telefono,sexo) VALUES"
//                            + " ('" + datos.get(0) + "','" + datos.get(1) + "','" + datos.get(2) + "','" + datos.get(3) +"','"+datos.get(4)+"','"+datos.get(5)+"','"+datos.get(6)+"')");
//                } catch (SQLException ex) {
//                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente", "Correcto",
//                        JOptionPane.INFORMATION_MESSAGE);

                    cst = conexion.prepareCall("{call cliente_ins (?,?,?,?,?,?,?,?)}");
                    cst.setString(1, idMax(opcion));
                    cst.setString(2, datos.get(0));
                    cst.setString(3, datos.get(1));
                    cst.setString(4, datos.get(2));
                    cst.setString(5, datos.get(3));
                    cst.setString(6, datos.get(4));
                    cst.setLong(7, Long.parseLong(datos.get(5)));
                    cst.setString(8, datos.get(6));
                    cst.execute();

                    cst.close();
                    JOptionPane.showMessageDialog(null, "Consulta realizada con exito");

                } catch (SQLException ex) {
                    System.out.println("Error " + ex);
                }
            }

            break;
            case "V": {
                try {
//                int i=stament.executeUpdate("INSERT INTO punto_venta.Vendedor (nombreVendedor, apPaterno,apMaterno,fechaNac,correoVendedor,direccionVendedor, sexo,sueldo,fechaIngresoVendedor, usuario,contrasena, isAdmin) VALUES "
//                        + "('"+datos.get(0)+"','"+datos.get(1)+"','"+datos.get(2)+"','"+datos.get(3)+"','"+datos.get(4)+"','"+datos.get(5)+"','"+datos.get(6)+"','"+datos.get(7)+"','"+datos.get(8)+"','"+datos.get(9)+"','"+datos.get(10)+"','"+datos.get(11)+"')");
//                
//                JOptionPane.showMessageDialog(null, "Vendedor agregado correctamente", "Correcto",
//                        JOptionPane.INFORMATION_MESSAGE);
//            } catch (SQLException ex) {
//                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
                    cst = conexion.prepareCall("{call vendedor_ins (?,?,?,?,?,?,?,?,?)}");
                    cst.setString(1, idMax(opcion));
                    cst.setString(2, datos.get(0));
                    cst.setString(3, datos.get(1));
                    cst.setString(4, datos.get(2));
                    cst.setString(5, datos.get(3));
                    cst.setString(6, datos.get(4));
                    cst.setString(7, datos.get(5));
                    cst.setString(8, datos.get(6));
                    cst.setLong(9, Long.parseLong(datos.get(7)));

                    cst.execute();
                    cst.close();
                    JOptionPane.showMessageDialog(null, "Consulta realizada con exito");

                    //FALTA DARLE PERMISOS 
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
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

    private String idMax(String opcion) throws SQLException {
        String nombreTabla = null;
        int id = 0;
        switch (opcion) {
            case "P":
                nombreTabla = "Producto";
                break;
            case "C":
                nombreTabla = "Cliente";
                break;
            case "V":
                nombreTabla = "Vendedor";
                break;
        }
        result = stament.executeQuery("SELECT MAX(to_number(id" + nombreTabla + ")) from " + nombreTabla);
        if (result.next()) {
            id = Integer.parseInt((result.getObject(1) + "").trim());
            // Agregamos uno porque va a ser el id siguiente...
            id++;
        }
        System.out.println(id);
        return id + "";
    }
}
