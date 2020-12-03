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
import com.example.demo.modelos.contenido;
import com.example.demo.modelos.director;
import com.example.demo.modelos.pelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.RadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
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
    RepositorioDirector RepositorioDirector;
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldDirector;
    JTextField JTextFieldAnio;
    JTextArea JTextAreaResumen;
    JTextField JTextFieldDirectorNacionalidad;
    JTextArea JTextAreaResultado;
    
    
    
    
    public ListenerAccionPelicula(JTextArea JTextAreaResultado,RepositorioDirector RepositorioDirector, RepositorioContenido RepositorioContenido,RepositorioPelicula RepositorioPelicula, JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldDirector, JTextField JTextFieldAnio, JTextArea JTextAreaResumen, JTextField JTextFieldDirectorNacionalidad ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldDirector = JTextFieldDirector;
        this.JTextFieldAnio = JTextFieldAnio;
        this.JTextAreaResumen = JTextAreaResumen;
        this.RepositorioContenido = RepositorioContenido;
        this.RepositorioPelicula = RepositorioPelicula;
        this.RepositorioDirector = RepositorioDirector;
        this.JTextFieldDirectorNacionalidad = JTextFieldDirectorNacionalidad;
        this.JTextAreaResultado =JTextAreaResultado;
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
                    i = contenidos.size();
                    Optional<pelicula> Resultado = RepositorioPelicula.findById(contenidoId);
                    if (Resultado.isPresent()) {
                        pelicula peliculaEncontrada = Resultado.get();

                        JTextFieldAnio.setText(Integer.toString(peliculaEncontrada.getAnnio()));
                        JTextAreaResumen.setText(peliculaEncontrada.getResumen());
                        JTextAreaResultado.setText("Encontrado");
                        Integer DirectorId = peliculaEncontrada.getDirectorId();
                        

                        director directorEncontrado = RepositorioDirector.findById(DirectorId).get();
                        JTextFieldDirector.setText(directorEncontrado.getNombre() + " " + directorEncontrado.getApellido());
                        JTextFieldDirectorNacionalidad.setText(directorEncontrado.getNacionalidad());

                    } else {
                        JTextAreaResultado.setText("No encontrado");
                        JTextFieldDirector.setText("");
                        JTextFieldAnio.setText("");
                        JTextAreaResumen.setText("");
                    }

                }
            }
        } else {
            if (RadioButtonActualizar.isSelected()) {
                
                String Titulo = this.JTextFieldNombre.getText();

                        Integer contenidoId = null;
                        List<contenido> contenidos = RepositorioContenido.findAll();
                        for (int i = 0; i < contenidos.size(); i++) {

                            contenido contenido = contenidos.get(i);
                            if (contenido.getTitulo().equals(Titulo)) {
                                contenidoId = contenido.getContenidoId();
                                System.out.println(contenidoId);
                                i = contenidos.size();
                                Optional<pelicula> Resultado = RepositorioPelicula.findById(contenidoId);
                                if (Resultado.isPresent()) {
                                    pelicula peliculaEncontrada = Resultado.get();

                                    Integer Anio =Integer.parseInt(this.JTextFieldAnio.getText());
                                    String Resumen =JTextAreaResumen.getText();
                                   
                                    peliculaEncontrada.setAnnio(Anio);
                                    peliculaEncontrada.setResumen(Resumen);      
                                    RepositorioPelicula.save(peliculaEncontrada);
                                    JTextAreaResultado.setText("Se agregó una pelicula");

                                    Integer DirectorId = peliculaEncontrada.getDirectorId();
                                    System.out.println(peliculaEncontrada.getDirectorId());
                                    
                                    String Director =this.JTextFieldDirector.getText();
                                    String NacionalidadDirector =this.JTextFieldDirectorNacionalidad.getText();
                                    String NombreDirector  = Director.split(" ")[0];
                                    String ApellidoDirector = Director.split(" ")[1];
                                   
                                    director directorEncontrado = RepositorioDirector.findById(DirectorId).get();
                                    director d = new director();
                                    directorEncontrado.setApellido(ApellidoDirector);
                                    directorEncontrado.setNombre(NombreDirector);
                                    directorEncontrado.setNacionalidad(NacionalidadDirector);
                                    RepositorioDirector.save(directorEncontrado);
                                    

                                } else {
                                    JTextAreaResultado.setText("No encontrado");
                                    JTextFieldDirector.setText("");
                                    JTextFieldAnio.setText("");
                                    JTextAreaResumen.setText("");
                                }

                            }
                        }
            } else {
                if (RadioButtonInsertar.isSelected()) {
                    
                    
                    String Titulo = JTextFieldNombre.getText();
                    System.out.println(Titulo);
                    Integer contenidoId = null;
                    List<contenido> contenidos = RepositorioContenido.findAll();
                    for (int i = 0; i < contenidos.size(); i++) {

                        contenido contenido = contenidos.get(i);
                        if (contenido.getTitulo().equals(Titulo)) {
                            contenidoId = contenido.getContenidoId();
                             System.out.println(contenidoId);
                            i = contenidos.size();
                            Optional<pelicula> Resultado = RepositorioPelicula.findById(contenidoId);
                            if (Resultado.isPresent()) {
                                pelicula peliculaEncontrada = Resultado.get();

                                RepositorioPelicula.deleteById(peliculaEncontrada.getContenidoId());
                                RepositorioContenido.deleteById(contenido.getContenidoId());
                                JTextAreaResultado.setText("Eliminado");

                            } else {
                                JTextAreaResultado.setText("No encontrado");
                                JTextFieldDirector.setText("");
                                JTextFieldAnio.setText("");
                                JTextAreaResumen.setText("");
                            }

                        }
                    }
                } else {
                   if (RadioButtonEliminar.isSelected()){
                       
                    
                    String Director =this.JTextFieldDirector.getText();
                    String NacionalidadDirector =this.JTextFieldDirectorNacionalidad.getText();
                    String NombreDirector  = Director.split(" ")[0];
                    String ApellidoDirector = Director.split(" ")[1];
                    
                    director d = new director();
                    d.setApellido(ApellidoDirector);
                    d.setNombre(NombreDirector);
                    d.setNacionalidad(NacionalidadDirector);
                    RepositorioDirector.save(d);
                    
                    String Contenido =JTextFieldNombre.getText();
                    contenido c = new contenido();
                    c.setTitulo(Contenido);
                    RepositorioContenido.save(c);
                  
                    Integer Anio =Integer.parseInt(this.JTextFieldAnio.getText());
                    String Resumen =JTextAreaResumen.getText();
                    pelicula p = new pelicula();
                    p.setContenidoId(c.getContenidoId());
                    p.setDirectorId(d.getDirectorId());
                    p.setAnnio(Anio);
                    p.setResumen(Resumen);      
                    RepositorioPelicula.save(p);
                    JTextAreaResultado.setText("Se agregó una pelicula");
                    
                } else {
                   JTextAreaResultado.setText("Todos los campos son obligatorios ");
                }
                }

            }
        }
    }     
    
}
