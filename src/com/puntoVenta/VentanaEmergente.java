/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author JR
 */
public class VentanaEmergente extends JFrame{

    public VentanaEmergente(String title) {
        super(title);
          
          setSize(800, 600);
          setLocationRelativeTo(null);
          this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
          setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    
    }
        
  
}
