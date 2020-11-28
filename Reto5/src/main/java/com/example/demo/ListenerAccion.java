/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author olgat
 */
class ListenerAccion implements ActionListener{

    
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldDirector;
    JTextField JTextFieldAnio;
    JTextField JTextFieldResumen;
    
    public ListenerAccion(JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldDirector, JTextField JTextFieldAnio, JTextField JTextFieldResumen ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldDirector = JTextFieldDirector;
        this.JTextFieldAnio = JTextFieldAnio;
        this.JTextFieldResumen = JTextFieldResumen;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
   
        if (RadioButtonConsultar.isSelected()) {
            
            System.out.println(this.JTextFieldNombre.getText());
        } else {
            if (RadioButtonActualizar.isSelected()) {
                
                System.out.println(this.JTextFieldDirector.getText());
            } else {
                if (RadioButtonEliminar.isSelected()) {
                    
                    System.out.println(this.JTextFieldAnio.getText());
                } else {
                    if (RadioButtonInsertar.isSelected()) {
                        
                        System.out.println(this.JTextFieldResumen.getText());
                    } else {

                    }
                }

            }
        }
    }
    
    
}
