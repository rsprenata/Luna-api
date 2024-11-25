package com.luna.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vaga") //mudar para Trabalho
public class Vaga implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String nome;//mudar p titulo
    private String descricao;
    private String valor;
    private String data;
    private Integer qtdVagas;
    @ManyToOne
    @JoinColumn(name="especialidade")
    private Especialidade especialidade;
    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;
}
