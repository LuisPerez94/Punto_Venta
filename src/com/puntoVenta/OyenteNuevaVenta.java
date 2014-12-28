package com.puntoVenta;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Fernando2
 * Created on Dec 26, 2014, 6:46:16 PM
 */

public class OyenteNuevaVenta extends KeyAdapter implements ActionListener, MouseListener{
    private final PanelNuevaVenta panel;
    private final ArrayList<ProductoNuevaVenta> listaProductos;
    
    public OyenteNuevaVenta(PanelNuevaVenta panel){
        this.panel = panel;
        this.listaProductos = panel.getListaProductos();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String etiqueta = e.getActionCommand();
        
        switch(etiqueta){
            case "Buscar":
                buscarProducto();
                break;
                
            case "Pagar":
                habilitarPago();
                break;
                
            case "Nueva":
                nuevaPartida();
                break;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        JTextField aux = new JTextField();
        boolean esProducto = false;
        
        try{
            aux = (JTextField) e.getSource();
            
        }catch(ClassCastException ex){
            esProducto = true;
        }
        
        if(!esProducto){
            DecimalFormat dc = new DecimalFormat("####.##");

            // El campo de buscar...
            if(aux.equals(panel.getTextBuscar())){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    buscarProducto();
                }

            // El campo de pago...
            }else if(aux.equals(panel.getTextPago())){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    try{
                        aux.setText("$ " + dc.format(Double.parseDouble(aux.getText().replace("$","").trim())));
                        realizarPago();

                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(panel, "La cantidad ingresada no es válida", "Advertencia",
                                JOptionPane.OK_OPTION);
                    }
                }
            }
            
        // Un producto del ticket...
        }else{
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                borrarProducto();
            
            }else if(e.getKeyCode() == KeyEvent.VK_SHIFT){
                disminuirCantidad();
            }
        }
    }
    
    // Hacemos que en el campo de pago sólo se puedan meter números y el punto...
    @Override
    public void keyTyped(KeyEvent e){
        try{
            JTextField aux = (JTextField) e.getSource();

            if(aux.equals(panel.getTextPago()) && aux.isEnabled()){
                if(!((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == '.')){
                    e.consume();
                }
            }
        }catch(ClassCastException ex){}
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Si se hizo clic en el campo de buscar, borramos el texto por default...
        if(e.getSource().equals(panel.getTextBuscar())){
            if(panel.getTextBuscar().getText().equals("Buscar producto...")){
                panel.getTextBuscar().setText("");
            }
            
        // Lo mismo para el de pago...
        }else if(e.getSource().equals(panel.getTextPago())){
            if(panel.getTextPago().isEnabled()){
                if(panel.getTextPago().getText().equals("$ 0.00")){
                    panel.getTextPago().setText("");
                }
            }
            
        // Si no fue ninguno de los dos, entonces fue sobre un producto...
        }else{
            agregarAlTicket(e);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try{
            ProductoNuevaVenta aux = (ProductoNuevaVenta) e.getSource();
            aux.hover();
        }catch(Exception ex){}
    }

    @Override
    public void mouseExited(MouseEvent e) {
        try{
            ProductoNuevaVenta aux = (ProductoNuevaVenta) e.getSource();
            aux.out();
        }catch(Exception ex){}
    }
    
    public void buscarProducto(){
        String buscar = panel.getTextBuscar().getText();
        
        if(buscar.equals("")){
            panel.getPanelProductos().removeAll();
            
            for(ProductoNuevaVenta pnv: listaProductos){
                panel.getPanelProductos().add(pnv);
            }
            
        
        }else{
            //Buscamos...
            ArrayList<ProductoNuevaVenta> aux = new ArrayList<>();
            
            for(ProductoNuevaVenta pnv: listaProductos){
                if(buscar.equals(pnv.getId().getText()) ||
                        pnv.getNombre().getText().toLowerCase().contains(buscar.toLowerCase())){

                    aux.add(pnv);
                }
            }
            
            if(!aux.isEmpty()){
                panel.getPanelProductos().removeAll();
                
                for(ProductoNuevaVenta pnv: aux){
                    panel.getPanelProductos().add(pnv);
                }
            
            }else{
                JOptionPane.showMessageDialog(panel, "No se encontraron coincidencias",
                        "Lo sentimos", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        panel.getPanelProductos().updateUI();
    }
    
    public void nuevaPartida(){
        int opcion = JOptionPane.showConfirmDialog(panel, "¿Desea agregar una nueva partida? \nSe perderá la venta actual",
                                                    "Confirmación", JOptionPane.OK_CANCEL_OPTION);
        
        if(opcion == JOptionPane.OK_OPTION){
            borrarCampos();
        }
    }
    
    public void borrarCampos(){
            // Habilitar el botón de pago...
            panel.getButtonPagar().setEnabled(true);
        
            // Deshabilitar campos...
            panel.getTextPago().setEnabled(false);
            panel.getTextCambio().setEnabled(false);
            
            // Poner a cero los campos...
            panel.getTextPago().setText("$ 0.00");
            panel.getTextCambio().setText("$ 0.00");
            panel.getTextTotal().setText("$ 0.00");
            
            // Vaciar el ticket...
            DefaultTableModel modelo = (DefaultTableModel) panel.getTicket().getModel();
            try{
                // La vaciamos a la mala hasta que bote una excepción 
                // Porque si no, las filas que tengan una cantidad de producto > 1
                // solo les resta 1, pero siguen ahí... #YOLOSwag #AdictosAlHermoso
                while(true){
                    modelo.removeRow(0);
                }
                
            }catch(Exception e){}
            
            // Regresar el texto al botón de buscar...
            panel.getTextBuscar().setText("");
            buscarProducto();
            panel.getTextBuscar().setText("Buscar producto...");
    }
    
    public void habilitarPago(){
        if(!panel.getTextTotal().getText().equals("$ 0.00")){
            int opcion = JOptionPane.showConfirmDialog(panel, "¿Desea realizar el pago?",
                    "Habilitar pago", JOptionPane.OK_CANCEL_OPTION);

            if(opcion == JOptionPane.OK_OPTION){
                panel.getTextPago().setEnabled(true);
                panel.getTextCambio().setEnabled(true);
                panel.getButtonPagar().setEnabled(false);
                
                // Le damos el foco al JTextField de pago y lo borramos...
                panel.getTextPago().requestFocus();
                panel.getTextPago().setText("");
            }
            
        }else{
            JOptionPane.showMessageDialog(panel, "No ha seleccionado ningún producto",
                                            "Advertencia", JOptionPane.OK_OPTION);
        }
    }
    
    public void realizarPago(){
        DecimalFormat dc = new DecimalFormat("####.##");
        double pago = Double.parseDouble(panel.getTextPago().getText().replace("$", "").trim());
        double total = Double.parseDouble(panel.getTextTotal().getText().replace("$", "").trim());
        double cambio = pago - total;
        
        if(cambio >= 0){

            panel.getTextCambio().setText("$ " + dc.format(cambio));

            int opcion = JOptionPane.showConfirmDialog(panel, 
                            "\nEl total a pagar es de: "+panel.getTextTotal().getText()+
                            "\n\nSe paga con: "+panel.getTextPago().getText() +
                            "\n\nSu cambio es de: $ "+dc.format(cambio)+
                            "\n\n¿Son correctos los datos?\n",
                            "Relizar pago", JOptionPane.OK_CANCEL_OPTION);
            

            if(opcion == JOptionPane.OK_OPTION){
                JOptionPane.showMessageDialog(panel, "\nCompra realizada con éxito \n\nGracias por su preferencia\n",
                        "Compra realizada", JOptionPane.INFORMATION_MESSAGE);

                
                
                // Y aumentamos el número de la nueva partida...
                panel.getTextPartida().setText(Integer.parseInt(panel.getTextPartida().getText())+1+"");
                
                // Y lo guardamos en la base de datos...
                JTable ticket = panel.getTicket();
                guardarVenta(ticket);
                
                // Por último borramos los campos...
                borrarCampos();
            
            }else{
                panel.getTextCambio().setText("$ 0.00");
                panel.getTextPago().setText("");
                
                panel.getTextPago().requestFocus();
            }
            
        }else{
            JOptionPane.showMessageDialog(panel, "La cantidad ingresada no es válida",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void agregarAlTicket(MouseEvent e){
        ProductoNuevaVenta aux = (ProductoNuevaVenta)e.getSource();
        DefaultTableModel modelo = (DefaultTableModel) panel.getTicket().getModel();
        boolean enTicket = false;
        int indice = 0;
        DecimalFormat dc = new DecimalFormat("####.##");
        double totalCompra;
        
        // Comprobamos que el producto seleccionado no esté dentro del ticket...
        for(int i = 0; i < modelo.getRowCount(); i++){
            String idProducto = modelo.getValueAt(i, 0)+"";
            
            if(idProducto.equals(aux.getId().getText())){
                enTicket = true;
                indice = i;
                break;
            }
        }
        
        // Si no está en el ticket, lo agregamos...
        if(!enTicket){
            modelo.addRow(new Object[]{
                            aux.getId().getText(),
                            aux.getDescripcion(),
                            dc.format(aux.getPrecio()),
                            1,
                            dc.format(aux.getPrecio())
                         });
            
        // Si no, tomamos el producto que ya existe y aumentamos la cantidad
        // y el importe...
        }else{
            // Aumentamos la cantidad....
            modelo.setValueAt(Integer.parseInt(modelo.getValueAt(indice,3)+"")+1, 
                                indice, 
                                3);
            
            // Aumentamos el importe...
            modelo.setValueAt(dc.format(Double.parseDouble(modelo.getValueAt(indice, 4)+"")+aux.getPrecio()),
                                indice,
                                4);
        }

        // Se aumenta el total a pagar...
        totalCompra = Double.parseDouble(panel.getTextTotal().getText().replace("$","").trim());
        totalCompra += aux.getPrecio();
        
        panel.getTextTotal().setText("$ " + dc.format(totalCompra));
    }
    
    public void borrarProducto(){
        int opcion = JOptionPane.showConfirmDialog(panel, "¿Seguro que desea eliminar este producto de la compra?",
                                                    "Confirmación", JOptionPane.OK_CANCEL_OPTION);
        
        if(opcion == JOptionPane.OK_OPTION){
            double importe = Double.parseDouble(panel.getTicket().getModel().getValueAt(
                                                    panel.getTicket().getSelectedRow(), 4)+"");
            
            DefaultTableModel modelo = (DefaultTableModel) panel.getTicket().getModel();
            modelo.removeRow(panel.getTicket().getSelectedRow());
            
            decrementarTotal(importe);
        }
    }
    
    public void disminuirCantidad(){
        int cantidad = Integer.parseInt(panel.getTicket().getModel().getValueAt(panel.getTicket().getSelectedRow(), 3)+"");
        double precio = Double.parseDouble(panel.getTicket().getModel().getValueAt(panel.getTicket().getSelectedRow(), 2)+"");
        DecimalFormat dc = new DecimalFormat("####.##");

        if(cantidad == 1){
            borrarProducto();
            
        }else{
            // Se decrementa la cantidad...
            panel.getTicket().getModel().setValueAt(cantidad-1, 
                                                    panel.getTicket().getSelectedRow(),
                                                    3);
            
            // Se decrementa el importe...
            panel.getTicket().getModel().setValueAt(dc.format(precio*(cantidad-1)),
                                                    panel.getTicket().getSelectedRow(),
                                                    4);
            
            decrementarTotal(precio);
        }
    }
    
    public void decrementarTotal(double cantidad){
        DecimalFormat dc = new DecimalFormat("####.##");

        // Se decrementa el total a pagar...
        double nuevoTotal = Double.parseDouble(panel.getTextTotal().getText().replace("$","").trim()) - cantidad;

        if(nuevoTotal != 0.0){
            panel.getTextTotal().setText("$ " + dc.format(nuevoTotal));
        
        }else{
            panel.getTextTotal().setText("$ 0.00");
        }
    }
    
    public void guardarVenta(JTable ticket){
        Conexion conexion = panel.getConexion();
        String selectIdVendedor = "SELECT idVendedor FROM Vendedor WHERE nombreVendedor = " +
                "'" + panel.getTextAtiende().getText().trim() + "'";
        
        String insertarEnCab_fact, insertarEnDetalle_fact;
        int idVendedor;
        
        int idCab_fact = (Integer.parseInt(panel.getTextPartida().getText().trim())-1);
        int idDetalle_fact = 0;
        
        String fechaVenta = "";
        
        
        try{
            conexion.iniciarConexion();
            
            // Obtenemos el id del vendedor que está atendiendo...
            conexion.setResult(conexion.getStament().executeQuery(selectIdVendedor));

//            System.out.println("Aún no se ha ejecutado...");
//            System.out.println(selectIdVendedor);
            
            // Insertamos en Cab_fact...
            if(conexion.getResult().next()){
                idVendedor = Integer.parseInt(conexion.getResult().getObject(1) + "");
                
//                System.out.println("Tienes el ID: " + idVendedor);

                insertarEnCab_fact = "INSERT INTO Cab_fact VALUES(" + 
                                        idCab_fact + "," +
                                        1 + "," +
                                        idVendedor+
                                        ")";
                
//                System.out.println("Consulta: " + insertarEnCab_fact);
                
                conexion.getStament().execute(insertarEnCab_fact);
                
//                System.out.println("Se insertó en cab_fact!");
            }
            
            // Luego los detalles en Detalle_fact...
            conexion.setResult(conexion.getStament().executeQuery("SELECT MAX(idDetalle_fact) from Detalle_fact"));
            if(conexion.getResult().next()){
                idDetalle_fact = Integer.parseInt(conexion.getResult().getObject(1)  + "");
                // Agregamos uno porque va a ser el id siguiente...
                idDetalle_fact ++;
            }
            
            conexion.setResult(conexion.getStament().executeQuery("SELECT CURDATE()"));
            if(conexion.getResult().next()){
                fechaVenta = conexion.getResult().getObject(1) + "";
            }
            
//            System.out.println("FECHA: " + fechaVenta);
            
            // Insertamos ahora sí...
            for(int i = 0; i < ticket.getRowCount(); i++){
                insertarEnDetalle_fact = "INSERT INTO Detalle_fact VALUES(" +
                                                idDetalle_fact + "," +
                                                idCab_fact + "," +
                                                Integer.parseInt(ticket.getValueAt(i, 0)+"") + "," +
                                                "'"+fechaVenta+"'" + "," +
                                                Integer.parseInt(ticket.getValueAt(i,3)+"") +
                                                ")";
//                System.out.println("Consula: " + insertarEnDetalle_fact);
                
                conexion.getStament().execute(insertarEnDetalle_fact);
                idDetalle_fact ++;
            }
            
//            System.out.println("Se agregó en Detalle_fact!");
                conexion.getStament().close();
        }catch(SQLException e){
            System.out.println("Hubo un error al guardar la venta: " + e.getMessage());
            
        }finally{
            conexion.cerrarConexion();
        }
    }
}
