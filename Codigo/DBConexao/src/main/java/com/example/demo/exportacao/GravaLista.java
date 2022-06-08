package com.example.demo.exportacao;

import com.example.demo.dominio.Quadra;
import com.example.demo.lista.ListaObj;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class GravaLista {

    public GravaLista() {
    }

    public void gravaLista(ListaObj<Quadra> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq, true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.err.println("Erro ao abrir arquivo");
            System.exit(1);
        }

        try {
            for (int i=0; i< lista.getTamanho(); i++) {
                Quadra a = lista.getElemento(i);
                saida.format("%s;%s;%d;%d\n",a.getNomeQuadra(),
                                                a.getDescQuadra(),
                                                a.getLimitePessoas(),
                                                a.getClassificacaoQuadra());
            }
        }
        catch (FormatterClosedException erro) {
            System.err.println("Erro ao gravar no arquivo");
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.err.println("Erro ao fechar arquivo.");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
