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
 @Table(name = "director")
public class director {

        @Id
        @Column(name = "director_id")
        Integer DirectorId;
        @Column(name = "nombre")
        String Nombre;

    public Integer getDirectorId() {
        return DirectorId;
    }

    public void setDirectorId(Integer DirectorId) {
        this.DirectorId = DirectorId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }
        @Column(name = "apellido")
        String Apellido;
        @Column(name = "nacionalidad")
        String Nacionalidad;
   
}
