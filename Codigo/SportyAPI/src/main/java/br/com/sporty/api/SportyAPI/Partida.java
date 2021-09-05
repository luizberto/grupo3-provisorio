package br.com.sporty.api.SportyAPI;

public class Partida {
    private Integer id;
    private String hora;

    public Partida(Integer id, String hora) {
        this.id = id;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
