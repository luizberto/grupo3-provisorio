package com.example.demo.dominio;

import javax.persistence.*;

@Table(name = "quadra", indexes = {
        @Index(name = "fk_Quadra_Endereco1_idx", columnList = "Endereco_idEndereco")
})
@Entity
public class Quadra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuadra", nullable = false)
    private Integer id;

    @Column(name = "nomeQuadra", length = 45)
    private String nomeQuadra;

    @Column(name = "descQuadra", length = 300)
    private String descQuadra;

    @Column(name = "limitePessoas")
    private Integer limitePessoas;

    @Column(name = "classificacaoQuadra")
    private Integer classificacaoQuadra;

    @Column(name = "complemento", length = 45)
    private String complemento;

    @Column(name = "Endereco_idEndereco", nullable = false)
    private Integer enderecoIdendereco;

    public Integer getEnderecoIdendereco() {
        return enderecoIdendereco;
    }

    public void setEnderecoIdendereco(Integer enderecoIdendereco) {
        this.enderecoIdendereco = enderecoIdendereco;
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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}