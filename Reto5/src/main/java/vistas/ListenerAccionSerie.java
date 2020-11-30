/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author olgat
 */
class ListenerAccionSerie implements ActionListener{
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldEpisodios;
    JTextField JTextFieldTemporadas;
    
    public ListenerAccionSerie(JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldEpisodios, JTextField JTextFieldTemporadas ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldEpisodios = JTextFieldEpisodios;
        this.JTextFieldTemporadas = JTextFieldTemporadas;
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
   
        if (RadioButtonConsultar.isSelected()) {
            
            System.out.println(this.JTextFieldNombre.getText());
        } else {
            if (RadioButtonActualizar.isSelected()) {
                
                System.out.println(this.JTextFieldEpisodios.getText());
            } else {
                if (RadioButtonEliminar.isSelected()) {
                    
                    System.out.println(this.JTextFieldEpisodios.getText());
                } else {
                   if (RadioButtonInsertar.isSelected()) {
                    
                    System.out.println(this.JTextFieldEpisodios.getText());
                } else {
                   
                }
                }

            }
        }
    }
}
