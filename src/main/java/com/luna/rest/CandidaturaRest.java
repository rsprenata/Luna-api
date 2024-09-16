package com.luna.rest;

import com.luna.dto.CandidaturaDto;
import com.luna.model.Candidatura;
import com.luna.repository.CandidaturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class CandidaturaRest {
    @Autowired
    private CandidaturaRepository repo;

    @Autowired
    private ModelMapper mapper;


    @PostMapping(value = "/candidatura/", produces = "application/json;charset=UTF-8")
    public CandidaturaDto inserir(@RequestBody CandidaturaDto candidatura) {
        // salva a Entidade convertida do DTO
        Candidatura c = mapper.map(candidatura, Candidatura.class);
        repo.save(c);
        // busca a vaga inserido
        Optional<Candidatura> cd = repo.findById(c.getId());
        // retorna o DTO equivalente à entidade
        return mapper.map(cd, CandidaturaDto.class);
    }

    @GetMapping(value = "/candidatura/artista/{id}", produces = "application/json;charset=UTF-8")
    public List<CandidaturaDto> getByIdArtista(@PathVariable("id") Integer id){

        List<Candidatura> lista = repo.findByArtista_id(id);

        List<CandidaturaDto> candidaturas = lista.stream().map(e -> mapper.map(e, CandidaturaDto.class)).collect(Collectors.toList());
        return candidaturas;
    }

    @GetMapping(value = "/candidatura/empresa/{id}", produces = "application/json;charset=UTF-8")
    public List<CandidaturaDto> getByIdEmpresa(@PathVariable("id") Integer id){

        List<Candidatura> lista = repo.findByVaga_Empresa_Id(id);

        List<CandidaturaDto> candidaturas = lista.stream().map(e -> mapper.map(e, CandidaturaDto.class)).collect(Collectors.toList());
        return candidaturas;
    }

}
