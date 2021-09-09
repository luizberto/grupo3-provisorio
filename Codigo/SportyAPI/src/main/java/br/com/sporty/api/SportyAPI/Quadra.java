package br.com.sporty.api.SportyAPI;

import java.util.ArrayList;
import java.util.List;

public class Quadra {
    private Integer id;
    private String nome;
    private String endereco;
    private List<Partida> partidas = new ArrayList<>();


    public Quadra(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void addPartida(Partida p){
        partidas.add(p);
    }
    public void deletePartida(Partida p){
        partidas.remove(p);
    }
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
