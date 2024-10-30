package com.luna.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luna.model.Vaga;


public interface VagaRepository extends JpaRepository<Vaga, Integer>{
    List<Vaga> findByEmpresa_id(Integer id, Sort sort);
    List<Vaga> findAll(Sort sort);
}
