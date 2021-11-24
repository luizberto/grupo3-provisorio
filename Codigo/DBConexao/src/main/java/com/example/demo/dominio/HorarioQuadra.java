package com.example.demo.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "horario_quadra", indexes = {
        @Index(name = "fk_quadra_idx", columnList = "fk_quadra")
})
@Entity
public class HorarioQuadra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario", nullable = false)
    private Integer id;

    @Column(name = "data_quadra")
    private LocalDateTime dataQuadra;

    @Column(name = "reservado")
    private String reserva;

    @Column(name = "fk_quadra")
    private Integer fkQuadra;

    public Integer getFkQuadra() {
        return fkQuadra;
    }

    public void setFkQuadra(Integer fkQuadra) {
        this.fkQuadra = fkQuadra;
    }

    public LocalDateTime getData() {
        return dataQuadra;
    }

    public void setData(LocalDateTime data) {
        this.dataQuadra = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }
}