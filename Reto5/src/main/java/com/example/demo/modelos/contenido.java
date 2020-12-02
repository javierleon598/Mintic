/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author olgat
 */
@Entity
@Table(name = "contenido")
public class contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contenido_id")
    Integer ContenidoId;
    @Column(name="titulo")
    String Titulo;

    public contenido(Integer ContenidoId, String Titulo) {
        this.ContenidoId = ContenidoId;
        this.Titulo = Titulo;
    }
    
    public contenido(){
    }

    public Integer getContenidoId() {
        return ContenidoId;
    }

    public void setContenidoId(Integer ContenidoId) {
        this.ContenidoId = ContenidoId;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    

   

    
}
