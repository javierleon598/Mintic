/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
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
public class PanelSeries extends JPanel{
    
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
    private JTextField JTextFieldEpisodios;
    private JLabel JLabelEpisodios;
    private JTextField JTextFieldTemporadas;
    private JLabel JLabelTemporadas;
    private ButtonGroup buttonGroupDireccion;
    
     public PanelSeries() {
        initComponents();
    }
     
     private void initComponents() {
         
        GridLayout gridLayout = new GridLayout(3,1,10,10);
        setLayout(gridLayout);
       
         
        GridLayout gridLayoutAccion = new GridLayout(2,1);     
        GridLayout gridLayoutDatos = new GridLayout(4,1,0,10);     
        GridLayout gridLayoutResultado = new GridLayout(0,1,10,10);
         
        
        JButton botonEjecutar = new JButton("ejecutar");
         
         jRadioButtonConsultar = new JRadioButton("Consultar", true);
         jRadioButtonActualizar = new JRadioButton("Actualizar");
         jRadioButtonInsertar = new JRadioButton("Insertar");
         jRadioButtonEliminar = new JRadioButton("Eliminar");
         JTextAreaResultado = new JTextArea("Resultado");
         JTextFieldNombre = new JTextField(20);
         JLabelNombre= new JLabel("Nombre");
         JTextFieldEpisodios = new JTextField(20);
         JLabelEpisodios = new JLabel("Episodios");
         JTextFieldTemporadas = new JTextField(20);
         JLabelTemporadas = new JLabel("Temporadas");
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
        ListenerAccionSerie ListenerAccionSerie = new ListenerAccionSerie(jRadioButtonConsultar, jRadioButtonActualizar, jRadioButtonInsertar, jRadioButtonEliminar, JTextFieldNombre, JTextFieldEpisodios, JTextFieldTemporadas);
        botonEjecutar.addActionListener(ListenerAccionSerie);
        
        add(jPanelAccion);
        jPanelAccion.add(jRadioButtonConsultar);
        jPanelAccion.add(jRadioButtonActualizar);
        jPanelAccion.add(jRadioButtonInsertar);
        jPanelAccion.add(jRadioButtonEliminar);
        
       
        add(jPanelDatos);
        jPanelDatos.add(JLabelNombre);
        jPanelDatos.add(JTextFieldNombre);
        
        jPanelDatos.add(JLabelEpisodios);
        jPanelDatos.add(JTextFieldEpisodios);
        
        jPanelDatos.add(JLabelTemporadas);
        jPanelDatos.add(JTextFieldTemporadas);
        
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

    public ButtonGroup getButtonGroupDireccion() {
        return buttonGroupDireccion;
    }

    public void setButtonGroupDireccion(ButtonGroup buttonGroupDireccion) {
        this.buttonGroupDireccion = buttonGroupDireccion;
    }

    public JTextField getJTextFieldEpisodios() {
        return JTextFieldEpisodios;
    }

    public void setJTextFieldEpisodios(JTextField JTextFieldEpisodios) {
        this.JTextFieldEpisodios = JTextFieldEpisodios;
    }

    public JLabel getJLabelEpisodios() {
        return JLabelEpisodios;
    }

    public void setJLabelEpisodios(JLabel JLabelEpisodios) {
        this.JLabelEpisodios = JLabelEpisodios;
    }

    public JTextField getJTextFieldTemporadas() {
        return JTextFieldTemporadas;
    }

    public void setJTextFieldTemporadas(JTextField JTextFieldTemporadas) {
        this.JTextFieldTemporadas = JTextFieldTemporadas;
    }
     
     
}
