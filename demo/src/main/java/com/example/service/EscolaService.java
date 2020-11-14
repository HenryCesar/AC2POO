package com.example.service;

import java.util.List;

import com.example.dto.CreateEscolaDTO;
import com.example.dto.UpdateEscolaDTO;
import com.example.model.Curso;
import com.example.model.Escola;
import com.example.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {

    @Autowired
    public EscolaRepository repository;
    @Autowired
    public CursoService cursoService;

    public EscolaService(){
        
    }

    public List<Escola> listarTodas() {
        return repository.listar(escola -> true);
    }

    public Escola listarPorCodigo(int id) {
        List<Escola> escolas = repository.listar(escola -> escola.getIdEscola() == id);

        if (escolas.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A Escola identificada " + id + " não encontrada!");
        return escolas.get(0);
    }

    public Escola cadastrarEscola(CreateEscolaDTO escolaDTO) {
        return repository.criar(escolaDTO);
    }

    public void removerEscola(int id) {
        if (!existe(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A Escola identificada " + id + " não encontrada!");
        if(cursoService.listar(curso -> 
            curso.getEscola().getIdEscola() == id).size() != 0)
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A Escola que você deseja deletar, possui cursos. Portanto não pode ser deletada!");
        repository.remover(id);
    }

    public void alterarDadosEscola(UpdateEscolaDTO escolaDTO, int id) {
        if (!existe(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A Escola identificada " + id + " não encontrada!");
        repository.atualizarDados(escolaDTO, id);
    }

    public boolean existe(int id) {
        List<Escola> escolas = repository.listar(escola -> escola.getIdEscola() == id);
        return escolas.size() != 0;
    }
    
    public List<Curso> listarCursos(int id){
        return cursoService.listar(curso -> curso.getEscola().getIdEscola() == id);
    }

}
