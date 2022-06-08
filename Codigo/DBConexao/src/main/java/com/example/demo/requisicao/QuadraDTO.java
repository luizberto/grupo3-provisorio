package com.example.demo.requisicao;

public class QuadraDTO {
    private int idQuadra;
    private String nomeQuadra;
    private String descQuadra;
    private int limitePessoas;
    private double classificacaoQuadra;
    private String complemento;
    private int numero;
    private int idDono;
    
    public QuadraDTO() {
    }

    private Integer getIdDono() {
        return idDono;
    }

    private void setIdDono(Integer idDono) {
        this.idDono = idDono;
    }


    public int getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(int idQuadra) {
        this.idQuadra = idQuadra;
    }


    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public void setNomeQuadra(String nomeQuadra) {
        this.nomeQuadra = nomeQuadra;
    }


    public String getDescQuadra() {
        return descQuadra;
    }

    public void setDescQuadra(String descQuadra) {
        this.descQuadra = descQuadra;
    }


    public int getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(int limitePessoas) {
        this.limitePessoas = limitePessoas;
    }


    public double getClassificacaoQuadra() {
        return classificacaoQuadra;
    }

    public void setClassificacaoQuadra(double classificacaoQuadra) {
        this.classificacaoQuadra = classificacaoQuadra;
    }


    public String getComplemento() {
        return complemento;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }   


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
}
