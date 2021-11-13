package com.example.demo.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Integer idReserva;

    @Column(name = "horaPartida", nullable = false)
    private LocalDateTime horaPartida;

    @ManyToOne
    private Quadra quadra;

    @ManyToOne
    private Atleta responsavel;

    @Column(name = "qtdAtletas", length = 45)
    private String qtdAtletas;

    @Column(name = "valorReserva", length = 45)
    private String valorReserva;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDateTime getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(LocalDateTime horaPartida) {
        this.horaPartida = horaPartida;
    }

    public String getValorReserva() {
        return valorReserva;
    }

    public void setValorReserva(String valorReserva) {
        this.valorReserva = valorReserva;
    }

    public String getQtdAtletas() {
        return qtdAtletas;
    }

    public void setQtdAtletas(String qtdAtletas) {
        this.qtdAtletas = qtdAtletas;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public Atleta getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Atleta responsavel) {
        this.responsavel = responsavel;
    }
}