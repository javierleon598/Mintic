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
public class pelicula {
    
    @Column(name="anno")
    Integer Annio;
    @Column(name="director_id")
    Integer directorId;
    @Column(name="resumen")
    String Resumen;
    @Id
    @Column(name = "contenido_id")
    Integer contenidoId;

    public pelicula(Integer Annio, Integer directorId, String Resumen, Integer contenidoId) {
        this.Annio = Annio;
        this.directorId = directorId;
        this.Resumen = Resumen;
        this.contenidoId = contenidoId;
    }
    public pelicula(){
    }
    public Integer getAnnio() {
        return Annio;
    }

    public void setAnnio(Integer Annio) {
        this.Annio = Annio;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
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
