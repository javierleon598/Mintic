package com.example.JRedFlix.Repositorios;

import com.example.JRedFlix.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
    
}
