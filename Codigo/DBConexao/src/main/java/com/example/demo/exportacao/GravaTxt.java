package com.example.demo.exportacao;

import com.example.demo.dominio.Quadra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GravaTxt {

    public void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        // Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        // Grava o registro e finaliza
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro na gravação do arquivo: " +
                    erro.getMessage());
        }

    }

    public void gravaArquivoTxt(List<Quadra> lista, String nomeArq) {

        int contaRegistro = 0;

        // Monta o registro de header
        String header = "00QUADRAS";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        // Grava o registro do header
        gravaRegistro(nomeArq, header);

        // Monta e grava o corpo
        String corpo;
        for (Quadra quadra : lista) {
            corpo = "02";
            corpo += String.format("%-30.30s", quadra.getNomeQuadra());
            corpo += String.format("%-100.100s", quadra.getDescQuadra());
            corpo += String.format("%02d", quadra.getLimitePessoas());
            corpo += String.format("%02d", quadra.getClassificacaoQuadra());
            corpo += String.format("%-8.8s", quadra.getFkEndereco().getCep());
            corpo += String.format("%-30.30s", quadra.getFkEndereco().getLogradouro());
            corpo += String.format("%-20.20s", quadra.getComplemento());
            corpo += String.format("%06d", quadra.getNumero());
            corpo += String.format("%-30.30s", quadra.getFkEndereco().getBairro());
            corpo += String.format("%-30.30s", quadra.getFkEndereco().getCidade());
            corpo += String.format("%-2.2s", quadra.getFkEndereco().getEstado());
            gravaRegistro(nomeArq, corpo);
            contaRegistro++;
        }

        // Monta e grava o trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegistro);
        gravaRegistro(nomeArq, trailer);

    }
}

