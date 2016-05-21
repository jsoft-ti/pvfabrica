package br.com.jsoftti.pvfabrica.model;

/**
 * Created by jsoft on 5/21/2016.
 */
public class Produto {
    private int id;
    private String nome;
    private int qtd;
    private double valor;

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Produto(int id, String nome, int qtd, double valor) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
        this.valor = valor;
    }
}
