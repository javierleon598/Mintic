/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import com.example.demo.modelos.Pelicula;
import com.example.demo.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author olgat
 */
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
    
}
