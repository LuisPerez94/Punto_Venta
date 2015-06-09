/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import static com.modificar.ModificarVendedor.ListToArray;
import com.puntoVenta.Cliente;
import com.puntoVenta.Conexion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JR
 */
public class EliminarCliente extends JFrame{
    Conexion c ;
    private JComboBox clientes;
    private JButton cancelar = new JButton("Cancelar");
    private JButton registrar = new JButton("Modificar");
    private JTextField nombre;
    private JTextField apPaterno;
    private JTextField apMaterno;
   
    private JTextField direccion;
    private JTextField correo;
    private JTextField telefono;
    private JTextField sexo;
    
    
    private ArrayList Atributos;
    private ArrayList ids = new ArrayList<>();
    private ArrayList v = new ArrayList <String []> ();
    private Cliente cliente = new Cliente();
    public EliminarCliente(Conexion c) throws SQLException {
        
        this.setTitle("Eliminar Cliente");
        this.setSize(320, 120);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setResizable(false);
        addComponentes();
        addEventos(new OyenteEliminarCliente(c, this));
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
    }
    
    
    public void addComponentes() throws SQLException{
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JPanel p = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        c.iniciarConexion();
        String consulta = "select Cliente.idCliente, Cliente.nombreCliente, Cliente.apPaterno, Cliente.apMaterno from Cliente;";
        try {
        c.setResult(c.getStament().executeQuery(consulta));
        while (c.getResult().next()) {
                    setAtributos(new ArrayList <String[]>()) ;
                    for (int i = 0; i < c.getResult().getMetaData().getColumnCount(); i++) {
                        getAtributos().add(c.getResult().getString(i + 1));
                        }
                    getIds().add(getAtributos().get(0).toString());
                    getV().add(getAtributos());
                    
            
        }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        c.cerrarConexion();
        setClientes(new JComboBox(ListToArray(getV())));
        getRegistrar().setText("Eliminar");
        
        p.add(getClientes());
        
        p2.add(getCancelar());
        p2.add(getRegistrar());
        
        panel.add(p, "North");
        panel.add(p2, "South");
        
        this.add(panel, "Center");
    }
    
    private void addEventos(OyenteEliminarCliente o) {
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

    public JComboBox getClientes() {
        return clientes;
    }

    public void setClientes(JComboBox clientes) {
        this.clientes = clientes;
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

    public JTextField getTelefono() {
        return telefono;
    }

    public void setTelefono(JTextField telefono) {
        this.telefono = telefono;
    }

    public JTextField getSexo() {
        return sexo;
    }

    public void setSexo(JTextField sexo) {
        this.sexo = sexo;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
