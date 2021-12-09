package com.example.demo.repositorio;

import com.example.demo.dominio.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
}
