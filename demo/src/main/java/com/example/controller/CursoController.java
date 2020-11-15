package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.example.dto.CreateCursoDTO;
import com.example.dto.ReturnCursoDTO;
import com.example.dto.UpdateCursoDTO;
import com.example.model.Curso;
import com.example.service.CursoService;

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
@RequestMapping(value = "cursos")
public class CursoController {
    public CursoController() {

    }

    @Autowired
    public CursoService cursoService;

    @PostMapping
    public ResponseEntity<ReturnCursoDTO> cadastrar(@RequestBody CreateCursoDTO cursoDTO, HttpServletRequest request,
            UriComponentsBuilder builder) {
        Curso curso = cursoService.cadastrarCurso(cursoDTO);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + curso.getIdCurso()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<ReturnCursoDTO>> listarCursos() {
        return ResponseEntity
                .ok(cursoService.listarTodos().stream().map(curso -> Curso.toDTO(curso)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnCursoDTO> listarPorCodigo(@PathVariable int id) {
        return ResponseEntity.ok(Curso.toDTO(cursoService.listar(curso -> curso.getIdCurso() == id).get(0)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCurso(@PathVariable int id) {
        cursoService.removerCurso(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarDados(@PathVariable int id, @RequestBody UpdateCursoDTO body) {
        cursoService.alterarDadosCurso(body, id);
        return ResponseEntity.ok().build();
    }

}
