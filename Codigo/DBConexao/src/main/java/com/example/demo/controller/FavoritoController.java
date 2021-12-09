package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.Favorito;
import com.example.demo.dominio.Quadra;
import com.example.demo.pilha.PilhaObj;
import com.example.demo.repositorio.AtletaRepository;
import com.example.demo.repositorio.FavoritoRepository;
import com.example.demo.repositorio.QuadraRepository;
import com.example.demo.requisicao.FavoritoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity postFavorito(@RequestBody FavoritoDTO favoritoDTO) {
        Favorito favorito = new Favorito();
        for (Favorito f : favoritoRepository.findAll()) {
            if (f.getAtleta().getId().equals(favoritoDTO.getIdUsuario()) &&
                    f.getQuadra().getIdQuadra().equals(favoritoDTO.getIdQuadra())) {
                return ResponseEntity.status(204).build();
            }
        }

        Atleta atleta = atletaRepository.findById(favoritoDTO.getIdUsuario()).get();
        Quadra quadraFav = quadraRepository.findById(favoritoDTO.getIdQuadra()).get();

        favorito.setAtleta(atleta);
        favorito.setQuadra(quadraFav);

        this.favoritoRepository.save(favorito);

        List<Quadra> quadraFavorita = this.quadraRepository.findAll().stream().filter(quadra -> quadra.getIdQuadra().equals(favorito.getQuadra().getIdQuadra())).collect(Collectors.toList());
        pilhaObj.push(quadraFavorita);

        return ResponseEntity.status(201).body(pilhaObj.peek());
    }

    @GetMapping("/{id}")
    public ResponseEntity getFavoritos(@PathVariable int id) {
//       List<Favorito> listaFavoritos = this.favoritoRepository.findAll().stream().map(favorito -> ;
//        return ResponseEntity.status(200).body(listaFavoritos);
        List<Quadra> listaQuadra = new ArrayList<>();
        for(Favorito f: this.favoritoRepository.findAll()){
            if(f.getAtleta().getId().equals(id)) {
                listaQuadra.add(f.getQuadra());
            }
        }
        return ResponseEntity.status(200).body(listaQuadra);
    }

    @DeleteMapping
    public ResponseEntity deleteFavorito() {
        if (!pilhaObj.isEmpty()) {
            List<Quadra> pop = pilhaObj.peek();
            Integer idQuadra = null;
            for (Quadra quadra : pop) {
                idQuadra = quadra.getIdQuadra();
            }
            Integer idRemove = idQuadra;
            List<Favorito> favoritoId = this.favoritoRepository.findAll().stream().filter(favorito -> favorito.getQuadra().getIdQuadra().equals(idRemove)).collect(Collectors.toList());
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