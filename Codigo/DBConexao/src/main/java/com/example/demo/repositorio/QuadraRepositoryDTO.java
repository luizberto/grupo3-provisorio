package com.example.demo.repositorio;

import com.example.demo.requisicao.QuadraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuadraRepositoryDTO extends JpaRepository<QuadraDTO, Integer> {
    List<QuadraDTO> findQuadrasByNomeQuadraIsLike(String nome);

    @Query("SELECT u FROM Quadra u where u.fkEndereco in (select e from Endereco e where e.cidade like ?1)")
    List<QuadraDTO> findQuadrasByCidade(String cidade);

    @Query("SELECT u FROM Quadra u where u.dono in (select d from DonoQuadra d where d.id = :id)")
    List<QuadraDTO> findQuadrasByDono(int id);

}