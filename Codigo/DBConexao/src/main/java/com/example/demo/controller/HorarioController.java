package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.HorarioQuadra;
import com.example.demo.dominio.Login;

import com.example.demo.repositorio.HorarioQuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    private HorarioQuadraRepository repository;

    @PostMapping
    public ResponseEntity postHorario(@RequestBody HorarioQuadra h) {
        repository.save(h);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getHorario(@PathVariable int id) {
        List<HorarioQuadra> listaHora = new ArrayList<>();
        for(HorarioQuadra h: repository.findAll()){
            if(h.getFkQuadra() == id){
                listaHora.add(h);
            }
        };
        return ResponseEntity.status(201).body(listaHora);
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
