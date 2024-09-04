package com.luna.dto;

import com.luna.model.Nivel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NivelDto {
    private Integer id;
    private String descricao;
}
