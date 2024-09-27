package com.luna.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="usuario")
public class Usuario implements Serializable {
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
}
