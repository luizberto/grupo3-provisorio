package com.example.demo.controller;

import com.example.demo.dominio.Endereco;
import com.example.demo.repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping("/enderecos") // This means URL's start with /demo (after Application path)
public class EnderecoController {
    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity postEndereco(@RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getJogo(@PathVariable int id) {
        return ResponseEntity.of(enderecoRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJogo(@PathVariable int id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        if (enderecos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(enderecos);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putEnderecos(@PathVariable int id,
                                  @RequestBody Endereco enderecoAtt) {
        if (enderecoRepository.existsById(id)) {
            enderecoAtt.setId(id);
            enderecoRepository.save(enderecoAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getEnderecosTotal() {
        Long total = enderecoRepository.count();

        return ResponseEntity.status(200).body(total);
    }
}
