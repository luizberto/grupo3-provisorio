package com.example.demo.dominio;

import javax.persistence.*;

@Entity
public class Quadra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_quadra", nullable = false)
    private Integer idQuadra;

    @Column(name = "nome_quadra", length = 45)
    private String nomeQuadra;

    @Column(name = "desc_quadra", length = 300)
    private String descQuadra;

    @Column(name = "limite_pessoas")
    private Integer limitePessoas;

    @Column(name = "classificacao_quadra")
    private Integer classificacaoQuadra;

    @Column(name = "complemento", length = 45)
    private String complemento;



    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private Endereco fkEndereco;

    public Endereco getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Endereco fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getClassificacaoQuadra() {
        return classificacaoQuadra;
    }

    public void setClassificacaoQuadra(Integer classificacaoQuadra) {
        this.classificacaoQuadra = classificacaoQuadra;
    }

    public Integer getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(Integer limitePessoas) {
        this.limitePessoas = limitePessoas;
    }

    public String getDescQuadra() {
        return descQuadra;
    }

    public void setDescQuadra(String descQuadra) {
        this.descQuadra = descQuadra;
    }

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public void setNomeQuadra(String nomeQuadra) {
        this.nomeQuadra = nomeQuadra;
    }

    public Integer getId() {
        return idQuadra;
    }

    public void setId(Integer id) {
        this.idQuadra = id;
    }
}