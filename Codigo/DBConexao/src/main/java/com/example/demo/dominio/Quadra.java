package com.example.demo.dominio;

import javax.persistence.*;

@Table(name = "quadra", indexes = {
        @Index(name = "fk_Quadra_Endereco1_idx", columnList = "Endereco_idEndereco")
})
@Entity
public class Quadra {
    @Id
    @Column(name = "idQuadra", nullable = false)
    private Integer id;

    @Column(name = "nomeQuadra", length = 45)
    private String nomeQuadra;

    @Column(name = "descQuadra", length = 300)
    private String descQuadra;

    @Column(name = "limitePessoas")
    private Integer limitePessoas;

    @Column(name = "classificacaoQuadrao")
    private Integer classificacaoQuadrao;

    @Column(name = "complemento", length = 45)
    private String complemento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Endereco_idEndereco", nullable = false)
    private Endereco enderecoIdendereco;

    public Endereco getEnderecoIdendereco() {
        return enderecoIdendereco;
    }

    public void setEnderecoIdendereco(Endereco enderecoIdendereco) {
        this.enderecoIdendereco = enderecoIdendereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getClassificacaoQuadrao() {
        return classificacaoQuadrao;
    }

    public void setClassificacaoQuadrao(Integer classificacaoQuadrao) {
        this.classificacaoQuadrao = classificacaoQuadrao;
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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}