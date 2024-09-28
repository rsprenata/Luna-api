package com.luna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDto extends UsuarioDto {
    private String cnpj;
    private String descricao;
}
