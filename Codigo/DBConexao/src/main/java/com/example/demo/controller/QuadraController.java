package com.example.demo.controller;

import com.example.demo.dominio.Endereco;
import com.example.demo.dominio.Quadra;
import com.example.demo.exportacao.GravaLista;
import com.example.demo.exportacao.GravaTxt;
import com.example.demo.lista.ListaObj;
import com.example.demo.repositorio.EnderecoRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quadras")
public class QuadraController {

    @Autowired
    private QuadraRepository quadraRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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
    public ResponseEntity putQuadra(@PathVariable int id,
                                    @RequestBody Quadra quadraAtt) {
        if (quadraRepository.existsById(id)) {
            quadraAtt.setIdQuadra(id);
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

    @PatchMapping("/foto/{id}")
    public ResponseEntity patchFoto(@PathVariable Integer id,
                                    @RequestParam MultipartFile foto) throws IOException {

        Quadra quadra = quadraRepository.findById(id).get();

        byte[] novaFoto = foto.getBytes();

        long tamanho = foto.getSize();

        if (tamanho > 15_728_640.0) {
            return ResponseEntity.status(413).build();
        }

        quadra.setFoto(novaFoto);

        quadraRepository.save(quadra);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/foto/{id}")
    public ResponseEntity gerFoto(@PathVariable Integer id) throws IOException {

        Quadra q = quadraRepository.findById(id).get();

        byte[] foto = q.getFoto();

        return ResponseEntity
                .status(200)
                .header("content-type", "image/jpeg")
                .body(foto);
    }
    @GetMapping("/csv")
    public ResponseEntity getCsv() {
        GravaLista g = new GravaLista();
        ListaObj<Quadra> listaQuadra = new ListaObj<>((int) quadraRepository.count());
        for (Quadra q : quadraRepository.findAll()) {
            listaQuadra.adiciona(q);
        }
        g.gravaLista(listaQuadra, "teste");
        return ResponseEntity.status(204).build();
    }
}