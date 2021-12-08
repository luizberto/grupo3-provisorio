package com.example.demo.requisicao;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.Quadra;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ReservaDTO {

    private LocalDateTime horaPartida;

    private int quadra;

    private int atleta;

    private Integer qtdAtletas;

    private Double valorReserva;

    private int horario;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDateTime horaPartida, int quadra, int atleta, Integer qtdAtletas, Double valorReserva, int horario) {
        this.horaPartida = horaPartida;
        this.quadra = quadra;
        this.atleta = atleta;
        this.qtdAtletas = qtdAtletas;
        this.valorReserva = valorReserva;
        this.horario = horario;
    }

    public LocalDateTime getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(LocalDateTime horaPartida) {
        this.horaPartida = horaPartida;
    }

    public int getQuadra() {
        return quadra;
    }

    public void setQuadra(int quadra) {
        this.quadra = quadra;
    }

    public int getAtleta() {
        return atleta;
    }

    public void setAtleta(int atleta) {
        this.atleta = atleta;
    }

    public Integer getQtdAtletas() {
        return qtdAtletas;
    }

    public void setQtdAtletas(Integer qtdAtletas) {
        this.qtdAtletas = qtdAtletas;
    }

    public Double getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(Double valorReserva) {
        this.valorReserva = valorReserva;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
}
