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
    private Double classificacaoQuadra;

    @Column(name = "complemento", length = 45)
    private String complemento;

    @Column(name = "numero", length = 6)
    private Integer numero;

    @Column(name = "foto", length = 15_728_640)
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private Endereco fkEndereco;

    @ManyToOne
    @JoinColumn(name = "fk_dono")
    private DonoQuadra dono;

    public Integer getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(Integer idQuadra) {
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

    public Integer getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(Integer limitePessoas) {
        this.limitePessoas = limitePessoas;
    }

    public Double getClassificacaoQuadra() {
        return classificacaoQuadra;
    }

    public void setClassificacaoQuadra(Double classificacaoQuadra) {
        this.classificacaoQuadra = classificacaoQuadra;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Endereco getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Endereco fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public DonoQuadra getDono() {
        return dono;
    }

    public void setDono(DonoQuadra dono) {
        this.dono = dono;
    }
}