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
public class serie {
    
    @Column(name="numero_episodios")
    String Episodios;
    @Column(name="numero_temporadas")
    String Temporadas;
    @Id
    @Column(name = "contenido_id")
    Integer contenidoId;

    public serie(String Episodios, String Temporadas, Integer contenidoId) {
        this.Episodios = Episodios;
        this.Temporadas = Temporadas;
        this.contenidoId = contenidoId;
    }
    
    public serie(){
    }
      

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

    public Integer getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Integer contenidoId) {
        this.contenidoId = contenidoId;
    }

   

    
    
    
}
