/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class OyenteBuscarVendedor implements ActionListener, WindowListener, KeyListener{
    private BuscarVendedor busqueda;
    private Conexion usuario;
    private VentanaEmergente ventana;
    private Vector datos = new Vector <>();
    private String fecha1, fecha2;
    
    public OyenteBuscarVendedor(BuscarVendedor busqueda) {
        this.busqueda = busqueda;
        this.usuario = busqueda.getConexion();
    }

    OyenteBuscarVendedor() {
        actionPerformed(new ActionEvent(new JMenuItem(), 1, "Buscar"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Buscar")){
//            System.out.println("Buscando");
            JPanel p2 = new JPanel();
            p2.setLayout(new BorderLayout());
            p2.setBorder(BorderFactory.createLineBorder(p2.getBackground(), 10));
//            String busca = busqueda.getIds().get(busqueda.getVendedores().getSelectedIndex()).toString();
//            
//            fecha1 = busqueda.getAnio2().getSelectedItem() + "-" + busqueda.getMes2().getSelectedItem() + "-" + 
//                    busqueda.getDia2().getSelectedItem();
//            fecha2 = busqueda.getAnio().getSelectedItem() + "-" + busqueda.getMes().getSelectedItem() + "-" + 
//                    busqueda.getDia().getSelectedItem();
            try {
                busqueda.getConexion().iniciarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteBuscarVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            String consulta = "select * from vendedores_mas_ventas";
            
                try {
//                   
                    busqueda.getConexion().setResult(busqueda.getConexion().getStament().executeQuery(consulta));
                    while (busqueda.getConexion().getResult().next()) {
//                        System.out.println("buscando resultado");
                        for (int i = 0; i < busqueda.getConexion().getResult().getMetaData().getColumnCount(); i++) {
//                            System.out.println((busqueda.getConexion().getResult().getString(i + 1)));
                            datos.add(busqueda.getConexion().getResult().getString(i + 1));
                        }
            
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(ventana, "Vaya! Ocurrió un error \n" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            try {
                busqueda.getConexion().cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(OyenteBuscarVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JPanel norte = new JPanel();
            norte.setLayout(new GridLayout(5, 1));
            norte.setPreferredSize(new Dimension(p2.getWidth(), 80));
            norte.add(new JLabel ("ID: "+datos.get(0).toString()));
            norte.add(new JLabel ("Nombre: "+datos.get(1).toString()));
            norte.add(new JLabel ("Apellido paterno: "+datos.get(2).toString()));
            norte.add(new JLabel ("Apellido materno: "+datos.get(3).toString()));
            norte.add(new JLabel ("Ventas durante el período de " + fecha1 + " al " + fecha2));
           
            p2.add(norte, "North");
            
            PanelVendedores p1 = null;
            
            busqueda.dispose();
            ventana = new VentanaEmergente("Ventas por vendedor");
            ventana.add(p1);
            ventana.addWindowListener(this);
            ventana.setSize(750, 500);
            ventana.setLocationRelativeTo(null);
//            ventana.pack();
            ventana.setVisible(true);
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource().getClass().isInstance(busqueda)){
//            if(JOptionPane.showConfirmDialog(null, "Desea no buscar nada?", "Confirmar", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION)
                busqueda.dispose();
        }else if(e.getSource().getClass().isInstance(ventana)){
            ventana.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Buscando");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private JTable vVendedor(String busca) throws SQLException{
        // Indicamos que las celdas de la tabla no serán editables...
        DefaultTableModel modeloTabla = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable tablaVendedor = new JTable();
        String query;
        //depende del id, hara la consulta
        
            query = "select Cab_fact.idCab_fact, "
                    + "Detalle_fact.idDetalle_fact, "
                    + "Cliente.idCliente, "
                    + "Producto.nombreProducto, "
                    + "Producto.precio, "
                    + "Detalle_fact.cantidadProducto, "
                    + "Producto.precio * Detalle_fact.cantidadProducto as Importe, "
                    + "Detalle_fact.fechaVenta " + 
                    
            "from Detalle_fact, Producto, Cab_fact, Cliente " +
                    
            "where Producto.idProducto = Detalle_fact.Producto_idProducto and " +
            "Cliente.idCliente = Cab_fact.Cliente_idCliente and " +
            "Cab_fact.idCab_fact = Detalle_fact.Cab_fact_idCab_fact and " +
            "Cab_fact.Vendedor_idVendedor = "+busca+
            " and Detalle_fact.fechaVenta between '" + fecha1 + "' and '" + fecha2 + "';";
            
       
        try {
            usuario.iniciarConexion();
            usuario.setResult(usuario.getStament().executeQuery(query));
                String columnas [] = new String [usuario.getResult().getMetaData().getColumnCount()];
                for (int i = 0; i < usuario.getResult().getMetaData().getColumnCount(); i++) {
                    columnas[i] = usuario.getResult().getMetaData().getColumnName(i + 1);
                    
                }

                modeloTabla.setColumnIdentifiers(columnas);
                
                
                String fila[] = new String[usuario.getResult().getMetaData().getColumnCount()];

                while (usuario.getResult().next()) {
                    for (int i = 0; i < usuario.getResult().getMetaData().getColumnCount(); i++) {
                        fila[i] = usuario.getResult().getString(i + 1);
                        
                    }

                    modeloTabla.addRow(fila);
                }
//            // Bucle para cada resultado en la consulta
           
            tablaVendedor.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            tablaVendedor.setFillsViewportHeight(true);
            tablaVendedor.setModel(modeloTabla);
          
            
            usuario.getStament().close();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        } finally {
            usuario.cerrarConexion();
        }

        return tablaVendedor;

        
    }
    
}
