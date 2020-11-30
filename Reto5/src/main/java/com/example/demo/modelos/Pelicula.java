/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author olgat
 */
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @Column(name="annio")
    Integer Annio;
    @Column(name="director")
    String Director;
    @Column(name="resumen")
    String Resumen;
    @Column(name = "contenido_id")
    Integer contenidoId;

    public Pelicula(Integer Annio, String Director, String Resumen, Integer contenidoId) {
        this.Annio = Annio;
        this.Director = Director;
        this.Resumen = Resumen;
        this.contenidoId = contenidoId;
    }
    public Pelicula(){
    }
    public Integer getAnnio() {
        return Annio;
    }

    public void setAnnio(Integer Annio) {
        this.Annio = Annio;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getResumen() {
        return Resumen;
    }

    public void setResumen(String Resumen) {
        this.Resumen = Resumen;
    }

    public Integer getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Integer contenidoId) {
        this.contenidoId = contenidoId;
    }

    
    
    
           
}
