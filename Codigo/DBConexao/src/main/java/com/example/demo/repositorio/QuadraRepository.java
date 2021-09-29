package com.example.demo.repositorio;

import com.example.demo.dominio.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuadraRepository extends JpaRepository<Quadra, Integer> {
}