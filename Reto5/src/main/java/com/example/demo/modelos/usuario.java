/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.type.DateType;

/**
 *
 * @author olgat
 */
@Entity
@Table(name = "usuario")
public class usuario {
    @Id
    @Column(name="nombre")
    String Nombre;
    @Column(name="apellido")
    String Apellido;
    @Column(name="fecha_nacimiento")
    Date FechaNacimiento;
    @Column(name="celular")
    String Celular;
    @Column(name="email")
    String email;
    @Column(name="usuario")
    String Usuario;
    @Column(name="contrasena")
    String Contrasena;

    public usuario(String Nombre, String Apellido, Date FechaNacimiento, String Celular, String email, String Usuario, String Contrasena) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaNacimiento = FechaNacimiento;
        this.Celular = Celular;
        this.email = email;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }
    
    public usuario(){
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

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    
}
