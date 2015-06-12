package com.puntoVenta;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Fernando2
 * Created on Dec 26, 2014, 6:46:16 PM
 */

public class OyenteNuevaVenta extends KeyAdapter implements ActionListener, MouseListener{
    private final VentanaEmergente ventana;
    private final PanelNuevaVenta panel;
    private final ArrayList<ProductoNuevaVenta> listaProductos;
    private Conexion c ;
    
    public OyenteNuevaVenta(VentanaEmergente ventana, PanelNuevaVenta panel){
        this.ventana = ventana;
        this.panel = panel;
        this.listaProductos = panel.getListaProductos();
        c = panel.getConexion();
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
        {
            try {
                nuevaPartida(true);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteNuevaVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
                    } catch (SQLException ex) {
                        Logger.getLogger(OyenteNuevaVenta.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                agregarAlTicket(e);
            } catch (SQLException ex) {
                Logger.getLogger(OyenteNuevaVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public void nuevaPartida(boolean validar) throws SQLException{
        
        if(validar){
            int opcion = JOptionPane.showConfirmDialog(panel, "¿Desea agregar una nueva partida? \nSe perderá la venta actual",
                                                        "Confirmación", JOptionPane.OK_CANCEL_OPTION);

            if(opcion == JOptionPane.OK_OPTION){
                if(borrarCampos()){
                    ventana.setVisible(false);
                    panel.update(panel.getGraphics());
                    validarNuevaVenta();
                }
            }
        
        }else{
            if(borrarCampos()){
                    ventana.setVisible(false);
                    panel.update(panel.getGraphics());
                    validarNuevaVenta();
                }
        }
    }
    
    public boolean borrarCampos(){
            // Habilitar el botón de pago...
            panel.getButtonPagar().setEnabled(true);
        
            // Deshabilitar campos...
            panel.getTextPago().setEnabled(false);
            panel.getTextCambio().setEnabled(false);
            
            // Poner a cero los campos...
            panel.getTextPago().setText("$ 0.00");
            panel.getTextCambio().setText("$ 0.00");
            panel.getTextTotal().setText("$ 0.00");
            
            panel.getTextCliente().setText(" ");
            
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
            
            return true;
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
    
    public void realizarPago() throws SQLException{
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
                guardarVenta();
            
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
    
   public boolean agregarAlTicket(MouseEvent e) throws SQLException{
        ProductoNuevaVenta aux = (ProductoNuevaVenta)e.getSource();
        DefaultTableModel modelo = (DefaultTableModel) panel.getTicket().getModel();
        int id , existencia=0;
        boolean enTicket = false;
        int indice = 0;
        DecimalFormat dc = new DecimalFormat("####.##");
        double totalCompra;
        
        
        c.iniciarConexion();
        
        id = Integer.parseInt(aux.getId().getText().trim());
       System.out.println(id);
        
        try {
            c.setResult(c.getStament().executeQuery("select existencia\n" +
                    "from Luis.Producto\n" +
                    "where idProducto="+id));
            while(c.getResult().next()){
                existencia = Integer.parseInt(c.getResult().getString(1));
                System.out.println("Existencias: "+existencia);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(panel, "Error en la consulta",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        c.cerrarConexion();
        
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
            if(existencia==0){
                JOptionPane.showMessageDialog(panel, "No hay suficientes existencias",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
                return false;
            }
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
            int productoComprado = Integer.parseInt(modelo.getValueAt(indice,3).toString());
            if(existencia<=productoComprado){
                JOptionPane.showMessageDialog(panel, "No hay suficientes existencias",
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            modelo.setValueAt(Integer.parseInt(modelo.getValueAt(indice,3).toString())+1, 
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
        return true;
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
    
    public void guardarVenta() throws SQLException{
        Conexion conexion = panel.getConexion();
        JTable ticket = panel.getTicket();
        System.out.println(panel.getTextAtiende().getText().trim());
        String selectIdVendedor = "SELECT idVendedor FROM Luis.Vendedor WHERE nomVendedor = 'Luis'";
        
        String insertarEnCab_fact, insertarEnDetalle_fact;
        int idVendedor;
        
        // Este es el idCab_fact, es 1 mayor que el mayor que hay en la bd...
        int idCab_fact = (Integer.parseInt(panel.getTextPartida().getText().trim()));
        int idDetalle_fact = 0;
        
        String fechaVenta = "";

        // El [1] es el que contiene el ID...
        String[] datosCliente = panel.getTextCliente().getText().split(" ");
                
                
        try{
            conexion.iniciarConexion();
            
            // Obtenemos el id del vendedor que está atendiendo...
            conexion.setResult(conexion.getStament().executeQuery(selectIdVendedor));

            
            // Insertamos en Cab_fact...
            if(conexion.getResult().next()){
                System.out.println(conexion.getResult().getObject(1) + "");
                idVendedor = Integer.parseInt((conexion.getResult().getObject(1) + "").trim());
                
//                System.out.println("Tienes el ID: " + idVendedor);

                insertarEnCab_fact = "INSERT INTO Luis.Cabfactura VALUES(" + 
                                        idCab_fact + "," +
                                        datosCliente[1] + "," +
                                        idVendedor+
                                        ")";
                
//                System.out.println("Consulta: " + insertarEnCab_fact);
                
                conexion.getStament().execute(insertarEnCab_fact);
                
//                System.out.println("Se insertó en cab_fact!");
            }
            
            // Luego los detalles en Detalle_fact...
            conexion.setResult(conexion.getStament().executeQuery("SELECT MAX(to_number(idDetallefact)) from Luis.Detallefactura"));
            if(conexion.getResult().next()){
                idDetalle_fact = Integer.parseInt((conexion.getResult().getObject(1)  + "").trim());
                // Agregamos uno porque va a ser el id siguiente...
                idDetalle_fact ++;
            }
            
            
            System.out.println("FECHA: " + fechaVenta);
            
            // Insertamos ahora sí...
            for(int i = 0; i < ticket.getRowCount(); i++){
                insertarEnDetalle_fact = "INSERT INTO Luis.Detallefactura VALUES(" +
                                                idDetalle_fact + "," +
                                                idCab_fact + "," +
                                                Integer.parseInt((ticket.getValueAt(i, 0)+"").trim()) + "," 
                                                + Integer.parseInt((ticket.getValueAt(i,3)+"").trim()) + "," +
                                                "to_date(sysdate)" +
                                                ")";
                System.out.println("Consulta: " + insertarEnDetalle_fact);
                
                conexion.getStament().execute(insertarEnDetalle_fact);
                idDetalle_fact ++;
            }
            
            JOptionPane.showMessageDialog(panel, "\nCompra realizada con éxito \n\nGracias por su preferencia\n",
                    "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
                        /*Se crea una conexion para evitar darle permisos no necesarios a vendedor, ya que no puede modificar 
            en producto*/
          
            
            for (int i = 0; i < ticket.getRowCount(); i++) {
               
                int existencia=0;
                try {
                    c.setResult(c.getStament().executeQuery("select Producto.existencia\n" +
                            "from Luis.Producto\n" +
                            "where idProducto="+(ticket.getValueAt(i, 0))));
                    System.out.println("select Producto.existencia\n" +
                            "from Producto\n" +
                            "where idProducto="+ticket.getValueAt(i, 0));
                    while(c.getResult().next()){
                        existencia = Integer.parseInt(c.getResult().getString(1));
                        System.out.println("Existencias: "+existencia);
                    }
            
            
                } catch (SQLException ex) {
                            System.out.println(ex);
                }

                int quitar = Integer.parseInt(ticket.getValueAt(i,3).toString());
                System.out.println("UPDATE Luis.Producto SET existencia="+(existencia-quitar)+" WHERE idProducto="+ticket.getValueAt(i, 0).toString().trim());
                conexion.getStament().execute("UPDATE Luis.Producto SET existencia="+(existencia-quitar)+" WHERE idProducto="+ticket.getValueAt(i, 0).toString().trim());
                

            }
       



            
            // Y aumentamos el número de la nueva partida...
            panel.getTextPartida().setText(Integer.parseInt(panel.getTextPartida().getText())+1+"");
            
            // Por último borramos los campos...
            borrarCampos();
                
            conexion.getStament().close();
            
            nuevaPartida(false);
        }catch(SQLException e){
            System.out.println("Hubo un error al guardar la venta: " + e.getMessage());
            
        }finally{
            conexion.cerrarConexion();
        }
    }
    
    
    public void validarNuevaVenta() throws SQLException{
        String datosCliente = JOptionPane.showInputDialog(panel, "Identificar cliente: ", "ID ");
        String cliente, buscar, query;

        try{
            if(!datosCliente.equals("")){
                try{
                    int id = Integer.parseInt(datosCliente);
                    buscar = "idCliente";
                }catch(NumberFormatException e){
                    buscar = "correoCliente";
                }

                query = "SELECT * FROM Luis.Cliente WHERE  Cliente." + buscar + " = " +datosCliente;
//                System.out.println("Query: " + query);
                cliente = buscarCliente(query);

//                System.out.println("Cliente encontrado: " + cliente);

                if(!cliente.equals("-1")){
                    int opcion = JOptionPane.showConfirmDialog(panel, 
                            "Cliente: \n" + cliente +"\n\n¿Son correctos los datos?",
                            "Cliente encontrado", JOptionPane.OK_CANCEL_OPTION);

                    if(opcion == JOptionPane.OK_OPTION){
                        ventana.setVisible(true);
                    }else{
                        validarNuevaVenta();
                    }
                
                }else{
                    validarNuevaVenta();
                }
            }
        }catch(NullPointerException e){System.out.println("No pasa nada");}
               
    }
    
    public String buscarCliente(String query) throws SQLException{
        String encontrado = "";
        Conexion conexion = panel.getConexion();
        
        try{
            conexion.iniciarConexion();
            
            conexion.setResult(conexion.getStament().executeQuery(query));
            
            if(conexion.getResult().next()){
                encontrado = "ID: " + conexion.getResult().getObject(1) + "\n" +
                            "Nombre: " + conexion.getResult().getObject(2)  + "\n" +
                            "Ap.Pat: " + conexion.getResult().getObject(3)  + "\n" +
                            "Ap.Mat: " + conexion.getResult().getObject(4)  + "\n" +
                            "Direc: " + conexion.getResult().getObject(5)  + "\n" +
                            "Email: " + conexion.getResult().getObject(6)  + "\n" +
                            "Tel: " + conexion.getResult().getObject(7);
                
                panel.getTextCliente().setText("ID: "+conexion.getResult().getObject(1) + ".  " +
                                                        conexion.getResult().getObject(2) + " " +
                                                        conexion.getResult().getObject(3) + " " +
                                                        conexion.getResult().getObject(4));
                
            }else{
                JOptionPane.showMessageDialog(panel, "No se encontró ningún cliente", 
                        "Resultados", JOptionPane.ERROR_MESSAGE);
                
                encontrado = "-1";
            }
            
            conexion.getStament().close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(panel, "Vaya! Hubo un error. Inténtelo de nuevo. \n\n"+e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            
            encontrado = "-1";
        }finally{
            conexion.cerrarConexion();
        }
        
        return encontrado;
    }
}
