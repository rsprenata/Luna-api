package com.luna.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luna.dto.ArtistaDto;
import com.luna.dto.EmpresaDto;
import com.luna.dto.LoginRequestDto;
import com.luna.model.Artista;
import com.luna.model.Empresa;
import com.luna.model.Usuario;
import com.luna.repository.ArtistaRepository;
import com.luna.repository.EmpresaRepository;
import com.luna.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("usuario")
public class UsuarioRest {
    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "login", produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        Usuario usuario = repo.findByEmailAndSenha(loginRequestDto.email(), loginRequestDto.senha());

        if(usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Usuário não encontrado!");
        }

        if(usuario.getNivel() == 1) {
            Artista artista = artistaRepository.findById(usuario.getId()).get();

            artista.setSenha(null);

            return ResponseEntity.ok(mapper.map(artista, ArtistaDto.class));
        } else if(usuario.getNivel() == 2) {
            Empresa empresa = empresaRepository.findById(usuario.getId()).get();

            empresa.setSenha(null);

            return ResponseEntity.ok(mapper.map(empresa, EmpresaDto.class));
        }

        return ResponseEntity.badRequest().body("Erro!");
    }
}
