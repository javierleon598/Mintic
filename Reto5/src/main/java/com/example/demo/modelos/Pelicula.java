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
    Long Annio;
    @Column(name="director")
    String Director;
    @Column(name="resumen")
    String Resumen;
    @Column(name = "contenido_id")
    Long contenidoId;

    public Long getAnnio() {
        return Annio;
    }

    public void setAnnio(Long Annio) {
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

    public Long getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Long contenidoId) {
        this.contenidoId = contenidoId;
    }
    
    
           
}
