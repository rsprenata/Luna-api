package com.luna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDto {
    private Integer id;
    private String email;
    private String senha;
    private String endereco;
    private String bairroEndereco;
    private String numeroEndereco;
    private String cidadeEndereco;
    private String telefone;
    private String descricao;
    private String cnpj;
    private String nome;
}
