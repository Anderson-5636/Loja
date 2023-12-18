package Entities;

import java.util.Scanner;

public class Periferico extends Produto {

    private String marca;

    public Periferico(String descricao, double preco, String marca) {
        super(descricao, preco);
        this.marca = marca;
    }

    public String getmarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public void moreInfo() {
        System.out.println("Id: " + getId());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Marca: " + getmarca());
        System.out.printf("Preço: R$ %.2f%n", getPreco());

        if (marca != null) {
            System.out.println("Marca: " + marca);
        } else {
            System.out.println("Infelixmente não temos essa informação :(");
        }
    }


}