package com.luna.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity

@Table(name="candidatura", uniqueConstraints= {
        @UniqueConstraint(columnNames={"vaga_id", "artista_id"})
})
public class Candidatura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="vaga_id")
    private Vaga vaga;
    @ManyToOne
    @JoinColumn(name="artista_id")
    private Artista artista;
    @ManyToOne
    @JoinColumn(name="status")
    private Status status;
}
