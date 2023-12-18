package Entities;

import java.util.Scanner;

public class Periferico extends Produto {
    public Periferico(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public void moreInfo() {
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getDescricao());
        System.out.printf("Preço: R$ %.2f%n", getPreco());

    }
}