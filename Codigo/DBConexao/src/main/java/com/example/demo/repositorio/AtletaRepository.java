package com.example.demo.repositorio;

import com.example.demo.dominio.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {
}