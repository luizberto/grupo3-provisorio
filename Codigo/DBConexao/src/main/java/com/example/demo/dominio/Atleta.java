package com.example.demo.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "atleta", indexes = {
        @Index(name = "fk_Atleta_Endereco1_idx", columnList = "fkEndereco")
})
@Entity
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtleta", nullable = false)
    private Integer id;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nomeAtleta", length = 45)
    private String nomeAtleta;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "senha", length = 45)
    private String senha;

    @Column(name = "dataNasc")
    private LocalDate dataNasc;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fkEndereco", nullable = false)
    private Endereco enderecoIdendereco;

    public Endereco getFkIdendereco() {
        return enderecoIdendereco;
    }

    public void setFkIdendereco(Endereco enderecoIdendereco) {
        this.enderecoIdendereco = enderecoIdendereco;
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