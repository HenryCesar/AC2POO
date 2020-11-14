package com.example.model;

import com.example.dto.CreateCursoDTO;
import com.example.dto.ReturnCursoDTO;

public class Curso {
    private String nomeCurso;
    private int quantidadeDeAlunos;
    private int quantidadeDeAulas;
    private float duracao;
    private String descricao;
    private int idCurso;
    private Escola escola;

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getQuantidadeDeAlunos() {
        return quantidadeDeAlunos;
    }

    public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    public int getQuantidadeDeAulas() {
        return quantidadeDeAulas;
    }

    public void setQuantidadeDeAulas(int quantidadeDeAulas) {
        this.quantidadeDeAulas = quantidadeDeAulas;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Curso fromDTO(CreateCursoDTO cursoDTO) {
        Curso entidade = new Curso();
        entidade.setDescricao(cursoDTO.getDescricao());
        entidade.setDuracao(cursoDTO.getDuracao());
        entidade.setQuantidadeDeAlunos(cursoDTO.getQuantidadeDeAlunos());
        entidade.setQuantidadeDeAulas(cursoDTO.getQuantidadeDeAulas());
        entidade.setNomeCurso(cursoDTO.getNomeCurso());

        return entidade;
    }

    public static ReturnCursoDTO toDTO(Curso curso) {
        ReturnCursoDTO dto = new ReturnCursoDTO();

        dto.setNomeCurso(curso.getNomeCurso());
        dto.setDescricao(curso.getDescricao());
        dto.setDuracao(curso.getDuracao());
        dto.setQuantidadeDeAlunos(curso.getQuantidadeDeAlunos());
        dto.setQuantidadeDeAulas(curso.getQuantidadeDeAulas());
        dto.setEscolaDTO(Escola.toDTO(curso.getEscola()));

        return dto;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}
