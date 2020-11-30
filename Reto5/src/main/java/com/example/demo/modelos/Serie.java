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
@Table(name = "serie")
public class Serie {
    @Id
    @Column(name="numero_episodios")
    String Episodios;
    @Column(name="numero_temporadas")
    String Temporadas;
    @Column(name = "contenido_id")
    Long contenidoId;

   

    public String getEpisodios() {
        return Episodios;
    }

    public void setEpisodios(String Episodios) {
        this.Episodios = Episodios;
    }

    public String getTemporadas() {
        return Temporadas;
    }

    public void setTemporadas(String Temporadas) {
        this.Temporadas = Temporadas;
    }

    public Long getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Long contenidoId) {
        this.contenidoId = contenidoId;
    }
    
    
}
