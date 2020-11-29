/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
public class PanelUsuarios extends JPanel{
    
    private JRadioButton jRadioButtonConsultar; 
    private JRadioButton jRadioButtonActualizar;
    private JRadioButton jRadioButtonInsertar;
    private JRadioButton jRadioButtonEliminar;
    private JTextArea JTextAreaResultado;
    private JTextField JTextFieldNombre;
    private JLabel JLabelNombre;
    private JTextField JTextFieldApellido;
    private JLabel JLabelApellido;
    private JTextField JTextFieldEmail;
    private JLabel JLabelEmail;
    private JTextField JTextFieldUsuaro;
    private JLabel JLabelUsuario;
    private ButtonGroup buttonGroupDireccion;
    
     public PanelUsuarios() {
        initComponents();
    }
     
     private void initComponents() {
         
        GridLayout gridLayout = new GridLayout(10,1);
        gridLayout.setVgap(15);
        setLayout(gridLayout);
         
         JButton botonEjecutar = new JButton("ejecutar");
         
         
         
         jRadioButtonConsultar = new JRadioButton("Consultar", true);
         jRadioButtonActualizar = new JRadioButton("Actualizar");
         jRadioButtonInsertar = new JRadioButton("Insertar");
         jRadioButtonEliminar = new JRadioButton("Eliminar");
         JTextAreaResultado = new JTextArea("Resultado");
         JTextFieldNombre = new JTextField(20);
         JLabelNombre= new JLabel("Nombre");
         JTextFieldApellido = new JTextField(20);
         JLabelApellido = new JLabel("Apellido");
         JTextFieldEmail = new JTextField(20);
         JLabelEmail = new JLabel("email");
         JTextFieldUsuaro = new JTextField(20);
         JLabelUsuario = new JLabel("Usuario");
         
         
        buttonGroupDireccion = new ButtonGroup();
        // Adiciona el boton de opción a un grupo de botones
        buttonGroupDireccion.add(jRadioButtonConsultar);
        buttonGroupDireccion.add(jRadioButtonActualizar);
        buttonGroupDireccion.add(jRadioButtonInsertar);
        buttonGroupDireccion.add(jRadioButtonEliminar);
        ListenerAccionPelicula ListenerAccion = new ListenerAccionPelicula(jRadioButtonConsultar, jRadioButtonActualizar, jRadioButtonInsertar, jRadioButtonEliminar, JTextFieldNombre, JTextFieldApellido, JTextFieldEmail, JTextFieldUsuaro);
        botonEjecutar.addActionListener(ListenerAccion);
     
      
        add(jRadioButtonConsultar);
        add(jRadioButtonActualizar);
        add(jRadioButtonInsertar);
        add(jRadioButtonEliminar);
        
        add(botonEjecutar);
        
        add(JLabelNombre);
        add(JTextFieldNombre);
        
        add(JLabelApellido);
        add(JTextFieldApellido);
        
        add(JLabelEmail);
        add(JTextFieldEmail);
        
        add(JLabelUsuario);
        add(JTextFieldUsuaro);
        
        
        add(JTextAreaResultado);
        
       
        
        
        
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

    public JTextField getJTextFieldApellido() {
        return JTextFieldApellido;
    }

    public void setJTextFieldApellido(JTextField JTextFieldApellido) {
        this.JTextFieldApellido = JTextFieldApellido;
    }

    public JLabel getJLabelApellido() {
        return JLabelApellido;
    }

    public void setJLabelApellido(JLabel JLabelApellido) {
        this.JLabelApellido = JLabelApellido;
    }

    public JTextField getJTextFieldEmail() {
        return JTextFieldEmail;
    }

    public void setJTextFieldEmail(JTextField JTextFieldEmail) {
        this.JTextFieldEmail = JTextFieldEmail;
    }

    public JLabel getJLabelEmail() {
        return JLabelEmail;
    }

    public void setJLabelEmail(JLabel JLabelEmail) {
        this.JLabelEmail = JLabelEmail;
    }

    public JTextField getJTextFieldUsuaro() {
        return JTextFieldUsuaro;
    }

    public void setJTextFieldUsuaro(JTextField JTextFieldUsuaro) {
        this.JTextFieldUsuaro = JTextFieldUsuaro;
    }

    public JLabel getJLabelUsuario() {
        return JLabelUsuario;
    }

    public void setJLabelUsuario(JLabel JLabelUsuario) {
        this.JLabelUsuario = JLabelUsuario;
    }

    public ButtonGroup getButtonGroupDireccion() {
        return buttonGroupDireccion;
    }

    public void setButtonGroupDireccion(ButtonGroup buttonGroupDireccion) {
        this.buttonGroupDireccion = buttonGroupDireccion;
    }
}