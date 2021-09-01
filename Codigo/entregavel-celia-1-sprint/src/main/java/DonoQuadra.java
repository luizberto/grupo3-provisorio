import java.time.LocalDate;

public class DonoQuadra extends Pessoa {

    private String cnpj;

    public DonoQuadra(String nome, String email, String senha, LocalDate dataNascimento, String cnpj) {
        super(nome, email, senha, dataNascimento);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

