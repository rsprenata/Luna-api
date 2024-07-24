package com.luna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luna.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Integer>{
    
}
