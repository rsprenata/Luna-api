package com.luna.repository;

import com.luna.model.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer>{
    List<Candidatura> findByArtista_id(Integer artistaId);
}
