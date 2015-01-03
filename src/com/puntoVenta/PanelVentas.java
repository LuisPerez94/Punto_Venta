/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import com.oyentes.OyenteReporteVentas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JR
 */
public class PanelVentas extends JPanel {

   
   
    private JScrollPane desplazar;

    private final String[] dias = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private final String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
//    private final String[] anios = new String[]{"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000",
//        "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
//        "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034",
//        "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"};
    private final String[] anios;
    
    private JComboBox anio1;
    private JComboBox anio2;
    private JComboBox mes1;
    private JComboBox mes2;
    private JComboBox dia1;
    private JComboBox dia2;

    private JButton go;

    public PanelVentas(){ Calendar calendario = new GregorianCalendar();

        // Calendario con años que se agregan según la fecha del sistema...
        anios = new String[calendario.get(Calendar.YEAR)-(2013-1)];
        
        for(int i = 0; i <= calendario.get(Calendar.YEAR)-2013; i++){
            anios[i] = ((calendario.get(Calendar.YEAR)) - (i))+"";
        }
        
        anio1 = new JComboBox(anios);
        anio2 = new JComboBox(anios);
        mes1 = new JComboBox(meses);
        mes2 = new JComboBox(meses);
        dia1 = new JComboBox(dias);
        dia2 = new JComboBox(dias);
        go = new JButton("Ver el reporte");
        
        addComponentes();
    }

    public final void addComponentes() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        JPanel panelNorte = new JPanel();
        panelNorte.setBorder(BorderFactory.createLineBorder(this.getBackground(), 10));
        panelNorte.add(new JLabel("Buscar las ventas totales en el siguiente intervalo"));
        JPanel panelCentro = new JPanel();
        JPanel panelSur = new JPanel();
        JLabel eti = new JLabel("Límite inferior: ");
        JLabel eti2 = new JLabel("Límite superior: ");

        panelCentro.add(eti);
        panelCentro.add(new JLabel("Año :"));
        panelCentro.add(anio1);
        panelCentro.add(new JLabel("Mes :"));
        panelCentro.add(mes1);
        panelCentro.add(new JLabel("Día :"));
        panelCentro.add(dia1);
        panelCentro.add(eti2);
        panelCentro.add(new JLabel("Año :"));
        panelCentro.add(anio2);
        panelCentro.add(new JLabel("Mes :"));
        panelCentro.add(mes2);
        panelCentro.add(new JLabel("Día :"));
        panelCentro.add(dia2);

        panelSur.add(go);
        
        this.add(panelNorte, "North");
        this.add(panelCentro, "Center");
        this.add(panelSur, "South");

    }

    public void addEventos(OyenteReporteVentas o) {
        go.addActionListener(o);

    }

///////////////////////////////////GETTER Y SETTER /////////////////////////////////
   
   

    
    public JScrollPane getDesplazar() {
        return desplazar;
    }

    public void setDesplazar(JScrollPane desplazar) {
        this.desplazar = desplazar;
    }

    public JComboBox getAnio1() {
        return anio1;
    }

    public void setAnio1(JComboBox anio1) {
        this.anio1 = anio1;
    }

    public JComboBox getAnio2() {
        return anio2;
    }

    public void setAnio2(JComboBox anio2) {
        this.anio2 = anio2;
    }

    public JComboBox getMes1() {
        return mes1;
    }

    public void setMes1(JComboBox mes1) {
        this.mes1 = mes1;
    }

    public JComboBox getMes2() {
        return mes2;
    }

    public void setMes2(JComboBox mes2) {
        this.mes2 = mes2;
    }

    public JComboBox getDia1() {
        return dia1;
    }

    public void setDia1(JComboBox dia1) {
        this.dia1 = dia1;
    }

    public JComboBox getDia2() {
        return dia2;
    }

    public void setDia2(JComboBox dia2) {
        this.dia2 = dia2;
    }

    public JButton getGo() {
        return go;
    }

    public void setGo(JButton go) {
        this.go = go;
    }

}
