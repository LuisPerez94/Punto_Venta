/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public ModificarVendedor(Conexion c) {
        this.setTitle("Modificar Vendedor");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setSize(600, 300);
        this.setResizable(false);
        addComponentes();
        addEventos(new OyenteModificarVendedor(c, this));
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    
    protected void addComponentes(){
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
        c.cerrarConexion();
        vendedores = new JComboBox(ListToArray(v));
        
        JPanel panelSur = new JPanel();
        JPanel panelCentro = new JPanel();
        GridLayout gl1 = new GridLayout(1, 2);
        panelSur.setLayout(gl1);
        JPanel panelIzqSur = new JPanel();
        JPanel panelDerSur = new JPanel();
        GridLayout gl2=new GridLayout(12, 2);
        panelCentro.setLayout(gl2);
        cancelar=new JButton("Cancelar");
        registrar=new JButton("Modificar");
        
        nombre = new JTextField();
        apPaterno = new JTextField();
        apMaterno = new JTextField();
        fechanacimiento = new JTextField();
        fechanacimiento.setName("fechaNacimiento");
        direccion = new JTextField();
        correo = new JTextField();
        correo.setName("correo");
        sexo = new JTextField();
        sexo.setName("sexo");
        fechaIngreso = new JTextField();
        fechaIngreso.setName("fechaIngreso");
        sueldo = new JTextField();
        sueldo.setName("sueldo");
        usuario = new JTextField();
        contraseña = new JPasswordField();
        Admin = new JTextField();
        Admin.setName("admin");
        
        JPanel norte  =new JPanel(new BorderLayout());
        norte.add(new JLabel("Modificar a:"), "West");
        norte.add(vendedores, "East");
        
        
        panelCentro.add(new JLabel("Nombre :"));
        panelCentro.add(nombre);
        panelCentro.add(new JLabel("Apellido Paterno :"));
        panelCentro.add(apPaterno);
        panelCentro.add(new JLabel("Apellido Materno :"));
        panelCentro.add(apMaterno);
        panelCentro.add(new JLabel("Fecha de Nacimiento : YYYY/MM/dd"));
        panelCentro.add(fechanacimiento);
        panelCentro.add(new JLabel("EMAIL :"));
        panelCentro.add(correo);
        panelCentro.add(new JLabel("Dirección :"));
        panelCentro.add(direccion);
        panelCentro.add(new JLabel("Sexo :   M/F"));
        panelCentro.add(sexo);
        panelCentro.add(new JLabel("Sueldo :"));
        panelCentro.add(sueldo);
        panelCentro.add(new JLabel("Fecha de ingreso :  YYYY/MM/dd"));
        panelCentro.add(fechaIngreso);
        panelCentro.add(new JLabel("Usuario :"));
        panelCentro.add(usuario);
        panelCentro.add(new JLabel("Contraseña :"));
        panelCentro.add(contraseña);
        panelCentro.add(new JLabel("Administrador? : (T/F)"));
        panelCentro.add(Admin);
        
        
        
        
        panelIzqSur.add(cancelar);
        panelDerSur.add(registrar);
        
        panelSur.add(panelIzqSur);
        panelSur.add(panelDerSur);
        this.add(norte, "North");
        this.add(panelSur,"South");
        this.add(panelCentro, "Center");
    }

    private void addEventos(OyenteModificarVendedor oyenteModificarVendedor) {
        cancelar.addActionListener(oyenteModificarVendedor);
        registrar.addActionListener(oyenteModificarVendedor);
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
