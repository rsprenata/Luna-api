package com.luna.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luna.dto.ArtistaDto;
import com.luna.model.Artista;
import com.luna.repository.ArtistaRepository;

@CrossOrigin
@RestController
public class ArtistaRest {
    //mvn spring-boot:run
    @Autowired
    private ArtistaRepository repo;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "/artista/", produces = "application/json;charset=UTF-8")
    public ArtistaDto inserir(@RequestBody ArtistaDto artista) {
        final int NIVEL_ARTISTA = 1;
        // salva a Entidade convertida do DTO
        Artista a = mapper.map(artista, Artista.class);
        a.setNivel(NIVEL_ARTISTA);
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
        System.out.println(id);
        Artista artista = repo.findById(id).get();
        if (artista != null){
            return mapper.map(artista, ArtistaDto.class);
        }else{
            return null;
        }
    }

    @PutMapping(value = "/artista/{id}", produces = "application/json;charset=UTF-8")
    public ArtistaDto updateUser(@PathVariable Integer id,@RequestBody ArtistaDto artista){
        Optional<Artista> optionalArtista = repo.findById(id);

        if(optionalArtista.isPresent()){
            Artista existingArtista = optionalArtista.get();

            existingArtista.setNome(artista.getNome());
            existingArtista.setAltura(artista.getAltura());
            existingArtista.setEmail(artista.getEmail());
            existingArtista.setEndereco(artista.getEndereco());
            existingArtista.setExperiencia(artista.getExperiencia());
            existingArtista.setBairroEndereco(artista.getBairroEndereco());
            existingArtista.setCidadeEndereco(artista.getCidadeEndereco());
            existingArtista.setNumeroEndereco(artista.getNumeroEndereco());
            existingArtista.setPeso(artista.getPeso());
            existingArtista.setSenha(artista.getSenha());
            existingArtista.setIdade(artista.getIdade());

            repo.save(existingArtista);

            return mapper.map(existingArtista , ArtistaDto.class);
        }else{
            return null;
        }

    }
}
