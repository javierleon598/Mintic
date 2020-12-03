package com.example.JRedFlix.Repositorios;

import com.example.JRedFlix.modelos.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioPelicula extends JpaRepository<Pelicula, Integer>{
   
}
