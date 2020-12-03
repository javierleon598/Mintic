package com.example.JRedFlix.Repositorios;

import com.example.JRedFlix.modelos.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDirector extends JpaRepository<Director, Integer> {
    
}
