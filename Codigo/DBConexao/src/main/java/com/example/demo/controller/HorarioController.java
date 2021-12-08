package com.example.demo.controller;

import com.example.demo.dominio.HorarioQuadra;
import com.example.demo.repositorio.HorarioQuadraRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    private HorarioQuadraRepository repository;

    @Autowired
    private QuadraRepository quadraRepository;


    @PostMapping("/{id}")
    public ResponseEntity postHorario(@RequestBody HorarioQuadra h, @PathVariable int id) {
        if(quadraRepository.existsById(id)){
            h.setFkQuadra(quadraRepository.findById(id).get());
            repository.save(h);
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity postReservar(@RequestBody HorarioQuadra horarioAtt, @PathVariable int id) {
        if (repository.existsById(id)) {
            horarioAtt.setId(id);
            repository.save(horarioAtt);
            return ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getHorario(@PathVariable int id) {
        List<HorarioQuadra> listaHora = repository.findHorarioQuadraByFk(id);
        return ResponseEntity.status(200).body(listaHora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHorario(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getHorarios() {
        List<HorarioQuadra> horarios = repository.findAll();
        if (horarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(horarios);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putAtletas(@PathVariable int id,
                                     @RequestBody HorarioQuadra horarioAtt) {
        if (repository.existsById(id)) {
            horarioAtt.setId(id);
            repository.save(horarioAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getHorariosTotal() {
        Long total = repository.count();
        return ResponseEntity.status(200).body(total);
    }
}
