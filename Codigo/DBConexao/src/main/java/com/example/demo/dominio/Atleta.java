package com.example.demo.dominio;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "atleta", indexes = {
        @Index(name = "fk_Atleta_Endereco1_idx", columnList = "Endereco_cep")
})
@Entity
public class Atleta {
    @Id
    @Column(name = "cpf", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name = "nomeAtleta", length = 45)
    private String nomeAtleta;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "senha", length = 45)
    private String senha;

    @Column(name = "dataNasc")
    private LocalDate dataNasc;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Endereco_cep", nullable = false)
    private Endereco enderecoCep;

    public Endereco getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(Endereco enderecoCep) {
        this.enderecoCep = enderecoCep;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}