/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.vistas;

import com.example.demo.Repositorios.RepositorioContenido;
import com.example.demo.Repositorios.RepositorioDirector;
import com.example.demo.Repositorios.RepositorioPelicula;
import com.example.demo.SpringContext;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
/**
 *
 * @author olgat
 */

public class PanelPeliculas extends JPanel{
   
    private RepositorioContenido RepositorioContenido;
    private RepositorioPelicula RepositorioPelicula;
    private RepositorioDirector RepositorioDirector;
    
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
    private JLabel JLabelResumen;
    private JTextArea JTextAreaResumen;
    private JTextField JTextFieldAnio;
    private JLabel JLabelAnio;
    private ButtonGroup buttonGroupDireccion;
    private JButton botonEjecutar;
    
    private JLabel JLabelEncabezadoDirector;
    private JLabel JLabelDirector;
    private JTextField JTextFieldDirector;
    private JLabel JLabelDirectorNacionalidad;
    private JTextField JTextFieldDirectorNacionalidad;
   
    
     public PanelPeliculas() {
        initComponents();
    }
     
     private void initComponents() {
         
        GridLayout gridLayout = new GridLayout(3,1,10,10);
        setLayout(gridLayout);
        RepositorioContenido = SpringContext.getBean(RepositorioContenido.class);
        RepositorioPelicula = SpringContext.getBean(RepositorioPelicula.class);
        RepositorioDirector = SpringContext.getBean(RepositorioDirector.class);
        
        GridLayout gridLayoutAccion = new GridLayout(2,1);     
        GridLayout gridLayoutDatos = new GridLayout(0,2);    
        GridLayout gridLayoutResultado = new GridLayout(0,1,1,3);
         
         botonEjecutar = new JButton("ejecutar");
         jRadioButtonConsultar = new JRadioButton("Consultar", true);
         jRadioButtonActualizar = new JRadioButton("Actualizar");
         jRadioButtonInsertar = new JRadioButton("Insertar");
         jRadioButtonEliminar = new JRadioButton("Eliminar");
         JTextAreaResultado = new JTextArea("Resultado");
         JTextFieldNombre = new JTextField(20);
         JLabelNombre= new JLabel("Nombre");
         
        
         JTextAreaResumen = new JTextArea(2,0);
         JTextAreaResumen.setLineWrap(true);
         JTextAreaResumen.setWrapStyleWord(true);
         JScrollPane scrollPane = new JScrollPane(JTextAreaResumen);
         JTextAreaResumen.setEditable(true);
         JLabelResumen = new JLabel("Resumen");
         JTextFieldAnio = new JTextField(20);
         JLabelAnio = new JLabel("Año");
         
         JLabelEncabezadoDirector = new JLabel("Datos Director");
         JLabelDirector = new JLabel("Director");
         JTextFieldDirector = new JTextField();
         JLabelDirectorNacionalidad = new JLabel("Nacionalidad");
         JTextFieldDirectorNacionalidad = new JTextField();
         
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
        
        ListenerAccionPelicula ListenerAccion = new ListenerAccionPelicula(JTextAreaResultado,RepositorioDirector,RepositorioContenido, RepositorioPelicula,buttonGroupDireccion, JTextFieldNombre, JTextFieldDirector, JTextFieldAnio, JTextAreaResumen, JTextFieldDirectorNacionalidad);
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
                
        jPanelDatos.add(JLabelAnio);
        jPanelDatos.add(JTextFieldAnio);
        
        
        jPanelDatos.add(JLabelDirector);
        jPanelDatos.add(JTextFieldDirector);
        jPanelDatos.add(JLabelDirectorNacionalidad);
        jPanelDatos.add(JTextFieldDirectorNacionalidad);
        
        
        add(jPanelResultado);
        jPanelResultado.add(JLabelResumen);
        jPanelResultado.add(JTextAreaResumen);
        jPanelResultado.add(botonEjecutar);
        
        jPanelResultado.add(JTextAreaResultado);
        
    
        
     }

    public RepositorioContenido getRepositorioContenido() {
        return RepositorioContenido;
    }

    public void setRepositorioContenido(RepositorioContenido RepositorioContenido) {
        this.RepositorioContenido = RepositorioContenido;
    }

    public RepositorioPelicula getRepositorioPelicula() {
        return RepositorioPelicula;
    }

    public void setRepositorioPelicula(RepositorioPelicula RepositorioPelicula) {
        this.RepositorioPelicula = RepositorioPelicula;
    }

    public RepositorioDirector getRepositorioDirector() {
        return RepositorioDirector;
    }

    public void setRepositorioDirector(RepositorioDirector RepositorioDirector) {
        this.RepositorioDirector = RepositorioDirector;
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

    public JLabel getJLabelResumen() {
        return JLabelResumen;
    }

    public void setJLabelResumen(JLabel JLabelResumen) {
        this.JLabelResumen = JLabelResumen;
    }

    public JTextArea getJTextAreaResumen() {
        return JTextAreaResumen;
    }

    public void setJTextAreaResumen(JTextArea JTextAreaResumen) {
        this.JTextAreaResumen = JTextAreaResumen;
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

    public JButton getBotonEjecutar() {
        return botonEjecutar;
    }

    public void setBotonEjecutar(JButton botonEjecutar) {
        this.botonEjecutar = botonEjecutar;
    }

    public JLabel getJLabelEncabezadoDirector() {
        return JLabelEncabezadoDirector;
    }

    public void setJLabelEncabezadoDirector(JLabel JLabelEncabezadoDirector) {
        this.JLabelEncabezadoDirector = JLabelEncabezadoDirector;
    }

    public JLabel getJLabelDirector() {
        return JLabelDirector;
    }

    public void setJLabelDirector(JLabel JLabelDirector) {
        this.JLabelDirector = JLabelDirector;
    }

    public JTextField getJTextFieldDirector() {
        return JTextFieldDirector;
    }

    public void setJTextFieldDirector(JTextField JTextFieldDirector) {
        this.JTextFieldDirector = JTextFieldDirector;
    }

    public JLabel getJLabelDirectorNacionalidad() {
        return JLabelDirectorNacionalidad;
    }

    public void setJLabelDirectorNacionalidad(JLabel JLabelDirectorNacionalidad) {
        this.JLabelDirectorNacionalidad = JLabelDirectorNacionalidad;
    }

    public JTextField getJTextFieldDirectorNacionalidad() {
        return JTextFieldDirectorNacionalidad;
    }

    public void setJTextFieldDirectorNacionalidad(JTextField JTextFieldDirectorNacionalidad) {
        this.JTextFieldDirectorNacionalidad = JTextFieldDirectorNacionalidad;
    }

    
}
