package com.example.demo.repositorio;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findAllByOrderByHoraPartidaAsc();

}