import java.time.LocalDate;

public abstract class Pessoa {

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private Boolean ativo;

    public String alterarEmail(String novoEmail){
        email = novoEmail;
        return String.format("Email alterado com sucesso");
    }

    public String alterarSenha(String novaSenha){
        senha = novaSenha;
        return String.format("Senha alterada com sucesso");
    }

    public String alterarAtivo(){
        ativo = false;
        return String.format("Usuario não está mais ativo");
    }

    public Pessoa(String nome, String email, String senha, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
