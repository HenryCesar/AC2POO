package com.example.model;

import com.example.dto.CreateEscolaDTO;
import com.example.dto.ReturnEscolaDTO;

public class Escola {
    private String nomeEscola;
    private int quantidadeDeAlunos;
    private String cnpj;
    private String localizacao;
    private String telefone;
    private int idEscola;

    public String getNome() {
        return nomeEscola;
    }

    public void setNome(String nome) {
        this.nomeEscola = nome;
    }

    public int getQuantidadeDeAlunos() {
        return quantidadeDeAlunos;
    }

    public void setQuantidadeDeAlunos(int quantidadeDeAlunos) {
        this.quantidadeDeAlunos = quantidadeDeAlunos;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    public int getIdEscola() {
        return idEscola;
    }

    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    public static Escola fromDTO(CreateEscolaDTO escolaDTO) {
        Escola entidade = new Escola();

        entidade.setNome(escolaDTO.getNome());
        entidade.setCnpj(escolaDTO.getCnpj());
        entidade.setQuantidadeDeAlunos(escolaDTO.getQuantidadeDeAlunos());
        entidade.setLocalizacao(escolaDTO.getLocalizacao());
        entidade.setTelefone(escolaDTO.getTelefone());

        return entidade;
    }
    
    public static ReturnEscolaDTO toDTO(Escola escola){
        ReturnEscolaDTO dto = new ReturnEscolaDTO();

        dto.setNome(escola.getNome());
        dto.setCnpj(escola.getCnpj());
        dto.setQuantidadeDeAlunos(escola.getQuantidadeDeAlunos());
        dto.setLocalizacao(escola.getLocalizacao());
        dto.setTelefone(escola.getTelefone());
        dto.setIdEscola(escola.getIdEscola());

        return dto;
    }
}
