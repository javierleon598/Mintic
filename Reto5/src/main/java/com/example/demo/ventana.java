/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


/**
 *
 * @author olgat
 */
public class ventana extends JFrame{
    
    private JTabbedPane jTabbedPane1;
    
    public ventana() {
       
        setTitle("RedFlix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setVisible(true);
    }
    
    private void initComponents() {
        setLayout(new GridLayout(1, 1));
        
        jTabbedPane1 = new JTabbedPane();
        PanelSeries panelSeries = new PanelSeries();
        PanelPeliculas_1 PanelPeliculas_1 = new PanelPeliculas_1();
        add(jTabbedPane1);
        jTabbedPane1.add(panelSeries,"Series");
        jTabbedPane1.add(PanelPeliculas_1,"Peliculas");
        
        
      
    }
    
    
   
}