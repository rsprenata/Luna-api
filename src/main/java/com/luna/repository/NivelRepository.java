package com.luna.repository;

import com.luna.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NivelRepository extends JpaRepository<Especialidade, Integer>{
}
