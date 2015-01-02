package com.puntoVenta;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * @author Luis
 * Created on 17/12/2014, 10:53:59 AM
 */

public class Login extends JFrame{
    private PanelLogin log;
    
    public Login() {
        
        super("PiñaSports");
        setSize(500, 520);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/img/sistema/pina.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
       
    }
}
