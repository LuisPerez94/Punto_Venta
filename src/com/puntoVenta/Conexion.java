package com.puntoVenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
