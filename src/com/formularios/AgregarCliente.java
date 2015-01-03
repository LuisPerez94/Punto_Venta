/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.formularios;

import com.oyentes.OyenteAgregarCliente;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 *
 * @author luis
 */
public class AgregarCliente extends JFrame {

    private JButton registrar;
    private JButton cancelar;
    private JTextField tNombre;
    private JTextField tAptPaterno;
    private JTextField tAptMaterno;
    private JTextField tDireccion;
    private JTextField tCorreo;
    private JTextField tTelefono;
    private JTextField tSexo;

    public AgregarCliente() {
        super("Agregar un Cliente");
        this.setSize(320, 320);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        addComponentes();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        this.setVisible(true);
    }

    private void addComponentes() {
        JPanel panelCentro = new JPanel();
        JPanel panelSur = new JPanel();
        GridLayout gbCentro = new GridLayout(7, 2);
        panelCentro.setLayout(gbCentro);
        panelCentro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 20));

        cancelar = new JButton("Cancelar");
        registrar = new JButton("Registrar");
        tAptMaterno = new JTextField();
        tAptPaterno = new JTextField();
        tCorreo = new JTextField();
        tDireccion = new JTextField();
        tNombre = new JTextField();
        tSexo = new JTextField();
        tSexo.setName("sexo");
        tTelefono = new JTextField();
        tTelefono.setName("telefono");

        
        panelCentro.add(new JLabel("Nombre(s) :"));
        panelCentro.add(tNombre);
        panelCentro.add(new JLabel("Apellido Paterno :"));
        panelCentro.add(tAptPaterno);
        panelCentro.add(new JLabel("Apellido Materno :"));
        panelCentro.add(tAptMaterno);
        panelCentro.add(new JLabel("Dirección :"));
        panelCentro.add(tDireccion);
        panelCentro.add(new JLabel("Email :"));
        panelCentro.add(tCorreo);
        panelCentro.add(new JLabel("Telefono :"));
        panelCentro.add(tTelefono);
        panelCentro.add(new JLabel("Sexo :  (M,F)"));
        panelCentro.add(tSexo);

        panelSur.add(cancelar);
        panelSur.add(registrar);

//        PanelSur.setLayout(gb);


        this.add(panelSur, "South");
        this.add(panelCentro, "Center");

    }

    public void addEventos(OyenteAgregarCliente o) {
        cancelar.addActionListener(o);
        registrar.addActionListener(o);
        tTelefono.addKeyListener(o);
        tSexo.addKeyListener(o);

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

    public JTextField gettNombre() {
        return tNombre;
    }

    public void settNombre(JTextField tNombre) {
        this.tNombre = tNombre;
    }

    public JTextField gettAptPaterno() {
        return tAptPaterno;
    }

    public void settAptPaterno(JTextField tAptPaterno) {
        this.tAptPaterno = tAptPaterno;
    }

    public JTextField gettAptMaterno() {
        return tAptMaterno;
    }

    public void settAptMaterno(JTextField tAptMaterno) {
        this.tAptMaterno = tAptMaterno;
    }

    public JTextField gettDireccion() {
        return tDireccion;
    }

    public void settDireccion(JTextField tDireccion) {
        this.tDireccion = tDireccion;
    }

    public JTextField gettCorreo() {
        return tCorreo;
    }

    public void settCorreo(JTextField tCorreo) {
        this.tCorreo = tCorreo;
    }

    public JTextField gettTelefono() {
        return tTelefono;
    }

    public void settTelefono(JTextField tTelefono) {
        this.tTelefono = tTelefono;
    }

    public JTextField gettSexo() {
        return tSexo;
    }

    public void settSexo(JTextField tSexo) {
        this.tSexo = tSexo;
    }

}
