package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.HorarioQuadra;
import com.example.demo.dominio.Quadra;
import com.example.demo.dominio.Reserva;
import com.example.demo.fila.FilaCircularObj;
import com.example.demo.repositorio.AtletaRepository;
import com.example.demo.repositorio.HorarioQuadraRepository;
import com.example.demo.repositorio.QuadraRepository;
import com.example.demo.repositorio.ReservaRepository;
import com.example.demo.requisicao.ReservaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HorarioQuadraRepository horarioQuadraRepository;

    @Autowired
    private QuadraRepository quadraRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    public FilaCircularObj filaCircularObj;

    @PostMapping("")
    public ResponseEntity postReserva(@RequestBody ReservaDTO reservaRequest) {
        Reserva r = new Reserva();
        HorarioQuadra h = horarioQuadraRepository.findById(reservaRequest.getHorario()).get();
        r.setHoraPartida(h.getDataQuadra());
        r.setValorReserva(reservaRequest.getValorReserva());
        r.setQuadra(quadraRepository.findById(reservaRequest.getQuadra()).get());
        r.setResponsavel(atletaRepository.findById(reservaRequest.getAtleta()).get());
        r.setQtdAtletas(reservaRequest.getQtdAtletas());

        reservaRepository.save(r);
        horarioQuadraRepository.deleteById(reservaRequest.getHorario());
        return ResponseEntity.status(201).build();
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

    @GetMapping("/reservas-atleta/{idAtleta}")
    public ResponseEntity getReservaByAtleta(@PathVariable Integer idAtleta) {
        List<Reserva> reservasAtleta = this.reservaRepository.findAll().stream().filter(reserva -> reserva.getResponsavel().getId().equals(idAtleta)).collect(Collectors.toList());
        if (reservasAtleta.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(reservasAtleta);

    }

    @GetMapping("/reservas-quadra/{idQuadra}")
    public ResponseEntity getReservaByQuadra(@PathVariable Integer idQuadra) {
        List<Reserva> reservasQuadra = this.reservaRepository.findAll().stream().filter(reserva -> reserva.getQuadra().getIdQuadra().equals(idQuadra)).collect(Collectors.toList());
        if (reservasQuadra.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(reservasQuadra);
    }

    //    INICIO FILA

    public ResponseEntity postFilaReservasAtleta(Integer idAtleta) {
        List<Reserva> reservasAtleta = this.reservaRepository.findAllByOrderByHoraPartidaAsc().stream().filter(reserva -> reserva.getResponsavel().getId().equals(idAtleta)).collect(Collectors.toList());
        if (!reservasAtleta.isEmpty()) {
            this.filaCircularObj = new FilaCircularObj<Object>(reservasAtleta.size());
            for (int i = 0; i < reservasAtleta.size(); i++) {
                if (reservasAtleta.get(i).getHoraPartida().isAfter(LocalDateTime.now())) {
                    filaCircularObj.insert(reservasAtleta.get(i));
                }
            }
            return ResponseEntity.status(200).body(this.filaCircularObj.exibe());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/lista-horarios-atleta/{idAtleta}")
    public ResponseEntity getFilaReservasAtleta(@PathVariable Integer idAtleta) {
        return ResponseEntity.status(200).body(postFilaReservasAtleta(idAtleta));
    }

    @GetMapping("/peek-horarios-atleta")
    public ResponseEntity peekFilaReservasAtleta() {
        if (this.filaCircularObj.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filaCircularObj.peek());
    }

    @DeleteMapping("/poll-horarios-atleta")
    public ResponseEntity pollFilaReservasAtleta() {
        if (this.filaCircularObj.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        Reserva reserva = (Reserva) this.filaCircularObj.poll();
        return ResponseEntity.status(200).body(reserva);
    }

    public ResponseEntity postFilaReservasQuadra(Integer idQuadra) {
        List<Reserva> reservasAtleta = this.reservaRepository.findAllByOrderByHoraPartidaAsc().stream().filter(reserva -> reserva.getQuadra().getIdQuadra().equals(idQuadra)).collect(Collectors.toList());
        if (!reservasAtleta.isEmpty()) {
            this.filaCircularObj = new FilaCircularObj<Object>(reservasAtleta.size());
            for (int i = 0; i < reservasAtleta.size(); i++) {
                if (reservasAtleta.get(i).getHoraPartida().isAfter(LocalDateTime.now())) {
                    filaCircularObj.insert(reservasAtleta.get(i));
                }
            }
            return ResponseEntity.status(200).body(this.filaCircularObj.exibe());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/lista-horarios-quadra/{idQuadra}")
    public ResponseEntity getFilaReservasQuadra(@PathVariable Integer idQuadra) {
        return ResponseEntity.status(200).body(postFilaReservasQuadra(idQuadra));
    }

    @GetMapping("/peek-horarios-quadra")
    public ResponseEntity peekFilaReservasQuadra() {
        if (this.filaCircularObj.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(this.filaCircularObj.peek());
    }

    @DeleteMapping("/poll-horarios-quadra")
    public ResponseEntity pollFilaReservasQuadra() {
        if (this.filaCircularObj.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        Reserva reserva = (Reserva) this.filaCircularObj.poll();
        return ResponseEntity.status(200).body(reserva);
    }

    // FIM FILA


    // INICIO PILHA


    // FIM PILHA


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
