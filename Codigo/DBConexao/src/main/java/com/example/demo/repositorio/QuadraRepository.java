package com.example.demo.repositorio;

import com.example.demo.dominio.Quadra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface QuadraRepository extends JpaRepository<Quadra, Integer> {
    List<Quadra> findQuadrasByNomeQuadraIsLike(String nome);

    @Query("SELECT u FROM Quadra u where u.fkEndereco in (select e from Endereco e where e.cidade like ?1)")
    List<Quadra> findQuadrasByCidade(String cidade);

    @Query("SELECT u FROM Quadra u where u.dono in (select d from DonoQuadra d where d.id = :id)")
    List<Quadra> findQuadrasByDono(int id);
}