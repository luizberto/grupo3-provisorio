package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.DonoQuadra;
import com.example.demo.dominio.Login;
import com.example.demo.repositorio.AtletaRepository;
import com.example.demo.repositorio.DonoQuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adm")
public class DonoController {
    @Autowired
    private DonoQuadraRepository donoRepository;

    @PostMapping
    public ResponseEntity postQuadra(@RequestBody DonoQuadra d) {
        donoRepository.save(d);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity postLogin(@RequestBody Login login){
        for(DonoQuadra d: donoRepository.findAll()){
            if(d.getEmail().equals(login.getEmail()) && d.getSenha().equals(login.getSenha())){
                return ResponseEntity.status(201).build();
            }
        }
        return ResponseEntity.status(418).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getAtleta(@PathVariable int id) {
        return ResponseEntity.of(donoRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAtleta(@PathVariable int id) {
        if (donoRepository.existsById(id)) {
            donoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getAtletas() {
        List<DonoQuadra> donos = donoRepository.findAll();
        if (donos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(donos);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putAtletas(@PathVariable int id,
                                     @RequestBody DonoQuadra donoAtt) {
        if (donoRepository.existsById(id)) {
            donoAtt.setId(id);
            donoRepository.save(donoAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getAtletasTotal() {
        Long total = donoRepository.count();
        return ResponseEntity.status(200).body(total);
    }
}
