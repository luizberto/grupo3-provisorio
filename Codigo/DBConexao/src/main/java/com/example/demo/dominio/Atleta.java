package com.example.demo.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "atleta", indexes = {
        @Index(name = "fkEndereco_idx", columnList = "fk_endereco")
})
@Entity
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atleta", nullable = false)
    private Integer id;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nome_atleta", length = 45)
    private String nomeAtleta;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "senha", length = 45)
    private String senha;

    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    @ManyToOne
    @JoinColumn(name = "fk_endereco")
    private Endereco fkEndereco;

    public Endereco getFkEndereco() {
        return fkEndereco;
    }

    public void setFkEndereco(Endereco fkEndereco) {
        this.fkEndereco = fkEndereco;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}