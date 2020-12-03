/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.vistas;


import com.example.demo.Repositorios.RepositorioContenido;
import com.example.demo.Repositorios.RepositorioSerie;
import com.example.demo.modelos.contenido;
import com.example.demo.modelos.director;
import com.example.demo.modelos.pelicula;
import com.example.demo.modelos.serie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
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
    JTextArea JTextAreaResultado;
    
    
    public ListenerAccionSerie(RepositorioContenido RepositorioContenido, RepositorioSerie RepositorioSerie,JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldEpisodios, JTextField JTextFieldTemporadas,JTextArea JTextAreaResultado ) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldEpisodios = JTextFieldEpisodios;
        this.JTextFieldTemporadas = JTextFieldTemporadas;
        this.RepositorioContenido = RepositorioContenido;
        this.RepositorioSerie = RepositorioSerie;
        this.JTextAreaResultado = JTextAreaResultado;
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
                    
                }
            }
            if(contenidoId != null){
                    Optional<serie> Resultado = RepositorioSerie.findById(contenidoId);
                    if (Resultado.isPresent()) {
                        serie serieEncontrada = Resultado.get();

                        JTextFieldEpisodios.setText(serieEncontrada.getEpisodios());
                        JTextFieldTemporadas.setText(serieEncontrada.getTemporadas());
                        JTextAreaResultado.setText("Encontrado");

                    } else {
                        JTextAreaResultado.setText("No encontrado");
                        JTextFieldEpisodios.setText("");
                        JTextFieldTemporadas.setText("");
                 
                    }

                }else{
                    JTextAreaResultado.setText("No encontrado");
                    JTextFieldEpisodios.setText("");
                    JTextFieldTemporadas.setText("");
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
                                Optional<serie> Resultado = RepositorioSerie.findById(contenidoId);
                                if (Resultado.isPresent()) {
                                    serie serieEncontrada = Resultado.get();

                                    String Episodios =this.JTextFieldEpisodios.getText();
                                    String Temporadas =this.JTextFieldTemporadas.getText();
                                   
                                    serieEncontrada.setEpisodios(Episodios);
                                    serieEncontrada.setTemporadas(Temporadas);      
                                    RepositorioSerie.save(serieEncontrada);
                                    try {
                                        RepositorioSerie.save(serieEncontrada);
                                    } catch (DataAccessException ex) {
                                        JTextAreaResultado.setText("Todos los campos son obligatorios");
                                    }
                                   
                                    JTextAreaResultado.setText("Se agregó una serie");


                                } else {
                                    JTextAreaResultado.setText("No encontrado");
                                    JTextFieldEpisodios.setText("");
                                    JTextFieldTemporadas.setText("");
                                    
                                }

                            }
                        }
            } else {
                if (RadioButtonEliminar.isSelected()) {
                    String Temporadas =this.JTextFieldTemporadas.getText();
                    String Episodios =this.JTextFieldEpisodios.getText();
              
                    
                    String Contenido =JTextFieldNombre.getText();
                    contenido c = new contenido();
                    c.setTitulo(Contenido);
                    RepositorioContenido.save(c);
                  
                    
                    serie s = new serie();
                    s.setContenidoId(c.getContenidoId());
                    s.setTemporadas(Temporadas);
                    s.setEpisodios(Episodios);
                      
                    RepositorioSerie.save(s);
                    JTextAreaResultado.setText("Se agregó una Serie");
                   
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
                            Optional<serie> Resultado = RepositorioSerie.findById(contenidoId);
                            if (Resultado.isPresent()) {
                                serie serieEncontrada = Resultado.get();

                                RepositorioContenido.deleteById(contenido.getContenidoId());
                                RepositorioSerie.deleteById(serieEncontrada.getContenidoId());
                                
                                JTextAreaResultado.setText("Eliminado");

                            } else {
                                JTextAreaResultado.setText("NO encontrado");
                                JTextFieldTemporadas.setText("");
                                JTextFieldEpisodios.setText("");
                               
                            }

                        }
                    }
                } else {
                   
                }
                }

            }
        }
    }
}
