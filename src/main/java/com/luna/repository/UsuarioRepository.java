package com.luna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luna.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Usuario findByEmailAndSenha(String email, String senha);
}
