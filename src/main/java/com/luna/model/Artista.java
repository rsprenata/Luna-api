package com.luna.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="artista")
public class Artista implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    private String email;
    private String senha;
    private String endereco;
    private String bairroEndereco;
    private String numeroEndereco;
    private String cidadeEndereco;
    private String telefone;
    private String nome;
    private String peso;
    private String altura;
    private String experiencia;
}
