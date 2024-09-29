package com.luna.rest;

import com.luna.dto.EmpresaDto;
import com.luna.model.Empresa;
import com.luna.repository.EmpresaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class EmpresaRest {
    //mvn spring-boot:run
    @Autowired
    private EmpresaRepository repo;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "/empresa/", produces = "application/json;charset=UTF-8")
    public EmpresaDto inserir(@RequestBody EmpresaDto empresa) {
        final int NIVEL_EMPRESA = 2;
        // salva a Entidade convertida do DTO
        Empresa e = mapper.map(empresa, Empresa.class);
        e.setNivel(NIVEL_EMPRESA);
        repo.save(e);
        // busca o usuário inserido
        Optional<Empresa> usu = repo.findById(e.getId());
        // retorna o DTO equivalente à entidade
        return mapper.map(usu, EmpresaDto.class);
    }

    @GetMapping(value = "/empresa/", produces = "application/json;charset=UTF-8")
    public List<EmpresaDto> getAllEmpresas(){

        List<Empresa> lista = repo.findAll();

        return lista.stream().map(e -> mapper.map(e,EmpresaDto.class)).collect(Collectors.toList());
    }

    @GetMapping(value = "/empresa/{id}", produces = "application/json;charset=UTF-8")
    public EmpresaDto getById(@PathVariable("id") Integer id){
        Empresa empresa = repo.findById(id).get();

        if (empresa != null){
            return mapper.map(empresa, EmpresaDto.class);
        }else{
            return null;
        }
    }

    @PutMapping(value = "/empresa/{id}", produces = "application/json;charset=UTF-8")
    public EmpresaDto updateUser(@PathVariable Integer id,@RequestBody EmpresaDto empresa){
        Optional<Empresa> optionalEmpresa = repo.findById(id);

        if(optionalEmpresa.isPresent()){
            Empresa existingEmpresa = optionalEmpresa.get();

            existingEmpresa.setNome(empresa.getNome());
            existingEmpresa.setEmail(empresa.getEmail());
            existingEmpresa.setEndereco(empresa.getEndereco());
            existingEmpresa.setBairroEndereco(empresa.getBairroEndereco());
            existingEmpresa.setCidadeEndereco(empresa.getCidadeEndereco());
            existingEmpresa.setNumeroEndereco(empresa.getNumeroEndereco());
            existingEmpresa.setSenha(empresa.getSenha());
            existingEmpresa.setCnpj(empresa.getCnpj());
            existingEmpresa.setDescricao(empresa.getDescricao());

            repo.save(existingEmpresa);

            return mapper.map(existingEmpresa , EmpresaDto.class);
        }else{
            return null;
        }

    }
}
