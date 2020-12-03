package com.example.JRedFlix.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "director")
public class Director {

    @Id
    @Column(name = "director_id")
    Integer directorId;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido")
    String apellido;
    @Column(name = "nacionalidad")
    String nacionalidad;

    public Director(String nombre, String apellido, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
    }        

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer DirectorId) {
        this.directorId = DirectorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.nacionalidad = Nacionalidad;
    }

}
