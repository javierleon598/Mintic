/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repositorios;

import com.example.demo.modelos.contenido;
import com.example.demo.modelos.director;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author olgat
 */
public interface RepositorioDirector extends JpaRepository<director, Integer> {
    
}
