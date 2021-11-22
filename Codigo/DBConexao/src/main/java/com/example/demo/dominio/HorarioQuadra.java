package com.example.demo.dominio;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
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

    @Column(name = "dataQuadra")
    private LocalDateTime data_quadra;

    @Column(name = "fk_quadra")
    private Integer fkQuadra;

    public Integer getFkQuadra() {
        return fkQuadra;
    }

    public void setFkQuadra(Integer fkQuadra) {
        this.fkQuadra = fkQuadra;
    }

    public LocalDateTime getData() {
        return data_quadra;
    }

    public void setData(LocalDateTime data) {
        this.data_quadra = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}