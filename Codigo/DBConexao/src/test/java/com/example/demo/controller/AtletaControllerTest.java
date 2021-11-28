package com.example.demo.controller;


import com.example.demo.dominio.Atleta;
import com.example.demo.repositorio.AtletaRepository;
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

@SpringBootTest(classes = {AtletaController.class, AtletaRepository.class})
class AtletaControllerTest {

    @Autowired
    AtletaController atletaController;

    @MockBean
    AtletaRepository atletaRepository;

    @Test
    void retornarStatus204SeGetAtletasSemCorpo() {
        when(this.atletaRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = this.atletaController.getAtletas();
        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeGetAtletasComCorpo() {
        List<Atleta> listaAtletasMock = List.of(mock(Atleta.class), mock(Atleta.class));
        when(this.atletaRepository.findAll()).thenReturn(listaAtletasMock);
        ResponseEntity resposta = this.atletaController.getAtletas();
        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(listaAtletasMock, resposta.getBody());
    }

    @Test
    void retornarStatus404SeDeleteAtletaNaoExiste() {
        Integer idTeste = 12;
        when(this.atletaRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.atletaController.deleteAtleta(idTeste);
        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeDeleteAtletaExiste() {
        Integer idTeste = 12;
        when(this.atletaRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = atletaController.deleteAtleta(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus404SeGetAtletaNaoExiste() {
        Integer idTeste = 12;
        when(this.atletaRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.atletaController.getAtleta(idTeste);
        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }

    @Test
    void retornarStatus200SeGetAtletaExiste() {
        Integer idTeste = 12;
        when(this.atletaRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = this.atletaController.deleteAtleta(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus404SePutAtletaNaoExiste() {
        Integer idTeste = 12;
        Atleta atleta = mock(Atleta.class);
        when(this.atletaRepository.existsById(idTeste)).thenReturn(false);
        ResponseEntity resposta = this.atletaController.putAtletas(idTeste, atleta);
        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void retornarStatus200SePutAtletaExiste() {
        Integer idTeste = 12;
        when(this.atletaRepository.existsById(idTeste)).thenReturn(true);
        ResponseEntity resposta = atletaController.deleteAtleta(idTeste);
        assertEquals(200, resposta.getStatusCodeValue());
    }
}