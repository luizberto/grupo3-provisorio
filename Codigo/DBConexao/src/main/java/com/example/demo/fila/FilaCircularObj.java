package com.example.demo.fila;

import com.example.demo.pilha.PilhaObj;

import java.util.ArrayList;
import java.util.List;

public class FilaCircularObj<T> {

    private T[] fila;
    private int tamanhoFila;
    private int inicioFila;
    private int fimFila;

    public FilaCircularObj(int capacidadeFila) {
        this.fila = (T[]) new Object[capacidadeFila];
        this.tamanhoFila = 0;
        this.inicioFila = 0;
        this.fimFila = 0;
    }

    public boolean isEmpty() {
        return this.tamanhoFila == 0;
    }

    public boolean isFull() {
        return this.tamanhoFila == this.fila.length;
    }

    public void insert(T info) {
        if (!this.isFull()) {
            this.fila[fimFila] = info;
            this.fimFila = (this.fimFila + 1) % this.fila.length;
            this.tamanhoFila++;
        } else {
            System.out.println("A fila está cheia!");
        }
    }

    public T peek() {
        return this.fila[inicioFila];
    }

    public T poll() {
        if (!this.isEmpty()) {
            T inicio = peek();
            this.inicioFila = (this.inicioFila + 1 % this.fila.length);
            this.tamanhoFila--;
            return inicio;
        }
        return null;
    }

    public Object exibe() {
        if (!this.isEmpty()) {
            Object[] filaObj = new Object[this.tamanhoFila];
            for (int c = 0, i = this.inicioFila; c < this.tamanhoFila; c++, i = ((i + 1) % fila.length)) {
//                System.out.println(this.fila[i]);
                filaObj[c] = this.fila[i];
            }
            return filaObj;
        }
        return "Fila Vazia";
    }

    public void separaPositivoNegativoEmOrder(int[] array) {

        FilaCircularObj<Integer> filaPositiva = new FilaCircularObj<>(array.length);
        FilaCircularObj<Integer> filaNegativa = new FilaCircularObj<>(array.length);

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                filaPositiva.insert(array[i]);
            } else {
                filaNegativa.insert(array[i]);
            }
        }

        while (!filaPositiva.isEmpty()) {
            System.out.println(filaPositiva.poll());
        }

        while (!filaNegativa.isEmpty()) {
            System.out.println(filaNegativa.poll());
        }
    }

    public void separaPositivoNegativoNegativoOrdemDiferente(int[] array) {

        FilaCircularObj<Integer> filaPositiva = new FilaCircularObj<>(array.length);
        PilhaObj<Integer> filaNegativa = new PilhaObj<>(array.length);

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                filaPositiva.insert(array[i]);
            } else {
                filaNegativa.push(array[i]);
            }
        }

        while (!filaPositiva.isEmpty()) {
            System.out.println(filaPositiva.poll());
        }

        while (!filaNegativa.isEmpty()) {
            System.out.println(filaNegativa.pop());
        }

    }
}