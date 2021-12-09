package com.example.demo.requisicao;

public class FavoritoDTO {
    private int idQuadra;
    private int idUsuario;

    public FavoritoDTO() {
    }

    public FavoritoDTO(int idQuadra, int idUsuario) {
        this.idQuadra = idQuadra;
        this.idUsuario = idUsuario;
    }

    public int getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(int idQuadra) {
        this.idQuadra = idQuadra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
