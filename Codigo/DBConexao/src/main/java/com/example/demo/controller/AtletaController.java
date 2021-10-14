package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.repositorio.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atletas")
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    @PostMapping
    public ResponseEntity postQuadra(@RequestBody Atleta a) {
        atletaRepository.save(a);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity postLogin(@RequestPart String email, @RequestPart String senha){
        for(Atleta a: atletaRepository.findAll()){
            if(a.getEmail().equals(email) && a.getSenha().equals(senha)){
                return ResponseEntity.status(201).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAtleta(@PathVariable int id) {
        return ResponseEntity.of(atletaRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAtleta(@PathVariable int id) {
        if (atletaRepository.existsById(id)) {
            atletaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getAtletas() {
        List<Atleta> atletas = atletaRepository.findAll();
        if (atletas.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(atletas);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putAtletas(@PathVariable int id,
                                  @RequestBody Atleta atletaAtt) {
        if (atletaRepository.existsById(id)) {
            atletaAtt.setId(id);
            atletaRepository.save(atletaAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getAtletasTotal() {
        Long total = atletaRepository.count();
        return ResponseEntity.status(200).body(total);
    }
}
