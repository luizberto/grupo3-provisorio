public class Quadra {

    private String nomeQuadra;
    private String descQuadra;
    private Integer limitePessoa;
    private Integer cep;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

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

    public String alterarNomeQuadra(String novoNome){
        nomeQuadra = novoNome;
        return String.format("Nome da quadra alterado com sucesso.");
    }

    public String alterarLimitePessoa(Integer novoLimite){
        limitePessoa = novoLimite;
        return String.format("Limite de pessoas alterado com sucesso.");
    }

    public Quadra(String nomeQuadra, String descQuadra, Integer limitePessoa, Integer cep, String logradouro, Integer numero, String bairro, String cidade, String estado) {
        this.nomeQuadra = nomeQuadra;
        this.descQuadra = descQuadra;
        this.limitePessoa = limitePessoa;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNomeQuadra() {
        return nomeQuadra;
    }

    public void setNomeQuadra(String nomeQuadra) {
        this.nomeQuadra = nomeQuadra;
    }

    public String getDescQuadra() {
        return descQuadra;
    }

    public void setDescQuadra(String descQuadra) {
        this.descQuadra = descQuadra;
    }

    public Integer getLimitePessoa() {
        return limitePessoa;
    }

    public void setLimitePessoa(Integer limitePessoa) {
        this.limitePessoa = limitePessoa;
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
