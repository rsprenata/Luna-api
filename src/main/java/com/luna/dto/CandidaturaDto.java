package com.luna.dto;

import com.luna.model.Status;
import com.luna.model.Vaga;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidaturaDto {
    private Integer id;
    private VagaDto vaga;
    private ArtistaDto artista;
    private StatusDto status;
}
