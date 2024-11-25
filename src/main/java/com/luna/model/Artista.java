package com.luna.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="artista")
public class Artista extends Usuario implements Serializable{

    private String peso;
    private String altura;
    private String experiencia;
    private Integer idade;
    @ManyToOne
    @JoinColumn(name="especialidade")
    private Especialidade especialidade;

}
