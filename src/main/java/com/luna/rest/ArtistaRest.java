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

import com.luna.dto.ArtistaDto;
import com.luna.model.Artista;
import com.luna.repository.ArtistaRepository;

@CrossOrigin
@RestController
public class ArtistaRest {
    @Autowired
    private ArtistaRepository repo;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "/artista/", produces = "application/json;charset=UTF-8")
    public ArtistaDto inserir(@RequestBody ArtistaDto artista) {
        // salva a Entidade convertida do DTO
        Artista a = mapper.map(artista, Artista.class);
        repo.save(a);
        // busca o usuário inserido
        Optional<Artista> usu = repo.findById(a.getId());
        // retorna o DTO equivalente à entidade
        return mapper.map(usu, ArtistaDto.class);
    }

    @GetMapping(value = "/artista/", produces = "application/json;charset=UTF-8")
    public List<ArtistaDto> getAllArtistas(){

        List<Artista> lista = repo.findAll();

        return lista.stream().map(e -> mapper.map(e,ArtistaDto.class)).collect(Collectors.toList());
    }

    @GetMapping(value = "/artista/{id}", produces = "application/json;charset=UTF-8")
    public ArtistaDto getById(@PathVariable("id") Integer id){
        Artista artista = repo.findById(id).get();

        if (artista != null){
            return mapper.map(artista, ArtistaDto.class);
        }else{
            return null;
        }
    }
}
