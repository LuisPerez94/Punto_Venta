package com.puntoVenta;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Fernando2
 * Created on Dec 30, 2014, 9:11:17 PM
 */

public class BuscarProductosMasVendidos extends JFrame{
    private JComboBox anio, mes, dia, anio2, mes2, dia2;
    private JButton buscar;
    private JButton cancelar;
    
    public BuscarProductosMasVendidos(OyenteProductosMasVendidos oyente){
        super("Productos más vendidos");
        this.setSize(500, 190);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addComponentes();
        addEventos(oyente);
        this.setVisible(true);
    }
    
    public final void addComponentes(){
        JPanel panel = new JPanel();
        JPanel norte = new JPanel();
        JPanel centro = new JPanel();
        JPanel sur = new JPanel();
        
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        
        norte.add(new JLabel("Buscar entre..."));
        
        // Llenamos los combobox...
        Calendar calendario = new GregorianCalendar();

        String[] anios = new String[calendario.get(Calendar.YEAR)-(2013-1)],
                meses = new String[12], 
                dias = new String[31];
        
        
        for(int i = 0; i <= calendario.get(Calendar.YEAR)-2013; i++){
            anios[i] = ((calendario.get(Calendar.YEAR)) - (i))+"";
//            System.out.println("Calendariooooo");
        }
        
        for(int i = 0; i < 12; i++){
            meses[i] = (i+1)+"";
        }
        
        for(int i = 0; i < 31; i++){
            dias[i] = (i+1)+"";
        }
        
        anio = new JComboBox(anios);
        anio2 = new JComboBox(anios);
        mes = new JComboBox(meses);
        mes2 = new JComboBox(meses);
        dia = new JComboBox(dias);
        dia2 = new JComboBox(dias);

        JPanel subCentroN = new JPanel();
        JPanel subCentroS = new JPanel();
        
        subCentroN.add(new JLabel("Límite superior"));
        subCentroN.add(anio);
        subCentroN.add(new JLabel(" / "));
        subCentroN.add(mes);
        subCentroN.add(new JLabel(" / "));
        subCentroN.add(dia);
        
        subCentroS.add(new JLabel("Límite inferior"));
        subCentroS.add(anio2);
        subCentroS.add(new JLabel(" / "));
        subCentroS.add(mes2);
        subCentroS.add(new JLabel(" / "));
        subCentroS.add(dia2);
        
        centro.add(subCentroN);
        centro.add(subCentroS);
        
        buscar = new JButton("Buscar");
        cancelar = new JButton("Cancelar");
        
        sur.add(cancelar);
        sur.add(buscar);
        
        
        panel.add(norte, "North");
        panel.add(centro, "Center");
        panel.add(sur, "South");
        
        this.add(panel);
    }
    
    public final void addEventos(OyenteProductosMasVendidos oyente){
//        anio.addActionListener(oyente);
//        mes.addActionListener(oyente);
//        dia.addActionListener(oyente);
//        anio2.addActionListener(oyente);
//        mes2.addActionListener(oyente);
//        dia2.addActionListener(oyente);
        cancelar.addActionListener(oyente);
        buscar.addActionListener(oyente);
    }

    public JComboBox getAnio() {
        return anio;
    }

    public JComboBox getMes() {
        return mes;
    }

    public JComboBox getDia() {
        return dia;
    }

    public JComboBox getAnio2() {
        return anio2;
    }

    public JComboBox getMes2() {
        return mes2;
    }

    public JComboBox getDia2() {
        return dia2;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getCancelar() {
        return cancelar;
    }
    
    
}
