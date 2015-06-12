/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.oyentes.OyenteAgregarVendedor;
import com.puntoVenta.Conexion;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author luis
 */

public class AgregarVendedor extends JFrame {
    protected JButton registrar;
    protected JButton cancelar;
    protected JTextField nombre;
    protected JTextField apPaterno;
    protected JTextField apMaterno;
    protected JTextField fechanacimiento;
    protected JTextField direccion;
    protected JTextField correo;
    protected JTextField sexo;
    protected JTextField fechaIngreso;
    protected JTextField sueldo;
   
    
    public AgregarVendedor() {
        super("Agregar Vendedor");
        this.setSize(510, 470);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        addComponentes();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        this.setVisible(true);
    }
    
    protected final void addComponentes() {
        JPanel panelSur = new JPanel();
        JPanel panelCentro = new JPanel();
        GridLayout gl2 = new GridLayout(12, 2);
        
        panelCentro.setLayout(gl2);
        panelCentro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 15));
        cancelar = new JButton("Cancelar");
        registrar = new JButton("Registrar");
        
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
        
        
        panelCentro.add(new JLabel("Nombre:"));
        panelCentro.add(nombre);
        panelCentro.add(new JLabel("Apellido paterno:"));
        panelCentro.add(apPaterno);
        panelCentro.add(new JLabel("Apellido materno:"));
        panelCentro.add(apMaterno);
        panelCentro.add(new JLabel("Fecha de nacimiento: YYYY/MM/dd"));
        panelCentro.add(fechanacimiento);
        panelCentro.add(new JLabel("E-mail: "));
        panelCentro.add(correo);
        panelCentro.add(new JLabel("Dirección: "));
        panelCentro.add(direccion);
        panelCentro.add(new JLabel("Sexo:   M/F"));
        panelCentro.add(sexo);
        panelCentro.add(new JLabel("Sueldo: "));
        panelCentro.add(sueldo);
        
        
        
        panelSur.add(cancelar);
        panelSur.add(registrar);
        
        this.add(panelSur,"South");
        this.add(panelCentro, "Center");
        
    }
    
    public void addEventos(OyenteAgregarVendedor o){
        registrar.addActionListener(o);
        cancelar.addActionListener(o);
        sexo.addKeyListener(o);
        sueldo.addKeyListener(o);
       
    }
   
    public JButton getRegistrar() {
        return registrar;
    }

    public void setRegistrar(JButton registrar) {
        this.registrar = registrar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
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

   
    
    
    
    
}
