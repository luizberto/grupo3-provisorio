package com.example.demo.pilha;


public class PilhaObj<T> {

    T[] pilha;
    int numeroElementos;
    int topo;

    public PilhaObj(int tamanhoMaximo) {
        this.pilha = (T[]) new Object[tamanhoMaximo];
        this.numeroElementos = 0;
        this.topo = -1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == this.pilha.length - 1;
    }

    public void push(T info) {
        if (!isFull()) {
            this.pilha[++topo] = info;
        } else {
            System.out.println("Pilha está cheia");
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Lista vazia");
            return null;
        } else {
            return this.pilha[topo--];
        }
    }

    public T peek() {
        if (!isEmpty()) {
            return this.pilha[topo];
        } else {
            return null;
        }
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(this.pilha[i]);
            }
        }
    }

    public boolean ehPalindromo(int[] array) {
        int novoTopo = array.length - 1;
        int[] novoArray = new int[array.length];

        for (int i = 0; i < novoArray.length; i++) {
            novoArray[i] = array[i];
        }

        for (int i = 0; i < novoArray.length; i++) {
            if (!(novoArray[i] == array[novoTopo--])) {
                return true;
            }
        }
        return false;
    }

}