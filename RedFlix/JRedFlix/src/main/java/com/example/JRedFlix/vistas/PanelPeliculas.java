package com.example.JRedFlix.vistas;

import com.example.JRedFlix.Repositorios.RepositorioPelicula;
import com.example.JRedFlix.SpringContext;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelPeliculas extends JPanel {

    RepositorioPelicula repositorioPelicula;
    //RepositorioDirector RepositorioDirector;
    private JPanel jPanelDatos;
    private JPanel jPanelAccion;
    private JPanel jPanelResultado;

    private JRadioButton jRadioButtonConsultar;
    private JRadioButton jRadioButtonActualizar;
    private JRadioButton jRadioButtonInsertar;
    private JRadioButton jRadioButtonEliminar;
    private JTextArea JTextAreaResultado;
    private JTextField JTextFieldNombre;
    private JLabel JLabelNombre;
    private JTextField JTextFieldDirector;
    private JLabel JLabelDirector;
    private JTextArea jTextFieldResumen;
    private JLabel JLabelResumen;
    private JTextField JTextFieldAnio;
    private JLabel JLabelAnio;
    private ButtonGroup buttonGroupDireccion;
    private JButton botonEjecutar;

    public PanelPeliculas() {
        repositorioPelicula = SpringContext.getBean(RepositorioPelicula.class);
        initComponents();
    }

    private void initComponents() {

        GridLayout gridLayout = new GridLayout(3, 1, 10, 10);
        setLayout(gridLayout);

        GridLayout gridLayoutAccion = new GridLayout(2, 1);
        GridLayout gridLayoutDatos = new GridLayout(4, 1, 0, 10);
        GridLayout gridLayoutResultado = new GridLayout(0, 1, 10, 10);

        botonEjecutar = new JButton("ejecutar");
        jRadioButtonConsultar = new JRadioButton("Consultar", true);
        jRadioButtonActualizar = new JRadioButton("Actualizar");
        jRadioButtonInsertar = new JRadioButton("Eliminar");
        jRadioButtonEliminar = new JRadioButton("Insertar");
        JTextAreaResultado = new JTextArea("Resultado");
        JTextFieldNombre = new JTextField(20);
        JLabelNombre = new JLabel("Nombre");
        JTextFieldDirector = new JTextField(20);
        JLabelDirector = new JLabel("Director");
        jTextFieldResumen = new JTextArea();
        JLabelResumen = new JLabel("Resumen");
        JTextFieldAnio = new JTextField(20);
        JLabelAnio = new JLabel("Año");
        jPanelAccion = new JPanel();
        jPanelDatos = new JPanel();
        jPanelResultado = new JPanel();

        jPanelAccion.setLayout(gridLayoutAccion);
        jPanelDatos.setLayout(gridLayoutDatos);
        jPanelResultado.setLayout(gridLayoutResultado);

        buttonGroupDireccion = new ButtonGroup();
        // Adiciona el boton de opción a un grupo de botones
        buttonGroupDireccion.add(jRadioButtonConsultar);
        buttonGroupDireccion.add(jRadioButtonActualizar);
        buttonGroupDireccion.add(jRadioButtonInsertar);
        buttonGroupDireccion.add(jRadioButtonEliminar);
        ListenerAccionPelicula listenerAccion = new ListenerAccionPelicula( 
                repositorioPelicula, jRadioButtonConsultar, jRadioButtonActualizar, 
                jRadioButtonInsertar, jRadioButtonEliminar, JTextFieldNombre, JTextFieldDirector, 
                JTextFieldAnio, jTextFieldResumen, JTextAreaResultado);
        botonEjecutar.addActionListener(listenerAccion);

        add(jPanelAccion);
        jPanelAccion.add(jRadioButtonConsultar);
        jPanelAccion.add(jRadioButtonActualizar);
        jPanelAccion.add(jRadioButtonInsertar);
        jPanelAccion.add(jRadioButtonEliminar);

        add(jPanelDatos);
        jPanelDatos.add(JLabelNombre);
        jPanelDatos.add(JTextFieldNombre);

        jPanelDatos.add(JLabelDirector);
        jPanelDatos.add(JTextFieldDirector);

        jPanelDatos.add(JLabelResumen);
        jPanelDatos.add(jTextFieldResumen);

        jPanelDatos.add(JLabelAnio);
        jPanelDatos.add(JTextFieldAnio);

        add(jPanelResultado);
        jPanelResultado.add(botonEjecutar);

        jPanelResultado.add(JTextAreaResultado);

    }

    public JRadioButton getjRadioButtonConsultar() {
        return jRadioButtonConsultar;
    }

    public void setjRadioButtonConsultar(JRadioButton jRadioButtonConsultar) {
        this.jRadioButtonConsultar = jRadioButtonConsultar;
    }

    public JRadioButton getjRadioButtonActualizar() {
        return jRadioButtonActualizar;
    }

    public void setjRadioButtonActualizar(JRadioButton jRadioButtonActualizar) {
        this.jRadioButtonActualizar = jRadioButtonActualizar;
    }

    public JRadioButton getjRadioButtonInsertar() {
        return jRadioButtonInsertar;
    }

    public void setjRadioButtonInsertar(JRadioButton jRadioButtonInsertar) {
        this.jRadioButtonInsertar = jRadioButtonInsertar;
    }

    public JRadioButton getjRadioButtonEliminar() {
        return jRadioButtonEliminar;
    }

    public void setjRadioButtonEliminar(JRadioButton jRadioButtonEliminar) {
        this.jRadioButtonEliminar = jRadioButtonEliminar;
    }

    public JTextArea getJTextAreaResultado() {
        return JTextAreaResultado;
    }

    public void setJTextAreaResultado(JTextArea JTextAreaResultado) {
        this.JTextAreaResultado = JTextAreaResultado;
    }

    public JTextField getJTextFieldNombre() {
        return JTextFieldNombre;
    }

    public void setJTextFieldNombre(JTextField JTextFieldNombre) {
        this.JTextFieldNombre = JTextFieldNombre;
    }

    public JLabel getJLabelNombre() {
        return JLabelNombre;
    }

    public void setJLabelNombre(JLabel JLabelNombre) {
        this.JLabelNombre = JLabelNombre;
    }

    public JTextField getJTextFieldDirector() {
        return JTextFieldDirector;
    }

    public void setJTextFieldDirector(JTextField JTextFieldDirector) {
        this.JTextFieldDirector = JTextFieldDirector;
    }

    public JLabel getJLabelDirector() {
        return JLabelDirector;
    }

    public void setJLabelDirector(JLabel JLabelDirector) {
        this.JLabelDirector = JLabelDirector;
    }

    public JTextArea getJTextFieldResumen() {
        return jTextFieldResumen;
    }

    public void setJTextFieldResumen(JTextField JTextArea) {
        this.jTextFieldResumen = jTextFieldResumen;
    }

    public JLabel getJLabelResumen() {
        return JLabelResumen;
    }

    public void setJLabelResumen(JLabel JLabelResumen) {
        this.JLabelResumen = JLabelResumen;
    }

    public JTextField getJTextFieldAnio() {
        return JTextFieldAnio;
    }

    public void setJTextFieldAnio(JTextField JTextFieldAnio) {
        this.JTextFieldAnio = JTextFieldAnio;
    }

    public JLabel getJLabelAnio() {
        return JLabelAnio;
    }

    public void setJLabelAnio(JLabel JLabelAnio) {
        this.JLabelAnio = JLabelAnio;
    }

    public ButtonGroup getButtonGroupDireccion() {
        return buttonGroupDireccion;
    }

    public void setButtonGroupDireccion(ButtonGroup buttonGroupDireccion) {
        this.buttonGroupDireccion = buttonGroupDireccion;
    }

}
