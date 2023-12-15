package Entities;

import Utils.Utils;

public class Produto {
    private static int count = 1;

    private int id;
    private String descricao;
    private double preco;

    public Produto(String descricao, double preco) {
        this.id = Loja.gerarId();
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public abstract void moreInfo(){

    }
}