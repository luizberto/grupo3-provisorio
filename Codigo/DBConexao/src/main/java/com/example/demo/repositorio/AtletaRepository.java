package com.example.demo.repositorio;

import com.example.demo.dominio.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
}