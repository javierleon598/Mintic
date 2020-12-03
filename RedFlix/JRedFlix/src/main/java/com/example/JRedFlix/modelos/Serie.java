package com.example.JRedFlix.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @Column(name = "serie_id")
    Integer serieId;
    @Column(name="titulo")
    String titulo;
    @Column(name="numero_temporadas")
    Integer temporadas;
    @Column(name="numero_episodios")
    Integer episodios;
        
    public Serie(){
    }
    
    public Serie(String titulo) {
        this.titulo = titulo;
    }

    public Serie(Integer serieId, String titulo, Integer temporadas, Integer episodios) {
        this.serieId = serieId;
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public Integer getSerieId() {
        return serieId;
    }

    public void setSerieId(Integer serieId) {
        this.serieId = serieId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Integer episodios) {
        this.episodios = episodios;
    }
       
}
