package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.example.dto.CreateEscolaDTO;
import com.example.dto.UpdateEscolaDTO;
import com.example.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {
    private int idAtual = 0;
    private List<Escola> escolas;

    @PostConstruct
    private void start() {
        escolas = new ArrayList<Escola>();
    }

    public Escola criar(CreateEscolaDTO escolaDTO) {
        Escola entidade = Escola.fromDTO(escolaDTO);
        entidade.setIdEscola(idAtual++);
        escolas.add(entidade);
        return entidade;
    }

    public List<Escola> listar(Predicate<Escola> predicate) {
        return escolas.stream().filter(predicate).collect(Collectors.toList());
    }

    public void remover(int id) {
        escolas.removeIf(escola -> escola.getIdEscola() == id);
    }

    public void atualizarDados(UpdateEscolaDTO atualizarDado, int id){
        Escola escola = listar(e -> e.getIdEscola() == id).get(0);
        escola.setQuantidadeDeAlunos(atualizarDado.getQuantidadeDeAlunos());
        escola.setTelefone(atualizarDado.getTelefone());
    }

    
}
