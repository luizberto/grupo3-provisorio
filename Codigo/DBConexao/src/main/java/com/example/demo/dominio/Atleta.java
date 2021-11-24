package com.example.demo.dominio;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atleta", nullable = false)
    private Integer id;
    
    @Column(name = "cpf", length = 14)
    private String cpf;

    @Length(min = 3, max = 50, message = "Campo NOME inválido")
    @NotBlank
    @Column(name = "nome_atleta")
    private String nomeAtleta;

    @Email()
    @NotBlank(message = "Favor informar email")
    @Column(name = "email", length = 50)
    private String email;

    @Length(min = 4, max = 35, message = "Informar uma senha entre 4-35 caracteres")
    @NotBlank(message = "Favor informar senha")
    @Column(name = "senha", length = 50)
    private String senha;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    @ManyToOne
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