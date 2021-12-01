package com.example.demo.controller;

import com.example.demo.dominio.Reserva;
import com.example.demo.repositorio.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ReservaRepository.class, ReservaController.class})
class ReservaControllerTest {

    @Autowired
    ReservaController reservaController;

    @MockBean
    ReservaRepository reservaRepository;

    @Test
    void retornarStatus204SeGetReservasSemCorpo() {
        when(this.reservaRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = this.reservaController.getReservas();
        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeGetReservasComCorpo() {
        List<Reserva> reservas = List.of(mock(Reserva.class));
        when(this.reservaRepository.findAll()).thenReturn(reservas);
        ResponseEntity resposta = this.reservaController.getReservas();
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus404SeGetReservasByAtletaSemCorpo() {
        Integer idTeste = 12;
        when(this.reservaRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.reservaController.getReservaByAtleta(idTeste);
        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }
}