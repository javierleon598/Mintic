package com.example.JRedFlix.vistas;

import com.example.JRedFlix.Repositorios.RepositorioPelicula;
import com.example.JRedFlix.modelos.Pelicula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ListenerAccionPelicula implements ActionListener {

    RepositorioPelicula repositorioPelicula;
    //RepositorioDirector repositorioDirector;
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldDirector;
    JTextField JTextFieldAnio;
    JTextArea JTextFieldResumen;
    JTextArea jTextAreaResultado;

    public ListenerAccionPelicula(RepositorioPelicula repositorioPelicula, JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldDirector, JTextField JTextFieldAnio, JTextArea JTextFieldResumen, JTextArea jTextAreaResultado) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldDirector = JTextFieldDirector;
        this.JTextFieldAnio = JTextFieldAnio;
        this.JTextFieldResumen = JTextFieldResumen;
        this.repositorioPelicula = repositorioPelicula;
        this.jTextAreaResultado = jTextAreaResultado;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //**********************************************************************SELECT
        if (RadioButtonConsultar.isSelected()) {
            System.out.println("consultar");
            String nombre = this.JTextFieldNombre.getText();
            System.out.println(nombre);
            if (nombre.equals("")) {
                System.out.println("Se consulta por nombre");
                jTextAreaResultado.setText("Se consulta por nombre");
            } else {
                Integer peliculaId = null;
                List<Pelicula> peliculas = repositorioPelicula.findAll();
                for (int i = 0; i < peliculas.size(); i++) {
                    Pelicula pelicula = peliculas.get(i);
                    if (pelicula.getTitulo().equals(nombre)) {
                        peliculaId = pelicula.getPeliculaId();
                        Optional<Pelicula> resultado = repositorioPelicula.findById(peliculaId);
                        if (resultado.isPresent()) {
                            Pelicula peliculaEncontrada = resultado.get();
                            Integer peliculId = peliculaEncontrada.getPeliculaId();
                            JTextFieldDirector.setText((peliculaEncontrada.getNombreDirector()));
                            JTextFieldResumen.setText((peliculaEncontrada.getResumen()));
                            JTextFieldAnio.setText(Integer.toString(peliculaEncontrada.getAnio()));
                            System.out.println("encontrado");
                            jTextAreaResultado.setText("Encontrado");
                        } else {
                            System.out.println("NO encontrado");
                            jTextAreaResultado.setText("No Encontrado");
                            JTextFieldDirector.setText("");
                            JTextFieldResumen.setText("");
                            JTextFieldAnio.setText("");
                        }
                        //i = peliculas.size();
                    }
                }
                if (peliculaId == null) {
                    System.out.println("NO encontrado");
                    jTextAreaResultado.setText("No Encontrado");
                    JTextFieldDirector.setText("");
                    JTextFieldResumen.setText("");
                    JTextFieldAnio.setText("");
                }

            }
        }
        //**********************************************************************INSERT
        if (RadioButtonInsertar.isSelected()) {
            System.out.println("insertar");
            String nombre;
            String director;
            String resumen;
            Integer annio;
            try {
                nombre = this.JTextFieldNombre.getText();
                director = this.JTextFieldDirector.getText();
                resumen = this.JTextFieldResumen.getText();
                annio = Integer.parseInt(this.JTextFieldAnio.getText());
                if (nombre.equals("") || director.equals("") || resumen.equals("") || annio.equals("")
                        || nombre == null || director == null || resumen == null || annio == null) {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                } else {
                    int peliculaId = ((int) (this.repositorioPelicula.count())) + 1;
                    Pelicula pelicula = new Pelicula(peliculaId, nombre, resumen, annio, director);
                    repositorioPelicula.save(pelicula);
                    System.out.println("Se agregó una pelicula");
                    jTextAreaResultado.setText("Se agregó una pelicula");
                }
            } catch (Exception e) {
                if (!this.JTextFieldAnio.getText().equals("")) {
                    System.out.println("El campo año deben ser un numero");
                    jTextAreaResultado.setText("El campo año deben ser un numero");
                } else {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                }

            }
        }
        //**********************************************************************UPDATE
        if (RadioButtonActualizar.isSelected()) {
            System.out.println("actualizar");
            String nombre;
            String director;
            String resumen;
            Integer annio;
            try {
                nombre = this.JTextFieldNombre.getText();
                director = this.JTextFieldDirector.getText();
                resumen = this.JTextFieldResumen.getText();
                annio = Integer.parseInt(this.JTextFieldAnio.getText());
                if (nombre.equals("") || director.equals("") || resumen.equals("") || annio.equals("")) {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                } else {
                    Integer peliculaId = null;
                    List<Pelicula> peliculas = repositorioPelicula.findAll();
                    System.out.println(peliculas.size());
                    for (int i = 0; i < peliculas.size(); i++) {
                        Pelicula pelicula = peliculas.get(i);
                        if (pelicula.getTitulo().equals(nombre)) {
                            int peliculId = pelicula.getPeliculaId();
                            Optional<Pelicula> resultado = repositorioPelicula.findById(peliculId);
                            if (resultado.isPresent()) {
                                Pelicula peliculaEncontrada = resultado.get();
                                peliculaId = pelicula.getPeliculaId();
                                Pelicula peliculaActualizada = new Pelicula(peliculaEncontrada.getPeliculaId(), nombre, resumen, annio, director);
                                repositorioPelicula.save(peliculaActualizada);
                                System.out.println("Serie Actualizada");
                                jTextAreaResultado.setText("Serie Actualizada");
                                break;
                            } else {
                                System.out.println("No se encontro pelicula para actualizar");
                                jTextAreaResultado.setText("No se encontro pelicula para actualizar");
                            }
                        }
                    }
                    if (peliculaId == null) {
                        if (!this.JTextFieldAnio.getText().equals("")) {
                            System.out.println("El campo año deben ser un numero");
                            jTextAreaResultado.setText("El campo año deben ser un numero");
                        } else {
                            System.out.println("Llene todos los campos");
                            jTextAreaResultado.setText("Llene todos los campos");
                        }
                    }
                }
            } catch (Exception e) {
                if (!this.JTextFieldAnio.getText().equals("")) {
                    System.out.println("El campo año deben ser un numero");
                    jTextAreaResultado.setText("El campo año deben ser un numero");
                } else {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                }
            }
        }
        //**********************************************************************DELETE
        if (RadioButtonEliminar.isSelected()) {
            System.out.println("eliminar");
            String nombre = this.JTextFieldNombre.getText();
            if (nombre.equals("")) {
                System.out.println("Se elimina por nombre");
                jTextAreaResultado.setText("Se elimina por nombre");
            } else {
                System.out.println(nombre);
                Integer peliculaId = null;
                List<Pelicula> peliculas = repositorioPelicula.findAll();
                System.out.println(peliculas.size());
                for (int i = 0; i < peliculas.size(); i++) {
                    Pelicula pelicula = peliculas.get(i);
                    if (pelicula.getTitulo().equals(nombre)) {
                        peliculaId = pelicula.getPeliculaId();
                        repositorioPelicula.deleteById(peliculaId);
                        JTextFieldDirector.setText("");
                        JTextFieldResumen.setText("");
                        JTextFieldAnio.setText("");
                        JTextFieldNombre.setText("");
                        System.out.println("Pelicula Eliminada");
                        jTextAreaResultado.setText("Pelicula Eliminada");
                        break;
                    }
                }
                if (peliculaId == null) {
                    System.out.println("No se encontro pelicula para eliminar");
                    jTextAreaResultado.setText("No se encontro pelicula para eliminar");
                }
            }
        }
        //*************************************************************************
    }

}
