package com.example.demo.importacao;

import com.example.demo.dominio.Endereco;
import com.example.demo.dominio.Quadra;
import com.example.demo.repositorio.EnderecoRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportTxt {

    @Autowired
    private QuadraRepository quadraRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

//    public Object ImportArquivoTxt(String nomeArq) {
//        BufferedReader entrada = null;
//        String registro, tipoRegistro;
//        String nomeQuadra, descQuadra, cep, logradouro, complemento, bairro, cidade, estado;
//        int limitePessoas, classificacaoQuadra, numero;
//        int contaRegDados = 0;
//        int qtdRegGravados;
//
//        List<Quadra> listaLida = new ArrayList();
//
//        // Abre o arquivo para leitura
//        try {
//            entrada = new BufferedReader(new FileReader(nomeArq));
//            System.out.println("Arquivo Aberto");
//        } catch (IOException erro) {
//            System.out.println("Erro na abertura do arquivo: " +
//                    erro.getMessage());
//        }
//
//        // Leitura do arquivo
//        try {
//            registro = entrada.readLine();  // Lê o primeiro registro do arquivo
//
//            while (registro != null) {      // Enquanto não chegou ao final do arquivo
//                // obtém o tipo do registro - primeiros 2 caracteres do registro
//                // substring devolve um "pedaço da String",
//                // que começa na posição 0 e termina na posição 1 (como num vetor)
//                //    0123456
//                //    00NOTA
//                tipoRegistro = registro.substring(0, 2);
//
//                // Verifica se o tipoRegistro é "00" (header), ou "01" (trailer) ou "02" (corpo)
//                if (tipoRegistro.equals("00")) {
////                    System.out.println("Eh um header");
////                    System.out.println("Tipo do arquivo: " + registro.substring(2, 6));
////                    System.out.println("Ano/semestre: " + registro.substring(6, 11));
////                    System.out.println("Data e hora de gravação: " + registro.substring(11, 30));
////                    System.out.println("Versão do documento: " + registro.substring(30, 32));
//                } else if (tipoRegistro.equals("01")) {
////                    System.out.println("Eh um trailer");
////                    // Lê a quantidade de registros gravados que está no trailer
////                    qtdRegGravados = Integer.valueOf(registro.substring(2, 12));
////                    // Valida se a quantidade lida é igual a quantidade gravada
////                    if (qtdRegGravados == contaRegDados) {
////                        System.out.println("Quantidade de registros lidos compatível com quantidade de registros gravados");
////                    } else {
////                        System.out.println("Quantidade de registros lidos incompatível com quantidade de registros gravados");
////                    }
////                 tipoRegistro = registro.substring(0, 2);
//                } else if (tipoRegistro.equals("02")) {
//                    System.out.println("Eh um registro de corpo");
//                    // Lê os dados do registro de corpo
//                    nomeQuadra = registro.substring(2, 32).trim();
//                    descQuadra = registro.substring(32, 132);
//                    limitePessoas = Integer.valueOf(registro.substring(132, 134));
//                    classificacaoQuadra = Integer.valueOf(registro.substring(134, 136));
//                    cep = registro.substring(136, 144);
//                    logradouro = registro.substring(144, 174);
//                    complemento = registro.substring(174, 194);
//                    numero = Integer.valueOf(registro.substring(194, 200));
//                    bairro = registro.substring(200, 230);
//                    cidade = registro.substring(230, 260);
//                    estado = registro.substring(260, 262);
//                    // Cria um objeto Aluno com os dados lidos do registro
//                    Quadra quadra = new Quadra();
//                    quadra.setNomeQuadra(nomeQuadra);
//                    quadra.setDescQuadra(descQuadra);
//                    quadra.setLimitePessoas(limitePessoas);
//                    quadra.setClassificacaoQuadra(classificacaoQuadra);
//                    quadra.setComplemento(complemento);
//                    quadra.setNumero(numero);
//
//                    Endereco endereco = new Endereco();
//                    endereco.setCep(cep);
//                    endereco.setLogradouro(logradouro);
//                    endereco.setBairro(bairro);
//                    endereco.setCidade(cidade);
//                    endereco.setEstado(estado);
//
////                    this.enderecoRepository.save(endereco);
////                    quadra.setFkEndereco(endereco);
////                    this.quadraRepository.save(quadra);
//
//
//
//                    // Adiciona esse objeto à listaLida
//                    listaLida.add(quadra);
//                    // Incrementa o contador de registros de dados lidos
////                    contaRegDados++;
//                } else {
//                    System.out.println("Tipo de registro inválido");
//                }
//
//                // lê o próximo registro
//                registro = entrada.readLine();
//            }
//            return quadra;
//
//            // Fecha o arquivo
//            entrada.close();
//        } catch (IOException erro) {
//            System.out.println("Erro ao ler arquivo: " + erro.getMessage());
//        }
//
//        // Exibe a listaLida
//        System.out.println("\nConteúdo lido do arquivo:");
//        for (Quadra q : listaLida) {
//            System.out.println(q);
//        }
//
////            return ResponseEntity.status(201).body(this.quadraRepository.findAll());
//    }


}

