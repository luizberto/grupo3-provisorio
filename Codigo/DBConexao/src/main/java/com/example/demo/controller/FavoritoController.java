package com.example.demo.controller;

import com.example.demo.dominio.Favorito;
import com.example.demo.dominio.Quadra;
import com.example.demo.pilha.PilhaObj;
import com.example.demo.repositorio.AtletaRepository;
import com.example.demo.repositorio.FavoritoRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoRepository favoritoRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    @Autowired
    private QuadraRepository quadraRepository;

    private PilhaObj<List> pilhaObj = new PilhaObj<List>(100);

    @PostMapping
    public ResponseEntity postFavorito(@RequestBody Favorito favorito) {
        List<Favorito> favoritos = this.favoritoRepository.findAll().stream().filter(favorito1 -> favorito1.getQuadra().getId().equals(favorito.getQuadra().getId())).collect(Collectors.toList());

        if (favoritos.isEmpty()) {
            this.favoritoRepository.save(favorito);
            List<Quadra> quadraFavorita = this.quadraRepository.findAll().stream().filter(quadra -> quadra.getId().equals(favorito.getQuadra().getId())).collect(Collectors.toList());
            pilhaObj.push(quadraFavorita);
            return ResponseEntity.status(201).body(pilhaObj.peek());
        }
        return ResponseEntity.status(406).build();
    }

    @GetMapping
    public ResponseEntity getFavoritos() {
//       List<Favorito> listaFavoritos = this.favoritoRepository.findAll().stream().map(favorito -> ;
//        return ResponseEntity.status(200).body(listaFavoritos);

        return ResponseEntity.status(200).body(this.favoritoRepository.findAll());
    }

    @DeleteMapping
    public ResponseEntity deleteFavorito() {
        if (!pilhaObj.isEmpty()) {
            List<Quadra> pop = pilhaObj.peek();
            Integer idQuadra = null;
            for (Quadra quadra : pop) {
                idQuadra = quadra.getId();
            }
            Integer idRemove = idQuadra;
            List<Favorito> favoritoId = this.favoritoRepository.findAll().stream().filter(favorito -> favorito.getQuadra().getId().equals(idRemove)).collect(Collectors.toList());
            this.favoritoRepository.deleteById(favoritoId.stream().findAny().get().getIdFavorito());
            pilhaObj.pop();
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(406).build();
    }

    @DeleteMapping("/{idDelete}")
    public ResponseEntity deleteById(@PathVariable int idDelete) {
        if (this.favoritoRepository.existsById(idDelete)) {
            this.favoritoRepository.deleteById(idDelete);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}