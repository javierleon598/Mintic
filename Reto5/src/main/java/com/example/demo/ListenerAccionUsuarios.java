/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author olgat
 */
class ListenerAccionUsuarios implements ActionListener{
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldApellido;
    JTextField JTextFieldEmail;
    JTextField JTextFieldUsuario;
    
    public ListenerAccionUsuarios(JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldApellido, JTextField JTextFieldEmail, JTextField JTextFieldUsuario ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldApellido = JTextFieldApellido;
        this.JTextFieldEmail = JTextFieldEmail;
        this.JTextFieldUsuario = JTextFieldUsuario;
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
   
        if (RadioButtonConsultar.isSelected()) {
            
            System.out.println(this.JTextFieldNombre.getText());
        } else {
            if (RadioButtonActualizar.isSelected()) {
                
                System.out.println(this.JTextFieldApellido.getText());
            } else {
                if (RadioButtonEliminar.isSelected()) {
                    
                    System.out.println(this.JTextFieldEmail.getText());
                } else {
                   if (RadioButtonInsertar.isSelected()) {
                    
                    System.out.println(this.JTextFieldUsuario.getText());
                } else {
                   
                }
                }

            }
        }
    }
}
