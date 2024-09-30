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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luna.dto.VagaDto;
import com.luna.model.Empresa;
import com.luna.model.Vaga;
import com.luna.repository.EmpresaRepository;
import com.luna.repository.VagaRepository;

@CrossOrigin
@RestController
public class VagaRest {
    @Autowired
    private VagaRepository repo;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "/vaga/", produces = "application/json;charset=UTF-8")
    public VagaDto inserir(@RequestBody VagaDto vaga) {
        // salva a Entidade convertida do DTO
        Vaga a = mapper.map(vaga, Vaga.class);

        Empresa e = empresaRepository.findById(vaga.getEmpresa().getId()).get();
        a.setEmpresa(e);

        repo.save(a);
        // busca a vaga inserido
        Optional<Vaga> v = repo.findById(a.getId());
        // retorna o DTO equivalente à entidade
        return mapper.map(v, VagaDto.class);
    }

    @GetMapping(value = "/vaga/", produces = "application/json;charset=UTF-8")
    public List<VagaDto> getAllVagas(){

        List<Vaga> lista = repo.findAll();

        return lista.stream().map(e -> mapper.map(e,VagaDto.class)).collect(Collectors.toList());
    }

    @GetMapping(value = "/vaga/empresa/{id}", produces = "application/json;charset=UTF-8")
    public List<VagaDto> getVagasByEmpresa(@PathVariable("id") Integer id){

        List<Vaga> lista = repo.findByEmpresa_id(id);

        return lista.stream().map(e -> mapper.map(e,VagaDto.class)).collect(Collectors.toList());
    }

    @GetMapping(value = "/vaga/{id}", produces = "application/json;charset=UTF-8")
    public VagaDto getById(@PathVariable("id") Integer id){
        Vaga vaga = repo.findById(id).get();

        if (vaga != null){
            return mapper.map(vaga, VagaDto.class);
        }else{
            return null;
        }
    }

    @PutMapping(value = "/vaga/{id}", produces = "application/json;charset=UTF-8")
    public VagaDto updateVaga(@PathVariable Integer id, @RequestBody VagaDto vaga){
        Optional<Vaga> optionalVaga = repo.findById(id);

        if(optionalVaga.isPresent()){
            Vaga existingVaga = optionalVaga.get();

            existingVaga.setNome(vaga.getNome());
            existingVaga.setDescricao(vaga.getDescricao());
            existingVaga.setData(vaga.getData());
            existingVaga.setValor(vaga.getValor());
            existingVaga.setQtdVagas(vaga.getQtdVagas());

            repo.save(existingVaga);

            return mapper.map(existingVaga , VagaDto.class);
        }else{
            return null;
        }

    }
}
