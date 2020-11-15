package com.example.service;

import java.util.List;
import java.util.function.Predicate;

import com.example.dto.CreateCursoDTO;
import com.example.dto.UpdateCursoDTO;
import com.example.model.Curso;
import com.example.model.Escola;
import com.example.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    public CursoRepository repository;
    @Autowired
    public EscolaService escolaService;

    public CursoService() {

    }

    public List<Curso> listarTodos() {
        return repository.listar(curso -> true);
    }

    public List<Curso> listar(Predicate<Curso> predicate) {
        return repository.listar(predicate);
    }

    public Curso cadastrarCurso(CreateCursoDTO cursoDTO) {
        Escola escola = escolaService.listarPorCodigo(cursoDTO.getIdEscola());
        Curso curso = repository.criar(cursoDTO);
        curso.setEscola(escola);
        return curso;
    }

    public void removerCurso(int id) {
        repository.remover(id);
    }

    public void alterarDadosCurso(UpdateCursoDTO cursoDTO, int id) {
        repository.atualizarDados(cursoDTO, id);
    }

}
