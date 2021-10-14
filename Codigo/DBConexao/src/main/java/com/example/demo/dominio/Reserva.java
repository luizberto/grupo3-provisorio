package com.example.demo.dominio;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "reservas", indexes = {
        @Index(name = "fk_Atleta_has_Quadra_Quadra1_idx", columnList = "Quadra"),
        @Index(name = "fk_Reservas_Atleta1_idx", columnList = "responsavel")
})
@Entity
public class Reserva {
    @Id
    @Column(name = "horaPartida", nullable = false)
    private Instant id;

    @Column(name = "Quadra", nullable = false)
    private Integer quadra;

    @Column(name = "responsavel", nullable = false)
    private Integer responsavel;

    @Column(name = "qtdAtletas", length = 45)
    private String qtdAtletas;

    @Column(name = "valorReserva", length = 45)
    private String valorReserva;

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

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getQuadra() {
        return quadra;
    }

    public void setQuadra(Integer quadra) {
        this.quadra = quadra;
    }

    public Instant getId() {
        return id;
    }

    public void setId(Instant id) {
        this.id = id;
    }
}