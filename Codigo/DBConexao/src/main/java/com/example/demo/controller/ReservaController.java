package com.example.demo.controller;

import com.example.demo.dominio.Reserva;
import com.example.demo.repositorio.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping
    public ResponseEntity postReserva(@RequestBody Reserva novaReserva) {
        this.reservaRepository.save(novaReserva);
        return ResponseEntity.status(201).body(novaReserva);
    }

    @GetMapping
    public ResponseEntity getReservas() {
        List<Reserva> reservas = this.reservaRepository.findAllByOrderByHoraPartidaAsc();
        if (reservas.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(reservas);
        }
    }

    @GetMapping("/{idReserva}")
    public ResponseEntity getReservaById(@PathVariable Integer idReserva) {
        return ResponseEntity.of(this.reservaRepository.findById(idReserva));
    }

    @DeleteMapping("/{idReserva}")
    public ResponseEntity deleteReserva(@PathVariable int idReserva) {
        if (this.reservaRepository.existsById(idReserva)) {
            this.reservaRepository.deleteById(idReserva);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{idReserva}")
    public ResponseEntity putReserva(@PathVariable int idReserva,
                                     @RequestBody Reserva reservaAtt) {
        if (this.reservaRepository.existsById(idReserva)) {
            reservaAtt.setIdReserva(idReserva);
            this.reservaRepository.save(reservaAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getQuadrasTotal() {
        Long total = this.reservaRepository.count();
        return ResponseEntity.status(200).body(total);
    }
}
