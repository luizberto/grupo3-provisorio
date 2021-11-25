package com.example.demo.controller;

import com.example.demo.dominio.Endereco;
import com.example.demo.dominio.Quadra;
import com.example.demo.exportacao.GravaLista;
import com.example.demo.exportacao.GravaTxt;
import com.example.demo.lista.ListaObj;
import com.example.demo.repositorio.EnderecoRepository;
import com.example.demo.repositorio.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/quadras")
public class QuadraController {
    @Autowired
    private QuadraRepository quadraRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public ResponseEntity postQuadra(@RequestBody Quadra quadra) {
        quadraRepository.save(quadra);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getQuadra(@PathVariable int id) {
        return ResponseEntity.of(quadraRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuadra(@PathVariable int id) {
        if (quadraRepository.existsById(id)) {
            quadraRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity getQuadras() {
        List<Quadra> quadras = quadraRepository.findAll();
        if (quadras.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(quadras);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putQuadra(@PathVariable int id,
                                    @RequestBody Quadra quadraAtt) {
        if (quadraRepository.existsById(id)) {
            quadraAtt.setId(id);
            quadraRepository.save(quadraAtt);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/total")
    public ResponseEntity getQuadrasTotal() {
        Long total = quadraRepository.count();

        return ResponseEntity.status(200).body(total);
    }

    @PatchMapping("/foto/{id}")
    public ResponseEntity patchFoto(@PathVariable Integer id,
                                    @RequestParam MultipartFile foto) throws IOException {

        Quadra quadra = quadraRepository.findById(id).get();

        byte[] novaFoto = foto.getBytes();

        long tamanho = foto.getSize();

        if (tamanho > 15_728_640.0) {
            return ResponseEntity.status(413).build();
        }

        quadra.setFoto(novaFoto);

        quadraRepository.save(quadra);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/csv")
    public ResponseEntity getCsv() {
        GravaLista g = new GravaLista();
        ListaObj<Quadra> listaQuadra = new ListaObj<>((int) quadraRepository.count());
        for (Quadra q : quadraRepository.findAll()) {
            listaQuadra.adiciona(q);
        }
        g.gravaLista(listaQuadra, "teste");
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/export-txt")
    public ResponseEntity getTxt() {
        List<Quadra> listaQuadras = this.quadraRepository.findAll();
        if (listaQuadras.size() > 0) {
            GravaTxt gravarTxt = new GravaTxt();
            gravarTxt.gravaArquivoTxt(listaQuadras, "quadras.txt");
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/import-txt/{nomeArq}")
    public ResponseEntity importTxt(@PathVariable String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nomeQuadra, descQuadra, cep, logradouro, complemento, bairro, cidade, estado;
        int limitePessoas,  numero;
        int contaRegDados = 0;
        int qtdRegGravados;
        Double classificacaoQuadra;

        List<Quadra> listaLida = new ArrayList();

        // Abre o arquivo para leitura
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
            System.out.println("Arquivo Aberto");
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                    erro.getMessage());
        }

        // Leitura do arquivo
        try {
            registro = entrada.readLine();  // Lê o primeiro registro do arquivo

            while (registro != null) {      // Enquanto não chegou ao final do arquivo
                // obtém o tipo do registro - primeiros 2 caracteres do registro
                // substring devolve um "pedaço da String",
                // que começa na posição 0 e termina na posição 1 (como num vetor)
                //    0123456
                //    00NOTA
                tipoRegistro = registro.substring(0, 2);

                // Verifica se o tipoRegistro é "00" (header), ou "01" (trailer) ou "02" (corpo)
                if (tipoRegistro.equals("00")) {
//                    System.out.println("Eh um header");
//                    System.out.println("Tipo do arquivo: " + registro.substring(2, 6));
//                    System.out.println("Ano/semestre: " + registro.substring(6, 11));
//                    System.out.println("Data e hora de gravação: " + registro.substring(11, 30));
//                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                } else if (tipoRegistro.equals("01")) {
//                    System.out.println("Eh um trailer");
//                    // Lê a quantidade de registros gravados que está no trailer
//                    qtdRegGravados = Integer.valueOf(registro.substring(2, 12));
//                    // Valida se a quantidade lida é igual a quantidade gravada
//                    if (qtdRegGravados == contaRegDados) {
//                        System.out.println("Quantidade de registros lidos compatível com quantidade de registros gravados");
//                    } else {
//                        System.out.println("Quantidade de registros lidos incompatível com quantidade de registros gravados");
//                    }
//                 tipoRegistro = registro.substring(0, 2);
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    // Lê os dados do registro de corpo
                    nomeQuadra = registro.substring(2, 32).trim();
                    descQuadra = registro.substring(32, 132).trim();
                    limitePessoas = Integer.valueOf(registro.substring(132, 134));
                    classificacaoQuadra = Double.valueOf(registro.substring(134, 136));
                    cep = registro.substring(136, 144).trim();
                    logradouro = registro.substring(144, 174).trim();
                    complemento = registro.substring(174, 194).trim();
                    numero = Integer.valueOf(registro.substring(194, 200));
                    bairro = registro.substring(200, 230).trim();
                    cidade = registro.substring(230, 260).trim();
                    estado = registro.substring(260, 262).trim();

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
//                    contaRegDados++;
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
        for (Quadra q : listaLida) {
            System.out.println(q);
        }

        return ResponseEntity.status(201).body(this.quadraRepository.findAll());
    }
}
