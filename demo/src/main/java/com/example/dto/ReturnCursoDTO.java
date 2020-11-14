package com.example.dto;

public class ReturnCursoDTO {
    private String nomeCurso;
    private int quantidadeDeAlunos;
    private int quantidadeDeAulas;
    private float duracao;
    private String descricao;
    private int idCurso;
    private ReturnEscolaDTO escolaDTO;
    
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

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public ReturnEscolaDTO getEscolaDTO() {
		return escolaDTO;
	}

	public void setEscolaDTO(ReturnEscolaDTO escolaDTO) {
		this.escolaDTO = escolaDTO;
	}

}
