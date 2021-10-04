public class Lista <T> {

    private T[] vetor;
    private Integer nroElem;

    public Lista(Integer tam) {
        vetor = (T[]) new Object[tam];
        nroElem = 0;
    }

    public Boolean adiciona(T valorAdicionar) {
        if (nroElem < vetor.length) {
            vetor[nroElem++] = valorAdicionar;
            return true;
        } else {
            return false;
        }
    }

    public void exibe() {
        for (int i = 0; i < nroElem; i++) {
            System.out.println(vetor[i]);
        }
    }

    public Integer busca(T valorElemento) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(valorElemento)) {
                return i;
            }
        }
        return -1;
    }

    public Boolean removerPeloIndice (Integer valorRemover) {
        if (valorRemover < 0 || valorRemover >= nroElem) {
            System.out.println("Indice invalido");
            return false;
        }
        else {
            for (Integer i = valorRemover; i < nroElem-1; i++) {
                vetor[i] = vetor[i+1];
            }
            nroElem--;
            return true;
        }
    }

    public Boolean removerElemento(T valor) {
        return removerPeloIndice(busca(valor));
    }

    public Integer getTamanho() {
        return nroElem;
    }

    public T getElemento(Integer indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        return vetor[indice];
    }

    public void limpar() {
        nroElem = 0;
    }

}