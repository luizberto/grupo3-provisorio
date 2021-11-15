package com.example.demo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "dono_quadra")
@Entity
public class DonoQuadra {
    @Id
    @Column(name = "id_dono", nullable = false)
    private Integer id;

    @Column(name = "nome_dono", length = 100)
    private String nomeDono;

    @Column(name = "dataNasc")
    private LocalDate dataNasc;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "senha", length = 100)
    private String senha;

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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}