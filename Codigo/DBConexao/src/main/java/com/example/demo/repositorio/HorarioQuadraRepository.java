package com.example.demo.repositorio;

import com.example.demo.dominio.HorarioQuadra;
import com.example.demo.dominio.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioQuadraRepository extends JpaRepository<HorarioQuadra, Integer> {

    @Query("SELECT h FROM HorarioQuadra h where h.fkQuadra = (select q from Quadra q where q.idQuadra = ?1)")
    List<HorarioQuadra> findHorarioQuadraByFk(int id);
}