import java.time.LocalDate;

public class Usuario extends Pessoa {

    private Integer cpf;
    private String posicao;
    private Integer cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public Usuario(String nome,
                   String email,
                   String senha,
                   LocalDate dataNascimento,
                   Integer cpf,
                   String posicao,
                   Integer cep,
                   String logradouro,
                   Integer numero,
                   String bairro,
                   String cidade,
                   String estado) {
        super(nome, email, senha, dataNascimento);
        this.cpf = cpf;
        this.posicao = posicao;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String alterarPosicao(String novaPosicao){
        posicao = novaPosicao;
        return String.format("Posição alterada com sucesso.");
    }

    public String alterarEndereco(Integer novoCep,
                                  String novoLogradouro,
                                  Integer novoNumero,
                                  String novoBairro,
                                  String novaCidade,
                                  String novoEstado){
        cep = novoCep;
        logradouro = novoLogradouro;
        numero = novoNumero;
        bairro = novoBairro;
        cidade = novaCidade;
        estado = novoEstado;
        return String.format("Endereço alterado com sucesso.");
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
