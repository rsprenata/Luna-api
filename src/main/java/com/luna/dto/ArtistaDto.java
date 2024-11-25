package com.luna.dto;

import com.luna.model.Especialidade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaDto extends UsuarioDto {
    private String peso;
    private String altura;
    private String experiencia;
    private Integer idade;
    private Integer nivel;
    private Especialidade especialidade;
}
