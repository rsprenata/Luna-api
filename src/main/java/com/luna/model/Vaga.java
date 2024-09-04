package com.luna.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vaga")
public class Vaga implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String nome;
    private String descricao;
    private String valor;
    private String data;
    private Integer qtdVagas;
    @ManyToOne
    @JoinColumn(name="nivel")
    private Nivel nivel;
}
