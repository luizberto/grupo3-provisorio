package com.example.demo.exportacao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeExibeArquivo {

    public void leExibeArquivo(String nomeArq) {
        FileReader arq= null;
        Scanner entrada = null;
        boolean deuRuim= false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {

            System.out.printf("%20s %30s %-17d %-23d %-11d\n\n","Nome da Quadra","Descrição da Quadra","Limite de Pessoas", "Classificação da Quadra", "Id Endereco");

            while (entrada.hasNext()) {
                String nomeQuadra = entrada.next();
                String descQuadra = entrada.next();
                Integer limitePessoas = entrada.nextInt();
                Integer classificacaoQuadra = entrada.nextInt();
                Integer enderecoIdendereco = entrada.nextInt();
                System.out.printf("%20s %30s %-17d %-23d %-11d\n",nomeQuadra,descQuadra,limitePessoas,classificacaoQuadra,enderecoIdendereco);
            }
        }
        catch (NoSuchElementException erro)
        {
            System.err.println("Arquivo com problemas.");
            deuRuim = true;
        }
        catch (IllegalStateException erro)
        {
            System.err.println("Erro na leitura do arquivo.");
            deuRuim = true;
        }
        finally {
            entrada.close();
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
