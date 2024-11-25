package com.luna.dto;

import com.luna.model.Especialidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagaDto {
    private Integer id;
    private String nome;
    private String descricao;
    private String valor;
    private String data;
    private Integer qtdVagas;
    private NivelDto nivel;
    private EmpresaDto empresa;
    private Especialidade especialidade;
}
