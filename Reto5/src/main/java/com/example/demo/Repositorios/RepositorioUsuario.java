/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.demo.Repositorios;
import com.example.demo.modelos.pelicula;
import com.example.demo.modelos.usuario;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author olgat
 */

public interface RepositorioUsuario extends JpaRepository<usuario, String> {
    
}
