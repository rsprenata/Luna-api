package com.luna.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luna.model.Candidatura;
import com.luna.model.Status;


public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer>{
    List<Candidatura> findByArtista_id(Integer artistaId, Sort sort);

    List<Candidatura> findByVaga_Empresa_Id(Integer usuarioId);

    List<Candidatura> findByVaga_Id(Integer vagaId, Sort sort);

    @Query("SELECT COUNT(c) > 0 FROM Candidatura c WHERE c.vaga.id = :vagaId AND c.artista.id = :artistaId")
    boolean existsByVagaAndArtista(@Param("vagaId") Integer vagaId, @Param("artistaId") Integer artistaId);

    default void aprovarCandidatura(Integer id) {
        Candidatura candidatura = findById(id).orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        candidatura.setStatus(new Status(1));
        save(candidatura);
    }

    default void reprovarCandidatura(Integer id) {
        Candidatura candidatura = findById(id).orElseThrow(() -> new RuntimeException("Candidatura não encontrada"));
        candidatura.setStatus(new Status(2));
        save(candidatura);
    }
}
