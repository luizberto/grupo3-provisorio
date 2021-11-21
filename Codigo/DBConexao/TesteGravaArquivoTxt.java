import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TesteGravaArquivoTxt {

    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        // Abre o arquivo
        try {
            saida = new BufferedWriter (new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo: " +
                                erro.getMessage());
        }

        // Grava o registro e finaliza
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro na gravação do arquivo: " +
                               erro.getMessage());
        }

    }

    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq) {

        int contaRegistro = 0;

        // Monta o registro de header
        String header = "00NOTA20212";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        // Grava o registro do header
        gravaRegistro(nomeArq, header);

        // Monta e grava o corpo
        String corpo;
        for (Aluno a : lista) {
            corpo = "02";
            corpo += String.format("%-5.5s",a.getCurso());
            corpo += String.format("%-8.8s",a.getRa());
            corpo += String.format("%-50.50s", a.getNome());
            corpo += String.format("%-40.40s", a.getDisciplina());
            corpo += String.format("%05.2f", a.getMedia());
            corpo += String.format("%03d", a.getQtdFalta());
            gravaRegistro(nomeArq,corpo);
            contaRegistro++;
        }

        // Monta e grava o trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegistro);
        gravaRegistro(nomeArq,trailer);

    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String curso, ra, nome, disciplina;
        Double media;
        int qtdFalta;
        int contaRegDados = 0;
        int qtdRegGravados;

        List<Aluno> listaLida = new ArrayList();

        // Abre o arquivo para leitura
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
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
                tipoRegistro = registro.substring(0,2);

                // Verifica se o tipoRegistro é "00" (header), ou "01" (trailer) ou "02" (corpo)
                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um header");
                    System.out.println("Tipo do arquivo: "+registro.substring(2,6));
                    System.out.println("Ano/semestre: "+registro.substring(6,11));
                    System.out.println("Data e hora de gravação: "+registro.substring(11,30));
                    System.out.println("Versão do documento: "+registro.substring(30,32));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um trailer");
                    // Lê a quantidade de registros gravados que está no trailer
                    qtdRegGravados = Integer.valueOf(registro.substring(2,12));
                    // Valida se a quantidade lida é igual a quantidade gravada
                    if (qtdRegGravados == contaRegDados) {
                        System.out.println("Quantidade de registros lidos compatível com quantidade de registros gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros lidos incompatível com quantidade de registros gravados");
                    }

                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    // Lê os dados do registro de corpo
                    curso = registro.substring(2, 7).trim();
                    ra = registro.substring(7, 15);
                    nome = registro.substring(15, 65).trim();
                    disciplina = registro.substring(65, 105).trim();
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.valueOf(registro.substring(110,113));
                    // Cria um objeto Aluno com os dados lidos do registro
                    Aluno a = new Aluno(ra,nome,curso,disciplina,media,qtdFalta);
                    // Adiciona esse objeto à listaLida
                    listaLida.add(a);
                    // Incrementa o contador de registros de dados lidos
                    contaRegDados++;
                }
                else {
                    System.out.println("Tipo de registro inválido");
                }

                // lê o próximo registro
                registro = entrada.readLine();
            }

            // Fecha o arquivo
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler arquivo: " + erro.getMessage());
        }

        // Exibe a listaLida
        System.out.println("\nConteúdo lido do arquivo:");
        for (Aluno a : listaLida) {
            System.out.println(a);
        }
    }


    public static void main(String[] args) {

        // Criando objetos Aluno
        Aluno a1 = new Aluno("01202012", "José Eduardo", "ADS",
                "Banco de Dados", 9.0, 7);
        Aluno a2 = new Aluno("01202000", "Lucas Alves", "ADS",
                "Análise de Sistemas", 8.5, 10);
        Aluno a3 = new Aluno("01202111", "Xavier Sousa", "REDES",
                "Cabeamento Estruturado", 10.0, 5);

        // Criando um List para adicionar os alunos
        List<Aluno> lista = new ArrayList<Aluno>();
        lista.add(a1);
        lista.add(a2);
        lista.add(a3);

        gravaArquivoTxt(lista, "aluno.txt");
        leArquivoTxt("aluno.txt");

    }
}
