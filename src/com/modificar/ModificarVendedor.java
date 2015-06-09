/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ModificarVendedor extends JFrame{
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
    private Vendedor vendedor;
    
    public ModificarVendedor(Conexion c) throws SQLException {
        this.setTitle("Modificar Vendedor");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setSize(405, 510);
        this.setResizable(false);
        addComponentes();
        addEventos(new OyenteModificarVendedor(c, this));
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
        
    }
    
    
    protected void addComponentes() throws SQLException{
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
        vendedor = new Vendedor();
        consulta = "select * from Vendedor where idVendedor="+(ids.get(0).toString());
        System.out.println(consulta);
        try {
            c.setResult(c.getStament().executeQuery(consulta));
            while(c.getResult().next()){
                vendedor.setNombreVendedor(c.getResult().getString(2));
                vendedor.setApPaterno(c.getResult().getString(3));
                vendedor.setApMaterno(c.getResult().getString(4));
                vendedor.setFechaNac(c.getResult().getString(5).replace("-", "/"));
                vendedor.setCorreoVendedor(c.getResult().getString(6));
                vendedor.setDireccion(c.getResult().getString(7));
                vendedor.setSexo(c.getResult().getString(8).charAt(0));
                vendedor.setSueldo(Float.parseFloat(c.getResult().getString(9)));
                vendedor.setFechaIngresoVendedor(c.getResult().getString(10).replace("-", "/"));
                vendedor.setNombUsuario(c.getResult().getString(11));
                vendedor.setContrasena(c.getResult().getString(12));
               
                
                
                if(c.getResult().getString(13).equals("T")){
                    vendedor.setIsAdministrador(true);
                }else{
                    vendedor.setIsAdministrador(false);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        c.cerrarConexion();
        
        
        JPanel panelSur = new JPanel();
        JPanel panelCentro = new JPanel();
        GridLayout gl2 = new GridLayout(13, 2);
        panelCentro.setLayout(gl2);
        panelCentro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 15));
        
        String sueldoString =  ""+vendedor.getSueldo();
        String isAdminChar, sexoString=""+vendedor.getSexo();
        
        cancelar = new JButton("Cancelar");
        registrar = new JButton("Modificar");
        
        nombre = new JTextField(vendedor.getNombreVendedor());
        apPaterno = new JTextField(vendedor.getApPaterno());
        apMaterno = new JTextField(vendedor.getApMaterno());
        fechanacimiento = new JTextField(vendedor.getFechaNac());
        fechanacimiento.setName("fechaNacimiento");
        direccion = new JTextField(vendedor.getDireccion());
        correo = new JTextField(vendedor.getCorreoVendedor());
        correo.setName("correo");
        sexo = new JTextField(sexoString);
        sexo.setName("sexo");
        fechaIngreso = new JTextField(vendedor.getFechaIngresoVendedor());
        fechaIngreso.setName("fechaIngreso");
        sueldo = new JTextField(sueldoString);
        sueldo.setName("sueldo");
        usuario = new JTextField(vendedor.getNombUsuario());
        contraseña = new JPasswordField(vendedor.getContrasena());
        if(vendedor.isIsAdministrador())
            isAdminChar = "T";
        else
            isAdminChar = "F";
        Admin = new JTextField(isAdminChar);
        Admin.setName("admin");
        
        panelCentro.add(new JLabel("Modificar a:"));
        panelCentro.add(vendedores);
        
        panelCentro.add(new JLabel("Nombre: "));
        panelCentro.add(nombre);
        panelCentro.add(new JLabel("Apellido paterno: "));
        panelCentro.add(apPaterno);
        panelCentro.add(new JLabel("Apellido materno: "));
        panelCentro.add(apMaterno);
        panelCentro.add(new JLabel("Fecha de nacimiento: YYYY/MM/dd"));
        panelCentro.add(fechanacimiento);
        panelCentro.add(new JLabel("E-mail: "));
        panelCentro.add(correo);
        panelCentro.add(new JLabel("Dirección: "));
        panelCentro.add(direccion);
        panelCentro.add(new JLabel("Sexo:   M/F"));
        panelCentro.add(sexo);
        panelCentro.add(new JLabel("Sueldo:"));
        panelCentro.add(sueldo);
        panelCentro.add(new JLabel("Fecha de ingreso:  YYYY/MM/dd"));
        panelCentro.add(fechaIngreso);
        panelCentro.add(new JLabel("Usuario: "));
        panelCentro.add(usuario);
        panelCentro.add(new JLabel("Contraseña: "));
        panelCentro.add(contraseña);
        panelCentro.add(new JLabel("¿Administrador? : (T/F)"));
        panelCentro.add(Admin);
        
        panelSur.add(cancelar);
        panelSur.add(registrar);
        
        this.add(panelSur,"South");
        this.add(panelCentro, "Center");
    }

    private void addEventos(OyenteModificarVendedor oyenteModificarVendedor) {
        cancelar.addActionListener(oyenteModificarVendedor);
        registrar.addActionListener(oyenteModificarVendedor);
        sexo.addKeyListener(oyenteModificarVendedor);
        sueldo.addKeyListener(oyenteModificarVendedor);
        Admin.addKeyListener(oyenteModificarVendedor);
        vendedores.addItemListener(oyenteModificarVendedor);
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
    
}
