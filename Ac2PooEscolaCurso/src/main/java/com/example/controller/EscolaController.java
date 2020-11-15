package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.example.dto.CreateEscolaDTO;
import com.example.dto.ReturnCursoDTO;
import com.example.dto.ReturnEscolaDTO;
import com.example.dto.UpdateEscolaDTO;
import com.example.model.Curso;
import com.example.model.Escola;
import com.example.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "escolas")
public class EscolaController {
    public EscolaController() {

    }

    @Autowired
    public EscolaService escolaService;

    @PostMapping
    public ResponseEntity<ReturnEscolaDTO> cadastrar(@RequestBody CreateEscolaDTO escolaDTO, HttpServletRequest request,
            UriComponentsBuilder builder) {
        Escola escola = escolaService.cadastrarEscola(escolaDTO);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + escola.getIdEscola()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<ReturnEscolaDTO>> listarEscolas() {
        return ResponseEntity.ok(
                escolaService.listarTodas().stream().map(escola -> Escola.toDTO(escola)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnEscolaDTO> listarPorCodigo(@PathVariable int id) {
        return ResponseEntity.ok(Escola.toDTO(escolaService.listarPorCodigo(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEscola(@PathVariable int id) {
        escolaService.removerEscola(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarDados(@PathVariable int id, @RequestBody UpdateEscolaDTO body) {
        escolaService.alterarDadosEscola(body, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<ReturnCursoDTO>> listarCursos(@PathVariable int id) {
        return ResponseEntity.ok(
                escolaService.listarCursos(id).stream().map(curso -> Curso.toDTO(curso)).collect(Collectors.toList()));
    }

}
