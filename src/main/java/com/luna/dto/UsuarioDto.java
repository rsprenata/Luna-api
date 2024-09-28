package com.luna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {
    private Integer id;
    private String email;
    private String senha;
    private String endereco;
    private String bairroEndereco;
    private String numeroEndereco;
    private String cidadeEndereco;
    private String telefone;
    private String nome;
    private Integer nivel;
}
