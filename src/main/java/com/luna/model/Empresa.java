package com.luna.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa extends Usuario implements Serializable {

    private String cnpj;
    private String descricao;
}
