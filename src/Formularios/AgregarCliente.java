/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Oyentes.OyenteAgregarCliente;
import java.awt.GridLayout;
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
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        addComponentes();
        this.setVisible(true);
    }

    private void addComponentes() {

        JPanel PanelCentro = new JPanel();
        JPanel PanelSur = new JPanel();
        GridLayout gb = new GridLayout(1, 2);
        GridLayout gbCentro = new GridLayout(7, 2);
        JPanel panelIzqSur = new JPanel();
        JPanel panelDerSur = new JPanel();
        PanelCentro.setLayout(gbCentro);

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

        PanelCentro.add(new JLabel("Nombre(s) :"));
        PanelCentro.add(tNombre);
        PanelCentro.add(new JLabel("Apellido Paterno :"));
        PanelCentro.add(tAptPaterno);
        PanelCentro.add(new JLabel("Apellido Materno :"));
        PanelCentro.add(tAptMaterno);
        PanelCentro.add(new JLabel("Dirección :"));
        PanelCentro.add(tDireccion);
        PanelCentro.add(new JLabel("Email :"));
        PanelCentro.add(tCorreo);
        PanelCentro.add(new JLabel("Telefono :"));
        PanelCentro.add(tTelefono);
        PanelCentro.add(new JLabel("Sexo :  (M,F)"));
        PanelCentro.add(tSexo);

        panelIzqSur.add(registrar);
        panelDerSur.add(cancelar);

        PanelSur.setLayout(gb);

        PanelSur.add(panelIzqSur);
        PanelSur.add(panelDerSur);

        this.add(PanelSur, "South");
        this.add(PanelCentro, "Center");

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
