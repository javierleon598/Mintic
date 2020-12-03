package com.example.JRedFlix.vistas;

import com.example.JRedFlix.Repositorios.RepositorioSerie;
import com.example.JRedFlix.modelos.Serie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

class ListenerAccionSerie implements ActionListener {

    RepositorioSerie RepositorioSerie;
    JRadioButton RadioButtonConsultar;
    JRadioButton RadioButtonActualizar;
    JRadioButton RadioButtonEliminar;
    JRadioButton RadioButtonInsertar;
    JTextField JTextFieldNombre;
    JTextField JTextFieldEpisodios;
    JTextField JTextFieldTemporadas;
    JTextArea jTextAreaResultado;

    public ListenerAccionSerie(JTextArea jTextAreaResultado, RepositorioSerie RepositorioSerie, JRadioButton RadioButtonConsultar, JRadioButton RadioButtonActualizar, JRadioButton RadioButtonEliminar, JRadioButton RadioButtonInsertar, JTextField JTextFieldNombre, JTextField JTextFieldEpisodios, JTextField JTextFieldTemporadas) {
        this.RadioButtonConsultar = RadioButtonConsultar;
        this.RadioButtonActualizar = RadioButtonActualizar;
        this.RadioButtonEliminar = RadioButtonEliminar;
        this.RadioButtonInsertar = RadioButtonInsertar;
        this.JTextFieldNombre = JTextFieldNombre;
        this.JTextFieldEpisodios = JTextFieldEpisodios;
        this.JTextFieldTemporadas = JTextFieldTemporadas;
        this.RepositorioSerie = RepositorioSerie;
        this.jTextAreaResultado = jTextAreaResultado;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        //**********************************************************************SELECT
        if (RadioButtonConsultar.isSelected()) {
            System.out.println("consultar");
            String titulo = this.JTextFieldNombre.getText();
            if (titulo == null || titulo.equals("")) {
                System.out.println("Se consulta por nombre");
                jTextAreaResultado.setText("Se consulta por nombre");
            } else {
                System.out.println(titulo);
                Integer serieId = null;
                List<Serie> series = RepositorioSerie.findAll();
                for (int i = 0; i < series.size(); i++) {
                    Serie serie = series.get(i);
                    if (serie.getTitulo().equals(titulo)) {
                        serieId = serie.getSerieId();
                        Optional<Serie> Resultado = RepositorioSerie.findById(serieId);
                        if (Resultado.isPresent()) {
                            Serie serieEncontrada = Resultado.get();
                            Integer seriId = serieEncontrada.getSerieId();
                            JTextFieldTemporadas.setText(Integer.toString(serieEncontrada.getTemporadas()));
                            JTextFieldEpisodios.setText(Integer.toString(serieEncontrada.getEpisodios()));
                            System.out.println("encontrado");
                            jTextAreaResultado.setText("Encontrado");
                        } else {
                            System.out.println("NO encontrado");
                            jTextAreaResultado.setText("No Encontrado");
                            JTextFieldTemporadas.setText("");
                            JTextFieldEpisodios.setText("");
                        }
                        i = series.size();
                    }
                }
                if (serieId == null) {
                    System.out.println("NO encontrado");
                    jTextAreaResultado.setText("No Encontrado");
                    JTextFieldTemporadas.setText("");
                    JTextFieldEpisodios.setText("");
                }
            }
        }
        //**********************************************************************INSERT
        if (RadioButtonInsertar.isSelected()) {
            System.out.println("insertar");
            String titulo;
            Integer episodios;
            Integer temporadas;
            try {
                titulo = this.JTextFieldNombre.getText();
                episodios = Integer.parseInt(this.JTextFieldEpisodios.getText());
                temporadas = Integer.parseInt(this.JTextFieldTemporadas.getText());
                if (titulo == null || episodios == null || temporadas == null) {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                } else {
                    System.out.println(titulo);
                    System.out.println(episodios);
                    System.out.println(temporadas);
                    int serieId = ((int) (this.RepositorioSerie.count())) + 1;
                    Serie serie = new Serie(serieId, titulo, temporadas, episodios);
                    RepositorioSerie.save(serie);
                    System.out.println("Se agregó una serie");
                    jTextAreaResultado.setText("Se agregó una serie");
                }
            } catch (Exception e) {
                if (!this.JTextFieldEpisodios.getText().equals("") || !this.JTextFieldTemporadas.getText().equals("")) {
                    System.out.println("Los campos Episodios y Temporas deben ser numeros");
                    jTextAreaResultado.setText("Los campos Episodios y Temporas deben ser numeros");
                } else {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                }
            }
        }
        //**********************************************************************UPDATE
        if (RadioButtonActualizar.isSelected()) {
            System.out.println("actualizar");
            String titulo;
            Integer episodios;
            Integer temporadas;
            try {
                titulo = this.JTextFieldNombre.getText();
                episodios = Integer.parseInt(this.JTextFieldEpisodios.getText());
                temporadas = Integer.parseInt(this.JTextFieldTemporadas.getText());
                if (titulo == null || episodios == null || temporadas == null) {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                } else {
                    System.out.println(titulo);
                    Integer serieId = null;
                    List<Serie> series = RepositorioSerie.findAll();
                    System.out.println(series.size());
                    for (int i = 0; i < series.size(); i++) {
                        Serie serie = series.get(i);
                        if (serie.getTitulo().equals(titulo)) {
                            serieId = serie.getSerieId();
                            Optional<Serie> Resultado = RepositorioSerie.findById(serieId);
                            if (Resultado.isPresent()) {
                                Serie serieEncontrada = Resultado.get();
                                Serie serieActualizada = new Serie(serieEncontrada.getSerieId(), titulo, temporadas, episodios);
                                RepositorioSerie.save(serieActualizada);
                                System.out.println("Serie Actualizada");
                                jTextAreaResultado.setText("Serie Actualizada");
                                break;
                            } else {
                                System.out.println("No se encontro serie para actualizar");
                                jTextAreaResultado.setText("No se encontro serie para actualizar");
                            }
                        }
                    }
                    if (serieId == null) {
                        System.out.println("No se encontro serie para actualizar");
                        jTextAreaResultado.setText("No se encontro serie para actualizar");
                    }
                }
            } catch (Exception e) {
                if (!this.JTextFieldEpisodios.getText().equals("") || !this.JTextFieldTemporadas.getText().equals("")) {
                    System.out.println("Los campos Episodios y Temporas deben ser numeros");
                    jTextAreaResultado.setText("Los campos Episodios y Temporas deben ser numeros");
                } else {
                    System.out.println("Llene todos los campos");
                    jTextAreaResultado.setText("Llene todos los campos");
                }
            }

        }
        //**********************************************************************DELETE
        if (RadioButtonEliminar.isSelected()) {
            System.out.println("eliminar");
            String titulo = this.JTextFieldNombre.getText();
            if (titulo == null || titulo.equals("")) {
                System.out.println("Se elimina por título");
                jTextAreaResultado.setText("Se elimina por título");
            } else {
                System.out.println(titulo);
                Integer serieId = null;
                List<Serie> series = RepositorioSerie.findAll();
                System.out.println(series.size());
                for (int i = 0; i < series.size(); i++) {
                    Serie serie = series.get(i);
                    if (serie.getTitulo().equals(titulo)) {
                        serieId = serie.getSerieId();
                        RepositorioSerie.deleteById(serieId);
                        JTextFieldTemporadas.setText("");
                        JTextFieldEpisodios.setText("");
                        JTextFieldNombre.setText("");
                        System.out.println("Serie Eliminada");
                        jTextAreaResultado.setText("Serie Eliminada");
                        break;
                    }
                }
                if (serieId == null) {
                    System.out.println("No se encontro serie para eliminar");
                    jTextAreaResultado.setText("No se encontro serie para eliminar");
                }
            }
        }
        //*************************************************************************
    }

}
