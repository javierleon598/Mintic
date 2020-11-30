/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.vistas;


import com.example.demo.Repositorios.RepositorioContenido;
import com.example.demo.Repositorios.RepositorioPelicula;
import com.example.demo.SpringContext;
import com.example.demo.modelos.contenido;
import com.example.demo.modelos.pelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 *
 * @author olgat
 */

class ListenerAccionPelicula implements ActionListener{

    
    RepositorioContenido RepositorioContenido;
    RepositorioPelicula RepositorioPelicula;
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldDirector;
    JTextField JTextFieldAnio;
    JTextField JTextFieldResumen;
    
    
    
    
    public ListenerAccionPelicula(RepositorioContenido RepositorioContenido,RepositorioPelicula RepositorioPelicula, JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldDirector, JTextField JTextFieldAnio, JTextField JTextFieldResumen ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldDirector = JTextFieldDirector;
        this.JTextFieldAnio = JTextFieldAnio;
        this.JTextFieldResumen = JTextFieldResumen;
        this.RepositorioContenido = RepositorioContenido;
        this.RepositorioPelicula = RepositorioPelicula;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
       
        if (RadioButtonConsultar.isSelected()) {
            
           String Titulo = this.JTextFieldNombre.getText();
            
            
            Integer contenidoId = null;
            List<contenido> contenidos = RepositorioContenido.findAll();
            for(int i =0; i< contenidos.size(); i++){
                
                contenido contenido = contenidos.get(i);
                if(contenido.getTitulo().equals(Titulo)){
                    contenidoId = contenido.getContenidoId();
                    System.out.println(contenidoId);
                    break;
                }
            }
            Optional<pelicula> Resultado = RepositorioPelicula.findById(2);
            if (Resultado.isPresent()){
                pelicula peliculaEncontrada = Resultado.get();
                Integer ContenidoId = peliculaEncontrada.getContenidoId();
                JTextFieldAnio.setText(Integer.toString(peliculaEncontrada.getAnnio()));
                JTextFieldResumen.setText(peliculaEncontrada.getResumen());
               System.out.println("encontrado");
            }else{
                System.out.println("NO encontrado");
                JTextFieldDirector.setText("");
                JTextFieldAnio.setText("");
                JTextFieldNombre.setText("");
            }
                    
                    
            System.out.println(this.JTextFieldNombre.getText());
        } else {
            if (RadioButtonActualizar.isSelected()) {
                
                String Director =this.JTextFieldDirector.getText();
                    Integer Anio =Integer.parseInt(this.JTextFieldAnio.getText());
                    String Resumen =this.JTextFieldResumen.getText();
                    pelicula p = new pelicula();
                   // p.setdirectorId(directorId);
                    p.setAnnio(Anio);
                    p.setResumen(Resumen);
                    RepositorioPelicula.save(p);
                    System.out.println("Se agregó una pelicula");
            } else {
                if (RadioButtonEliminar.isSelected()) {
                      String Titulo = this.JTextFieldNombre.getText();
                      Integer contenidoId = null;
                        Optional<contenido> Resultado = RepositorioContenido.findById(contenidoId);
                    if (Resultado.isPresent()) {
                        contenido ContenidoEncontrado = Resultado.get();
                        Integer ContenidoId = ContenidoEncontrado.getContenidoId();
                        RepositorioPelicula.deleteById(ContenidoId);
                    } else {
                System.out.println("NO encontrado");
                JTextFieldDirector.setText("");
                JTextFieldAnio.setText("");
                JTextFieldNombre.setText("");
            }
                    
                } else {
                    if (RadioButtonInsertar.isSelected()) {
                        
                        String Director =this.JTextFieldDirector.getText();
                        Integer Anio =Integer.parseInt(this.JTextFieldAnio.getText());
                        String Resumen =this.JTextFieldResumen.getText();
                        pelicula p = new pelicula();
                       // p.setDirector(Director);
                        p.setAnnio(Anio);
                        p.setResumen(Resumen);
                        RepositorioPelicula.save(p);
                        System.out.println("Se agregó una pelicula");
                        
                        System.out.println(this.JTextFieldResumen.getText());
                    } else {

                    }
                }

            }
        }
    }
    
    
}
