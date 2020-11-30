/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 *
 * @author olgat
 */
public class PanelPeliculas extends JPanel{
    
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
    private JTextField JTextFieldResumen;
    private JLabel JLabelResumen;
    private JTextField JTextFieldAnio;
    private JLabel JLabelAnio;
    private ButtonGroup buttonGroupDireccion;
    private JButton botonEjecutar;
    private Object date;
    
     public PanelPeliculas() {
        initComponents();
    }
     
     private void initComponents() {
         
        GridLayout gridLayout = new GridLayout(3,1,10,10);
        setLayout(gridLayout);
       
         
        GridLayout gridLayoutAccion = new GridLayout(2,1);     
        GridLayout gridLayoutDatos = new GridLayout(4,1,0,10);     
        GridLayout gridLayoutResultado = new GridLayout(0,1,10,10);
        
        
         
         
         botonEjecutar = new JButton("ejecutar");
         jRadioButtonConsultar = new JRadioButton("Consultar", true);
         jRadioButtonActualizar = new JRadioButton("Actualizar");
         jRadioButtonInsertar = new JRadioButton("Insertar");
         jRadioButtonEliminar = new JRadioButton("Eliminar");
         JTextAreaResultado = new JTextArea("Resultado");
         JTextFieldNombre = new JTextField(20);
         JLabelNombre= new JLabel("Nombre");
         JTextFieldDirector = new JTextField(20);
         JLabelDirector = new JLabel("Director");
         JTextFieldResumen = new JTextField(20);
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
        ListenerAccionPelicula ListenerAccion = new ListenerAccionPelicula(jRadioButtonConsultar, jRadioButtonActualizar, jRadioButtonInsertar, jRadioButtonEliminar, JTextFieldNombre, JTextFieldDirector, JTextFieldAnio, JTextFieldResumen);
        botonEjecutar.addActionListener(ListenerAccion);
     
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
        jPanelDatos.add(JTextFieldResumen);
        
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

    public JTextField getJTextFieldResumen() {
        return JTextFieldResumen;
    }

    public void setJTextFieldResumen(JTextField JTextFieldResumen) {
        this.JTextFieldResumen = JTextFieldResumen;
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
