package com.example.demo.vistas;

import com.example.demo.Repositorios.RepositorioUsuario;
import com.example.demo.SpringContext;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 *
 * @author olgat
 */

public class PanelUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form PanelUsuarios
     */
    private JPanel jPanelDatos;
    private JPanel jPanelAccion;
    private JPanel jPanelResultado;
    ButtonGroup buttonGroupDireccion;
    JRadioButton jRadioButtonConsultar; 
    JRadioButton jRadioButtonActualizar;
    JRadioButton jRadioButtonInsertar;
    JRadioButton jRadioButtonEliminar;
    private JTextArea JTextAreaResultado;
    private JTextField JTextFieldNombre;
    private JLabel JLabelNombre;
    private JTextField JTextFieldApellido;
    private JLabel JLabelApellido;
    private JTextField JTextFieldEmail;
    private JLabel JLabelCelular;
    private JTextField JTextFieldCelular;
    private JLabel JLabelEmail;
    private JTextField JTextFieldUsuario;
    private JLabel JLabelUsuario;
    private JTextField JTextFieldContrasena;
    private JLabel JLabelContrasena;
    private JLabel JLabelFechaNac;
    private com.toedter.calendar.JDateChooser jDateChooserFechaNacimiento;
    
    
    RepositorioUsuario RepositorioUsuario = SpringContext.getBean(RepositorioUsuario.class);
    
    public PanelUsuarios() {
        initComponents();
    }
    private void initComponents() {
         
        GridLayout gridLayout = new GridLayout(3,1,10,10);
        setLayout(gridLayout);
       
         
        GridLayout gridLayoutAccion = new GridLayout(2,1);     
        GridLayout gridLayoutDatos = new GridLayout(4,4,0,5);     
        GridLayout gridLayoutResultado = new GridLayout(0,1,10,10);
         
         JButton botonEjecutar = new JButton("ejecutar");
        
         
         jRadioButtonConsultar = new JRadioButton("Consultar", true);
         jRadioButtonActualizar = new JRadioButton("Actualizar");
         jRadioButtonInsertar = new JRadioButton("Insertar");
         jRadioButtonEliminar = new JRadioButton("Eliminar");
         
         JTextAreaResultado = new JTextArea("Resultado");
         
         JTextFieldNombre = new JTextField(12);
         JLabelNombre= new JLabel("Nombre");
         
         JTextFieldApellido = new JTextField(12);
         JLabelApellido = new JLabel("Apellido");
         
         JLabelCelular = new JLabel ("Celular");
         JTextFieldCelular = new JTextField(12);
         
         JLabelFechaNac = new JLabel("Fecha de nacimiento");
         jDateChooserFechaNacimiento = new com.toedter.calendar.JDateChooser();
         
         JLabelEmail = new JLabel("email");
         JTextFieldEmail = new JTextField(12);
         
         JLabelUsuario = new JLabel("Usuario");
         JTextFieldUsuario = new JTextField(12);
         
         JLabelContrasena = new JLabel("Contraseña");
         JTextFieldContrasena = new JTextField(12);
         
         
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
        
        ListenerAccionUsuario ListenerAccionUsuario = new ListenerAccionUsuario(RepositorioUsuario,buttonGroupDireccion, JTextFieldNombre, JTextFieldApellido, jDateChooserFechaNacimiento, JTextFieldEmail, JTextFieldCelular, JTextFieldUsuario, JTextFieldContrasena,  JTextAreaResultado );
        botonEjecutar.addActionListener(ListenerAccionUsuario);
        
      
        add(jPanelAccion);
        jPanelAccion.add(jRadioButtonConsultar);
        jPanelAccion.add(jRadioButtonActualizar);
        jPanelAccion.add(jRadioButtonInsertar);
        jPanelAccion.add(jRadioButtonEliminar);
        
        
        add(jPanelDatos);
        jPanelDatos.add(JLabelNombre);
        jPanelDatos.add(JTextFieldNombre);
        
        jPanelDatos.add(JLabelApellido);
        jPanelDatos.add(JTextFieldApellido);
        
        jPanelDatos.add(JLabelFechaNac);
        jPanelDatos.add(jDateChooserFechaNacimiento);
        
        jPanelDatos.add(JLabelCelular);
        jPanelDatos.add(JTextFieldCelular);
        
        jPanelDatos.add(JLabelEmail);
        jPanelDatos.add(JTextFieldEmail);
        
        jPanelDatos.add(JLabelUsuario);
        jPanelDatos.add(JTextFieldUsuario);
        
        
        jPanelDatos.add(JLabelContrasena);
        jPanelDatos.add(JTextFieldContrasena);
        
        add(jPanelResultado);
        jPanelResultado.add(botonEjecutar);
        jPanelResultado.add(JTextAreaResultado);
       
        
    }

    public JPanel getjPanelDatos() {
        return jPanelDatos;
    }

    public void setjPanelDatos(JPanel jPanelDatos) {
        this.jPanelDatos = jPanelDatos;
    }

    public JPanel getjPanelAccion() {
        return jPanelAccion;
    }

    public void setjPanelAccion(JPanel jPanelAccion) {
        this.jPanelAccion = jPanelAccion;
    }

    public JPanel getjPanelResultado() {
        return jPanelResultado;
    }

    public void setjPanelResultado(JPanel jPanelResultado) {
        this.jPanelResultado = jPanelResultado;
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

    public JLabel getJLabelCelular() {
        return JLabelCelular;
    }

    public void setJLabelCelular(JLabel JLabelCelular) {
        this.JLabelCelular = JLabelCelular;
    }

    public JTextField getJTextFieldCelular() {
        return JTextFieldCelular;
    }

    public void setJTextFieldCelular(JTextField JTextFieldCelular) {
        this.JTextFieldCelular = JTextFieldCelular;
    }

    public JLabel getJLabelEmail() {
        return JLabelEmail;
    }

    public void setJLabelEmail(JLabel JLabelEmail) {
        this.JLabelEmail = JLabelEmail;
    }

    public JTextField getJTextFieldUsuario() {
        return JTextFieldUsuario;
    }

    public void setJTextFieldUsuario(JTextField JTextFieldUsuario) {
        this.JTextFieldUsuario = JTextFieldUsuario;
    }

    public JLabel getJLabelUsuario() {
        return JLabelUsuario;
    }

    public void setJLabelUsuario(JLabel JLabelUsuario) {
        this.JLabelUsuario = JLabelUsuario;
    }

    public JTextField getJTextFieldContrasena() {
        return JTextFieldContrasena;
    }

    public void setJTextFieldContrasena(JTextField JTextFieldContrasena) {
        this.JTextFieldContrasena = JTextFieldContrasena;
    }

    public JLabel getJLabelContrasena() {
        return JLabelContrasena;
    }

    public void setJLabelContrasena(JLabel JLabelContrasena) {
        this.JLabelContrasena = JLabelContrasena;
    }

    public JLabel getJLabelFechaNac() {
        return JLabelFechaNac;
    }

    public void setJLabelFechaNac(JLabel JLabelFechaNac) {
        this.JLabelFechaNac = JLabelFechaNac;
    }

    public JDateChooser getjDateChooserFechaNacimiento() {
        return jDateChooserFechaNacimiento;
    }

    public void setjDateChooserFechaNacimiento(JDateChooser jDateChooserFechaNacimiento) {
        this.jDateChooserFechaNacimiento = jDateChooserFechaNacimiento;
    }

    public ButtonGroup getButtonGroupDireccion() {
        return buttonGroupDireccion;
    }

    public void setButtonGroupDireccion(ButtonGroup buttonGroupDireccion) {
        this.buttonGroupDireccion = buttonGroupDireccion;
    }

  

   
}