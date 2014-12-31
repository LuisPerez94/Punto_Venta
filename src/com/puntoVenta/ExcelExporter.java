package com.puntoVenta;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.table.*;
 
import jxl.*;
import jxl.write.*;

/**
 * @author Fernando2
 * Created on Dec 30, 2014, 11:58:57 PM
 */

public class ExcelExporter {
    
    public static void fillData(JTable table, File file) {
        try {
            Calendar calendar = new GregorianCalendar();
            String date = calendar.get(Calendar.DATE) + "-" + (calendar.get(Calendar.MONTH)+1) + "-" +
                            calendar.get(Calendar.YEAR);
            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet("Reporte de "+date, 0);
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                    model.getValueAt(i, j).toString().replace("$ ", ""));
                    sheet1.addCell(row);
           }
        }

        workbook1.write();
        workbook1.close();
        
        JOptionPane.showMessageDialog(null, "Reporte exportado correctamente", "Guardado", 
                JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException | WriteException ex) {
             JOptionPane.showMessageDialog(null, "Hubo un error al exportar\n" + ex.getMessage(),
                     "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
