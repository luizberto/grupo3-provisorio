package com.example.demo.controller;

import com.example.demo.dominio.Atleta;
import com.example.demo.dominio.Endereco;
import com.example.demo.dominio.Quadra;
import com.example.demo.exportacao.GravaTxt;
import com.example.demo.repositorio.AtletaRepository;
import com.example.demo.repositorio.EnderecoRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/txt")
public class TxtController {

    @Autowired
    private QuadraRepository quadraRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping("/quadra")
    public ResponseEntity getTxt() {
        List<Quadra> listaQuadras = this.quadraRepository.findAll();
        if (listaQuadras.size() > 0) {
            GravaTxt gravarTxt = new GravaTxt();
            gravarTxt.gravaArquivoTxt(listaQuadras, "export.txt");
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(404).build();
    }

//    @GetMapping("/atleta")
//    public ResponseEntity getTxtAtleta() {
//        List<Atleta> listaAtletas = this.atletaRepository.findAll();
//        if (listaAtletas.size() > 0) {
//            GravaTxt gravarTxt = new GravaTxt();
//            gravarTxt.gravaAtletaTxt(listaAtletas, "atletas.txt");
//            return ResponseEntity.status(201).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

    @PostMapping("/import")
    public ResponseEntity importTxt(@RequestParam MultipartFile txt) throws IOException {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        int contaRegDados = 0;
        int qtdRegGravados = 0;

        List<Object> listaLida = new ArrayList();

        // Abre o arquivo para leitura
        try {
            System.out.println("TXT " + txt.getName() + " name");
            entrada = new BufferedReader(new FileReader(txt.getResource().getFile().getPath()));
            System.out.println("Arquivo Aberto");
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        // Leitura do arquivo
        try {
            registro = entrada.readLine();  // Lê o primeiro registro do arquivo

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("----------Header----------");
                    System.out.println("Tipo do arquivo: " + registro.substring(2, 9));
                    System.out.println("Data e hora de gravação: " + registro.substring(9, 28));
                    System.out.println("Versão do documento: " + registro.substring(28, 30));
                    if (qtdRegGravados == contaRegDados) {
                        System.out.println("Quantidade de registros lidos compatível com quantidade de registros gravados");
                    } else {
                        System.out.println("Quantidade de registros lidos incompatível com quantidade de registros gravados");
                    }
                    tipoRegistro = registro.substring(0, 2);
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("----------Registro do Body (Quadra)----------");
                    // Lê os dados do registro de corpo
                    String nomeQuadra = registro.substring(2, 32).trim();
                    String descQuadra = registro.substring(32, 132).trim();
                    Integer limitePessoas = Integer.valueOf(registro.substring(132, 134));
                    Double classificacaoQuadra = Double.valueOf(registro.substring(134, 139));
                    String cep = registro.substring(139, 147).trim();
                    String logradouro = registro.substring(147, 177).trim();
                    String complemento = registro.substring(177, 197).trim();
                    Integer numero = Integer.valueOf(registro.substring(197, 203));
                    String bairro = registro.substring(203, 233).trim();
                    String cidade = registro.substring(233, 263).trim();
                    String estado = registro.substring(263, 265).trim();

                    // Cria um objeto Quadra com os dados lidos do registro
                    Quadra quadra = new Quadra();
                    quadra.setNomeQuadra(nomeQuadra);
                    quadra.setDescQuadra(descQuadra);
                    quadra.setLimitePessoas(limitePessoas);
                    quadra.setClassificacaoQuadra(classificacaoQuadra);
                    quadra.setComplemento(complemento);
                    quadra.setNumero(numero);

                    // Cria um objeto Endereco com os dados lidos do registro
                    Endereco endereco = new Endereco();
                    endereco.setCep(cep);
                    endereco.setLogradouro(logradouro);
                    endereco.setBairro(bairro);
                    endereco.setCidade(cidade);
                    endereco.setEstado(estado);

                    this.enderecoRepository.save(endereco);
                    quadra.setFkEndereco(endereco);
                    this.quadraRepository.save(quadra);

                    // Adiciona esse objeto à listaLida
                    listaLida.add(quadra);
                    // Incrementa o contador de registros de dados lidos
                    contaRegDados++;
                    tipoRegistro = registro.substring(0, 2);

                } else if (tipoRegistro.equals("03")) {
                    System.out.println("----------Registro do Body (Atleta)----------");

                    String cpf = registro.substring(02, 13).trim();
                    String nomeAtleta = registro.substring(13, 43).trim();
                    String email = registro.substring(43, 83).trim();
                    String senha = registro.substring(83, 103).trim();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dataNasc = LocalDate.parse(registro.substring(103, 113), formatter);
                    String cep = registro.substring(113, 121).trim();
                    String logradouro = registro.substring(121, 151).trim();
                    String complemento = registro.substring(151, 171).trim();
                    Integer numero = Integer.valueOf(registro.substring(171, 177));
                    String bairro = registro.substring(177, 207).trim();
                    String cidade = registro.substring(207, 237).trim();
                    String estado = registro.substring(237, 239).trim();

                    //Criando Atleta
                    Atleta atleta = new Atleta();
                    atleta.setCpf(cpf);
                    atleta.setNomeAtleta(nomeAtleta);
                    atleta.setEmail(email);
                    atleta.setSenha(senha);
                    atleta.setDataNasc(dataNasc);
                    atleta.setComplemento(complemento);
                    atleta.setNumero(numero);
//                    atleta.setDataNasc(dataNasc);


                    //Criando Endereço do Atleta
                    Endereco endereco = new Endereco();
                    endereco.setCep(cep);
                    endereco.setLogradouro(logradouro);
                    endereco.setBairro(bairro);
                    endereco.setCidade(cidade);
                    endereco.setEstado(estado);

                    this.enderecoRepository.save(endereco);
                    atleta.setFkEndereco(endereco);
                    this.atletaRepository.save(atleta);

                    // Adiciona esse objeto à listaLida
                    listaLida.add(atleta);
                    // Incrementa o contador de registros de dados lidos
                    contaRegDados++;
                    tipoRegistro = registro.substring(0, 2);
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("----------Trailer----------");
                    // Lê a quantidade de registros gravados que está no trailer
                    qtdRegGravados = Integer.valueOf(registro.substring(2, 12));
                    // Valida se a quantidade lida é igual a quantidade gravada
                } else {
                    System.out.println("Tipo de registro inválido");
                }

                // lê o próximo registro
                registro = entrada.readLine();
            }

            // Fecha o arquivo
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo: " + erro.getMessage());
        }

        // Exibe a listaLida
        System.out.println("\nConteúdo lido do arquivo:");
        for (Object q : listaLida) {
            System.out.println(q);
        }


        return ResponseEntity.status(201).body(listaLida);
    }
}

