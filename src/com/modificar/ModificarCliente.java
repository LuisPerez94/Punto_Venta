/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modificar;

import com.puntoVenta.Cliente;
import com.puntoVenta.Conexion;

import java.awt.BorderLayout;
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author JR
 */
public class ModificarCliente extends JFrame{
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
    
    public ModificarCliente(Conexion c) {
        this.setTitle("Modificar Cliente");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.c = c;
        this.setSize(350, 370);
        this.setResizable(false);
        addComponentes();
        addEventos(new OyenteModificarCliente(c, this));
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setVisible(true);
        
    }
    
    protected void addComponentes(){
        c.iniciarConexion();
        String consulta = "select Cliente.idCliente, Cliente.nombreCliente, Cliente.apPaterno, Cliente.apMaterno from Cliente;";
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
        
        clientes = new JComboBox(ListToArray(v));
        
        JPanel panelSur = new JPanel();
        JPanel panelCentro = new JPanel();
        GridLayout gl2=new GridLayout(8, 2);
        panelCentro.setLayout(gl2);
        cancelar=new JButton("Cancelar");
        registrar=new JButton("Modificar");
        
        nombre = new JTextField();
        apPaterno = new JTextField();
        apMaterno = new JTextField();
        
        direccion = new JTextField();
        correo = new JTextField();
        correo.setName("correo");
        telefono = new JTextField();
        telefono.setName("Telefono");
        sexo = new JTextField();
        sexo.setName("sexo");
        
        panelCentro.add(new JLabel("Modificar a:"));
        panelCentro.add(clientes);
        panelCentro.add(new JLabel("Nombre: "));
        panelCentro.add(nombre);
        panelCentro.add(new JLabel("Apellido paterno: "));
        panelCentro.add(apPaterno);
        panelCentro.add(new JLabel("Apellido materno: "));
        panelCentro.add(apMaterno);
        
        panelCentro.add(new JLabel("E-mail: "));
        panelCentro.add(correo);
        panelCentro.add(new JLabel("Dirección: "));
        panelCentro.add(direccion);
        panelCentro.add(new JLabel("Teléfono: "));
        panelCentro.add(telefono);
        panelCentro.add(new JLabel("Sexo:   M/F"));
        panelCentro.add(sexo);

        panelCentro.setBorder(BorderFactory.createLineBorder(this.getBackground(), 15));
        
        panelSur.add(cancelar);
        panelSur.add(registrar);
        
        JPanel cont = new JPanel();
        cont.setLayout(new BorderLayout());
        cont.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        
        cont.add(panelSur,"South");
        cont.add(panelCentro, "Center");
        
        this.add(cont, "Center");
          agregarCampos(Integer.parseInt(ids.get(0).toString()));
    }

    private void addEventos(OyenteModificarCliente o) {
        cancelar.addActionListener(o);
        registrar.addActionListener(o);
        clientes.addItemListener(o);
        registrar.addActionListener(o);
        telefono.addKeyListener(o);
        sexo.addKeyListener(o);
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
    
    
    
    void agregarCampos (int ClienteActual){
        c.iniciarConexion();
            String consulta = "select * from Cliente where idCliente="+ClienteActual;
            System.out.println(consulta);
            try {
            c.setResult(c.getStament().executeQuery(consulta));
            while(c.getResult().next()){
                getCliente().setNombreCliente(c.getResult().getString(2));
                getCliente().setApPaterno(c.getResult().getString(3));
                getCliente().setApMaterno(c.getResult().getString(4));
                getCliente().setDireccionCliente(c.getResult().getString(5));
                getCliente().setCorreoCliente(c.getResult().getString(6));
                getCliente().setTelefono(Integer.parseInt(c.getResult().getString(7)));
                getCliente().setSexo(c.getResult().getString(8).charAt(0));
                System.out.println(c.getResult().getString(2));
                System.out.println(c.getResult().getString(3));
                System.out.println(c.getResult().getString(4));
                System.out.println(c.getResult().getString(5));
                System.out.println(c.getResult().getString(6));
                System.out.println(c.getResult().getString(7));
                System.out.println(c.getResult().getString(c.getResult().getString(8).charAt(0)));
                
                               
                               
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        c.cerrarConexion();
        
       
        String sexoString=""+getCliente().getSexo();
        String telefonoString = ""+getCliente().getTelefono();
        getNombre().setText(getCliente().getNombreCliente());
        getApPaterno().setText(getCliente().getApPaterno());
        getApMaterno().setText(getCliente().getApMaterno());
        getDireccion().setText(getCliente().getDireccionCliente());
        getCorreo().setText(getCliente().getCorreoCliente());
        getTelefono().setText(telefonoString);
        getSexo().setText(sexoString);
       
    }
    
    
    
}
