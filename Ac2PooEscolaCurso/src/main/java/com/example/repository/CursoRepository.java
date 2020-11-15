package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.example.dto.CreateCursoDTO;
import com.example.dto.UpdateCursoDTO;
import com.example.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {
    private static int idCurso = 0;
    private List<Curso> cursos;

    public CursoRepository(){

    }
    
    @PostConstruct
    private void start() {
        cursos = new ArrayList<Curso>();
    }

    public Curso criar(CreateCursoDTO cursoDTO) {
        Curso entidade = Curso.fromDTO(cursoDTO);
        entidade.setIdCurso(idCurso++);
        cursos.add(entidade);
        return entidade;
    }

    public List<Curso> listar(Predicate<Curso> predicate) {
        return cursos.stream().filter(predicate).collect(Collectors.toList());
    }

    public void remover(int id) {
        cursos.removeIf(curso -> curso.getIdCurso() == id);
    }

    public void atualizarDados(UpdateCursoDTO atualizarDado, int id) {
        Curso curso = listar(c -> c.getIdCurso() == id).get(0);
        curso.setQuantidadeDeAlunos(atualizarDado.getQuantidadeDeAlunos());

    }

}
