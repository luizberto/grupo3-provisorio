package com.example.demo.controller;

import com.example.demo.dominio.HorarioQuadra;
import com.example.demo.repositorio.HorarioQuadraRepository;
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

@SpringBootTest(classes = {HorarioQuadraRepository.class, HorarioController.class})
class HorarioControllerTest {

    @Autowired
    HorarioController horarioController;

    @MockBean
    HorarioQuadraRepository horarioQuadraRepository;

    @Test
    void retornarStatus204SeGetHorariosSemCorpo() {
        when(this.horarioQuadraRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = this.horarioController.getHorarios();
        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeGetHorariosComCorpo() {
        List<HorarioQuadra> listaHorariosMock = List.of(mock(HorarioQuadra.class), mock(HorarioQuadra.class));
        when(this.horarioQuadraRepository.findAll()).thenReturn(listaHorariosMock);
        ResponseEntity resposta = this.horarioController.getHorarios();
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(listaHorariosMock, resposta.getBody());
    }

    @Test
    void retornarStatus404SeDeleteHorarioNaoExiste() {
        Integer idTeste = 12;
        when(this.horarioQuadraRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.horarioController.deleteHorario(idTeste);
        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeDeleteHorarioExiste() {
        Integer idTeste = 12;
        when(this.horarioQuadraRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.horarioController.deleteHorario(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus200SeGetHorarioExiste() {
        Integer idTeste = 12;
        when(this.horarioQuadraRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.horarioController.getHorario(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus200SePutHorarioExiste() {
        Integer idTeste = 12;
        HorarioQuadra horarioQuadra = mock(HorarioQuadra.class);
        when(this.horarioQuadraRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.horarioController.putAtletas(idTeste, horarioQuadra);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus404SePutHorarioNaoExiste() {
        Integer idTeste = 12;
        HorarioQuadra horarioQuadra = mock(HorarioQuadra.class);
        when(this.horarioQuadraRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.horarioController.putAtletas(idTeste, horarioQuadra);
        assertEquals(404, resposta.getStatusCodeValue());
    }
}