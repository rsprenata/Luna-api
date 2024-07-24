package com.luna.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luna.dto.VagaDto;
import com.luna.model.Vaga;
import com.luna.repository.VagaRepository;

@CrossOrigin
@RestController
public class VagaRest {
    @Autowired
    private VagaRepository repo;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "/vaga/", produces = "application/json;charset=UTF-8")
    public VagaDto inserir(@RequestBody VagaDto vaga) {
        // salva a Entidade convertida do DTO
        Vaga a = mapper.map(vaga, Vaga.class);
        repo.save(a);
        // busca a vaga inserido
        Optional<Vaga> v = repo.findById(a.getId());
        // retorna o DTO equivalente à entidade
        return mapper.map(v, VagaDto.class);
    }
/*
    @GetMapping(value = "/vaga/", produces = "application/json;charset=UTF-8")
    public List<VagaDto> getAllVagas(){

        List<Vaga> lista = repo.findAll();

        return lista.stream().map(e -> mapper.map(e,VagaDto.class)).collect(Collectors.toList());
    }*/

    @GetMapping(value = "/vaga/{id}", produces = "application/json;charset=UTF-8")
    public VagaDto getById(@PathVariable("id") Integer id){
        Vaga vaga = repo.findById(id).get();

        if (vaga != null){
            return mapper.map(vaga, VagaDto.class);
        }else{
            return null;
        }
    }
}
