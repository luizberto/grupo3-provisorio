package br.com.sporty.api.SportyAPI;

import java.util.Date;

public class Partida {
    private Integer id;
    private Date horario;

    public Partida(Integer id, Date hora) {
        this.id = id;
        this.horario = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date hora) {
        this.horario = hora;
    }
}
