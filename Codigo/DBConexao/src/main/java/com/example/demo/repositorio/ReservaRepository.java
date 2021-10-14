package com.example.demo.repositorio;

import com.example.demo.dominio.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservaRepository extends JpaRepository<Reserva, LocalDateTime> {
}