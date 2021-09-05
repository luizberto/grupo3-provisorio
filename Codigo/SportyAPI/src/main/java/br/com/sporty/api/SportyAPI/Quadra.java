package br.com.sporty.api.SportyAPI;

import java.util.ArrayList;
import java.util.List;

public class Quadra {
    private Integer id;
    private String nome;
    private String endereco;
    private List<br.com.joao.c13adsajoaovitorrosa01201126.Partida> partidas = new ArrayList<>();

    public Quadra(Integer id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void addPartida(br.com.joao.c13adsajoaovitorrosa01201126.Partida p){
        partidas.add(p);
    }
    public void deletePartida(br.com.joao.c13adsajoaovitorrosa01201126.Partida p){
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

    public List<br.com.joao.c13adsajoaovitorrosa01201126.Partida> getPartidas() {
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
