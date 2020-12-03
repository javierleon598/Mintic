package com.example.JRedFlix.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {    
    @Id
    @Column(name = "pelicula_id")
    Integer peliculaId;
    @Column(name="titulo")
    String titulo;
    @Column(name="resumen")
    String resumen;
    @Column(name="anio")
    Integer anio;
    @Column(name="nombre_director")
    String nombreDirector;
    
    public Pelicula(){
    }

    public Pelicula(Integer peliculaId, String titulo, String resumen, Integer anio, String nombreDirector) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.resumen = resumen;
        this.anio = anio;
        this.nombreDirector = nombreDirector;
    }
    
    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    
    
}
