package com.example.JRedFlix.vistas;

import com.example.JRedFlix.JRedFlixApplication;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Ventana extends JFrame {

    private JTabbedPane jTabbedPane1;

    public Ventana() {
        JRedFlixApplication.iniciarSpring();
        setTitle("RedFlix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        //setSize(500, 800);
        pack();

        setVisible(true);
    }

    private void initComponents() {
        setLayout(new GridLayout(1, 1));

        jTabbedPane1 = new JTabbedPane();
        PanelSeries panelSeries = new PanelSeries();
        PanelPeliculas panelPeliculas = new PanelPeliculas();
        PanelUsuarios panelUsuarios = new PanelUsuarios();
        add(jTabbedPane1);
        jTabbedPane1.add(panelSeries, "Series");
        jTabbedPane1.add(panelPeliculas, "Peliculas");
        jTabbedPane1.add(panelUsuarios, "Usuarios");

    }

}
