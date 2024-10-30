package com.luna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luna.model.Candidatura;


public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer>{
    List<Candidatura> findByArtista_id(Integer artistaId);

    List<Candidatura> findByVaga_Empresa_Id(Integer usuarioId);

    @Query("SELECT COUNT(c) > 0 FROM Candidatura c WHERE c.vaga.id = :vagaId AND c.artista.id = :artistaId")
    boolean existsByVagaAndArtista(@Param("vagaId") Integer vagaId, @Param("artistaId") Integer artistaId);
}
