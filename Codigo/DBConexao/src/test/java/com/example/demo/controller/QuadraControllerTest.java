package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.Endereco;
import com.example.demo.dominio.Quadra;
import com.example.demo.repositorio.EnderecoRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {QuadraController.class, QuadraRepository.class})
class QuadraControllerTest {

    @Autowired
    QuadraController quadraController;

    @MockBean
    QuadraRepository quadraRepository;

    @MockBean
    EnderecoRepository enderecoRepository;

    @Test
    void retornarStatus204SeGetQuadrasSemCorpo() {
        when(this.quadraRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = this.quadraController.getQuadras();
        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeGetQuadrasComCorpo() {
        List<Quadra> listaQuadrasMock = List.of(mock(Quadra.class), mock(Quadra.class));
        when(this.quadraRepository.findAll()).thenReturn(listaQuadrasMock);
        ResponseEntity resposta = this.quadraController.getQuadras();
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(listaQuadrasMock, resposta.getBody());
    }

    @Test
    void retornarStatus404SeDeleteQuadraNaoExiste() {
        Integer idTeste = 12;
        when(this.quadraRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.quadraController.deleteQuadra(idTeste);
        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeGetQuadraExiste() {
        Integer idTeste = 12;
        when(this.quadraRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.quadraController.deleteQuadra(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus404SeGetQuadraNaoExiste() {
        Integer idTeste = 12;
        when(this.quadraRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.quadraController.getQuadra(idTeste);
        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SePutQuadraExiste() {
        Integer idTeste = 12;
        Quadra quadra = mock(Quadra.class);
        when(this.quadraRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.quadraController.putQuadra(idTeste, quadra);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus404SePutQuadraNaoExiste() {
        Integer idTeste = 12;
        Quadra quadra = mock(Quadra.class);
        when(this.quadraRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.quadraController.putQuadra(idTeste, quadra);
        assertEquals(200, resposta.getStatusCodeValue());
    }
}
