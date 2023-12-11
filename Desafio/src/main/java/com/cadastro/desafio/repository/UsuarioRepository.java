package com.cadastro.desafio.repository;

import com.cadastro.desafio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findById(long id);
}