package com.example.service;

import java.util.List;
import java.util.function.Predicate;

import com.example.dto.CreateCursoDTO;
import com.example.dto.UpdateCursoDTO;
import com.example.model.Curso;
import com.example.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    

    @Autowired
    public CursoRepository repository;
    @Autowired
    public EscolaService escolaService;

    public CursoService(){
        
    }

    public List<Curso> listarTodos(){
        return repository.listar(curso -> true);
    }

    public List<Curso> listar(Predicate<Curso> predicate){
        return repository.listar(predicate);
    }

    public Curso cadastrarCurso(CreateCursoDTO cursoDTO){
        int id = cursoDTO.getIdEscola();
        if(!escolaService.existe(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A Escola identificada " + id + " não encontrada!");
        return repository.criar(cursoDTO);
    }


    public void removerCurso(int id){
        repository.remover(id);
    }

    public void alterarDadosCurso(UpdateCursoDTO cursoDTO, int id){
        repository.atualizarDados(cursoDTO, id);
    }
    
}
