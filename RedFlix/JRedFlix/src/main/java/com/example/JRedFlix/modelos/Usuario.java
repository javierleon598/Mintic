package com.example.JRedFlix.modelos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name="usuario")
    String usuario;
    @Column(name="nombre")
    String nombre;
    @Column(name="apellido")
    String apellido;
    @Column(name="email")
    String email;
    @Column(name="celular")
    String celular;     
    @Column(name="contrasena")
    String contrasena;
    @Column(name="fecha_nacimiento")
    Date fechaNacimiento;
    
    public Usuario(){
    }

    public Usuario(String usuario, String nombre, String apellido, String email, String celular, String contrasena, Date fechaNacimiento) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
