/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.vistas;


import com.example.demo.Repositorios.RepositorioContenido;
import com.example.demo.Repositorios.RepositorioSerie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @author olgat
 */

class ListenerAccionSerie implements ActionListener{
    
    RepositorioSerie RepositorioSerie;
    RepositorioContenido RepositorioContenido;
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldEpisodios;
    JTextField JTextFieldTemporadas;
    
    
    public ListenerAccionSerie(RepositorioContenido RepositorioContenido, RepositorioSerie RepositorioSerie,JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldEpisodios, JTextField JTextFieldTemporadas ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldEpisodios = JTextFieldEpisodios;
        this.JTextFieldTemporadas = JTextFieldTemporadas;
        this.RepositorioContenido = RepositorioContenido;
        this.RepositorioSerie = RepositorioSerie;
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
