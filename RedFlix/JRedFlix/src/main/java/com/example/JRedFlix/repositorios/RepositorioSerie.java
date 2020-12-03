package com.example.JRedFlix.Repositorios;

import com.example.JRedFlix.modelos.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioSerie extends JpaRepository<Serie, Integer> {
    
}
