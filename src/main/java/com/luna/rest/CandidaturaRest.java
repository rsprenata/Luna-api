package com.luna.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luna.dto.CandidaturaDto;
import com.luna.model.Candidatura;
import com.luna.repository.CandidaturaRepository;

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

        List<Candidatura> lista = repo.findByArtista_id(id, Sort.by(
                Sort.Order.desc("vaga.data"),
                Sort.Order.asc("vaga.nome"),
                Sort.Order.desc("vaga.valor")));

        List<CandidaturaDto> candidaturas = lista.stream().map(e -> mapper.map(e, CandidaturaDto.class)).collect(Collectors.toList());
        return candidaturas;
    }

    @GetMapping(value = "/candidatura/empresa/{id}", produces = "application/json;charset=UTF-8")
    public List<CandidaturaDto> getByIdEmpresa(@PathVariable("id") Integer id){

        List<Candidatura> lista = repo.findByVaga_Empresa_Id(id);

        List<CandidaturaDto> candidaturas = lista.stream().map(e -> mapper.map(e, CandidaturaDto.class)).collect(Collectors.toList());
        return candidaturas;
    }

    @GetMapping(value = "/candidatura/vaga/{id}", produces = "application/json;charset=UTF-8")
    public List<CandidaturaDto> getByIdVaga(@PathVariable("id") Integer id){

        List<Candidatura> lista = repo.findByVaga_Id(id, Sort.by(
            Sort.Order.desc("vaga.data"),
            Sort.Order.asc("vaga.nome")));

        List<CandidaturaDto> candidaturas = lista.stream().map(e -> mapper.map(e, CandidaturaDto.class)).collect(Collectors.toList());
        return candidaturas;
    }

    @PutMapping("/candidatura/aprovar/{id}")
    public ResponseEntity<String> aprovarCandidatura(@PathVariable Integer id) {
        repo.aprovarCandidatura(id);
        return ResponseEntity.ok("Candidatura aprovada com sucesso!");
    }

    @PutMapping("/candidatura/reprovar/{id}")
    public ResponseEntity<String> reprovarCandidatura(@PathVariable Integer id) {
        repo.reprovarCandidatura(id);
        return ResponseEntity.ok("Candidatura reprovada com sucesso!");
    }

}
