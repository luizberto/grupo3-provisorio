package com.example.demo.controller;

import com.example.demo.dominio.Quadra;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quadras")
public class QuadraController {
    @Autowired QuadraRepository quadraRepository;

    @PostMapping
    public ResponseEntity postQuadra(@RequestBody Quadra quadra) {
        quadraRepository.save(quadra);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuadra(@PathVariable int id) {
        return ResponseEntity.of(quadraRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuadra(@PathVariable int id) {
        if (quadraRepository.existsById(id)) {
            quadraRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getQuadras() {
        List<Quadra> quadras = quadraRepository.findAll();
        if (quadras.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(quadras);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putJogo(@PathVariable int id,
                                  @RequestBody Quadra quadraAtt) {
        if (quadraRepository.existsById(id)) {
            quadraAtt.setId(id);
            quadraRepository.save(quadraAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getQuadrasTotal() {
        Long total = quadraRepository.count();

        return ResponseEntity.status(200).body(total);
    }
}
