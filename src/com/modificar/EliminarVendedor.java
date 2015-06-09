/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import static com.modificar.ModificarVendedor.ListToArray;
import com.puntoVenta.Conexion;
import com.puntoVenta.Vendedor;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author JR
 */
public class EliminarVendedor extends JFrame{
    Conexion c ;
    private JComboBox vendedores;
    private JButton cancelar = new JButton("Cancelar");
    private JButton registrar = new JButton("Modificar");
    private JTextField nombre;
    private JTextField apPaterno;
    private JTextField apMaterno;
    private JTextField fechanacimiento;
    private JTextField direccion;
    private JTextField correo;
    private JTextField sexo;
    private JTextField fechaIngreso;
    private JTextField sueldo;
    private JTextField usuario;
    private JPasswordField contraseña;
    private JTextField Admin;
    private ArrayList Atributos;
    private ArrayList ids = new ArrayList<>();
    private ArrayList v = new ArrayList <String []> ();
    
    
    public EliminarVendedor(Conexion c) throws SQLException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setTitle("Eliminar Vendedor");
        this.setSize(320, 120);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        addComponentes();
        addEventos(new OyenteEliminarVendedor(c, this));
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
    }
    
   
    public void addComponentes() throws SQLException{
                c.iniciarConexion();
        String consulta = "select Vendedor.idVendedor, Vendedor.nombreVendedor, Vendedor.apPaterno, Vendedor.apMaterno from Vendedor;";
        try {
        c.setResult(c.getStament().executeQuery(consulta));
        while (c.getResult().next()) {
                    Atributos = new ArrayList <String[]>();
                    for (int i = 0; i < c.getResult().getMetaData().getColumnCount(); i++) {
                        Atributos.add(c.getResult().getString(i + 1));
                        }
                    ids.add(Atributos.get(0).toString());
                    v.add(Atributos);
                    
            
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        vendedores = new JComboBox(ListToArray(v));
        c.cerrarConexion();
        
        
        setVendedores(new JComboBox(ListToArray(getV())));
        getRegistrar().setText("Eliminar");
        JPanel p = new JPanel();
        JPanel p2 = new JPanel();
        JPanel panel = new JPanel();
        p.add(getVendedores());
        
        p2.add(getCancelar());
        p2.add(getRegistrar());
        
        panel.add(p, "North");
        panel.add(p2, "South");
        
        this.add(panel, "Center");
    }

    private void addEventos(OyenteEliminarVendedor o) {
        cancelar.addActionListener(o);
        registrar.addActionListener(o);
       
    }
    
    static String [] ListToArray(ArrayList v){
        String returnThis[] = new String[v.size()];
        for (int i = 0; i < v.size(); i++) {
            returnThis [i] = v.get(i).toString();
        }
        return returnThis;
    }
    

    public Conexion getC() {
        return c;
    }

    public void setC(Conexion c) {
        this.c = c;
    }

    public JComboBox getVendedores() {
        return vendedores;
    }

    public void setVendedores(JComboBox vendedores) {
        this.vendedores = vendedores;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }

    public JButton getRegistrar() {
        return registrar;
    }

    public void setRegistrar(JButton registrar) {
        this.registrar = registrar;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    public JTextField getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(JTextField apPaterno) {
        this.apPaterno = apPaterno;
    }

    public JTextField getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(JTextField apMaterno) {
        this.apMaterno = apMaterno;
    }

    public JTextField getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(JTextField fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public JTextField getDireccion() {
        return direccion;
    }

    public void setDireccion(JTextField direccion) {
        this.direccion = direccion;
    }

    public JTextField getCorreo() {
        return correo;
    }

    public void setCorreo(JTextField correo) {
        this.correo = correo;
    }

    public JTextField getSexo() {
        return sexo;
    }

    public void setSexo(JTextField sexo) {
        this.sexo = sexo;
    }

    public JTextField getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(JTextField fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public JTextField getSueldo() {
        return sueldo;
    }

    public void setSueldo(JTextField sueldo) {
        this.sueldo = sueldo;
    }

    public JTextField getUsuario() {
        return usuario;
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public JPasswordField getContraseña() {
        return contraseña;
    }

    public void setContraseña(JPasswordField contraseña) {
        this.contraseña = contraseña;
    }

    public JTextField getAdmin() {
        return Admin;
    }

    public void setAdmin(JTextField Admin) {
        this.Admin = Admin;
    }

    public ArrayList getAtributos() {
        return Atributos;
    }

    public void setAtributos(ArrayList Atributos) {
        this.Atributos = Atributos;
    }

    public ArrayList getIds() {
        return ids;
    }

    public void setIds(ArrayList ids) {
        this.ids = ids;
    }

    public ArrayList getV() {
        return v;
    }

    public void setV(ArrayList v) {
        this.v = v;
    }

   
    
}
