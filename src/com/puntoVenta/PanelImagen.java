/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntoVenta;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author JR
 */
public class PanelImagen extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
    
        String ruta = "/img/sistema/pina.png";
        ImageIcon im = new ImageIcon(getClass().getResource(ruta));
        Image imagen = im.getImage();
        g.drawImage(imagen, 0, 0, this);
       
    }
    
    
}
