package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.IllegalComponentStateException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;



public class AreaConsulta extends JFrame { 
    private final OyenteAreaConsulta oyente = new OyenteAreaConsulta(this);
    public Conexion usuario;
    private JButton run;
    private ArrayList<TablaConsulta> consultas;
   
    private JTextArea taConsulta;
    private JPanel content;
    
    public AreaConsulta() {
        this.setTitle("Conexión con usuario :  " + "administrador" + "   en   " + "jdbc:punto_venta://localhost:3306:");
        this.setSize(800, 480);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addComponentes();
        this.usuario = new Conexion("administrador", "123pass", "3306", "localhost");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        this.setVisible(true);
        consultas = new ArrayList<>();
    }

    /**
     * Agrega los componentes a esta ventana
     *
     * @param void
     */
    private void addComponentes() {
        run = new JButton("Ejecutar");

        JPanel pNorte = new JPanel();
        JPanel pSur = new JPanel();
        pSur.setLayout(new BorderLayout());
        JPanel pOeste = new JPanel();
        pOeste.setPreferredSize(new Dimension(48, 385));
  
        taConsulta = new JTextArea();
        taConsulta.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
        JScrollPane despConsulta = new JScrollPane(taConsulta);
        despConsulta.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        despConsulta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel pSubSur = new JPanel();
        JPanel pSubSur2 = new JPanel();

//        pSubSur.add(reload);
        pSubSur2.add(run);

        pSur.add(pSubSur, "West");
        pSur.add(pSubSur2, "Center");

        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        
        content.add(pNorte, "North");
        content.add(despConsulta, "Center");
        content.add(pSur, "South");
        
        
        this.add(content);
        addEventos();
    }

    /**
     * agrega los eventos a los elementos de esta ventana que los necesiten
     *
     * @param void
     */
    public void addEventos() {
        run.addActionListener(oyente);

        this.addWindowListener(oyente);
    }

    public JTextArea getTaConsulta() {
        return taConsulta;
    }

    public void setTaConsulta(JTextArea taConsulta) {
        this.taConsulta = taConsulta;
    }

   void ejecutarConsulta() throws IllegalComponentStateException, SQLException {
        usuario.iniciarConexion();
        String query = getTaConsulta().getText();
        String queries[];
        String consulta;

        boolean use = false;

        if ("".equals(query)) {
            JOptionPane.showMessageDialog(null, "Área de consulta vacía", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
           
            if (query.toUpperCase().trim().startsWith("USE")) {
                use = true;
            }

            try {

                if (use) {
                    queries = query.trim().split(";");
                    usuario.getStament().executeQuery(queries[0]);

                    consulta = queries[1];
                } else {
                    consulta = query.trim();
                }

                // Tipo 0 = Actualización
                // Tipo 1 = Selección
                int tipoCons;

                if (usuario.getStament().execute(consulta)) {
                    tipoCons = 1;
                } else {
                    tipoCons = 0;
                    
                }

//                System.out.println("Tipo cons " + tipoCons);
                if (tipoCons == 0) {
                    JOptionPane.showMessageDialog(null, "Consulta realizada con exito", "Exito", JOptionPane.CLOSED_OPTION);
                }
//                        tc = new TablaConsulta(con.getStament(), queries[1], consultas.getOperacion().getSelectedIndex());
                TablaConsulta tc = new TablaConsulta(usuario.getStament(), consulta, tipoCons);
                consultas.add(tc);
                usuario.cerrarConexion();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la instrucción SQL", JOptionPane.ERROR_MESSAGE);
            } catch (IndexOutOfBoundsException ie) {
                JOptionPane.showMessageDialog(null, "No se seleccionó base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public ArrayList<TablaConsulta> getConsultas() {
        return consultas;
    }

}

class OyenteAreaConsulta implements WindowListener, ActionListener{
    AreaConsulta a;
    public OyenteAreaConsulta(AreaConsulta a) {
        this.a = a;
    }

    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getSource().getClass().isInstance(a)){
            for(TablaConsulta tc: a.getConsultas()){
                tc.dispose();
            }
            a.dispose();
        }
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Ejecutar")){
            try {
                //            System.out.println(a.usuario);
//            System.out.println("Ejecutando consulta");
                a.ejecutarConsulta();
            } catch (IllegalComponentStateException ex) {
                Logger.getLogger(OyenteAreaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteAreaConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
 
    
}