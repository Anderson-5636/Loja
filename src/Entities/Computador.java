package Entities;

import Entities.*;

public class Computador extends Produto {

    private int ram;
    private int hd;

    public Computador(String descricao, double preco, int ram, int hd ) {
        super(descricao, preco);
        this.ram = ram;
        this.hd = hd;

    }


    @Override
    public void moreInfo() {
        System.out.println("Id: " + getId());
        System.out.println("Descrição: " + getDescricao());
        System.out.printf("Preço: R$ %.2f%n", getPreco());

        if (ram > 0) {
            System.out.println("RAM: " + ram);
        } else {
            System.out.println("Infelixmente não temos essa informação :(");
        }
        if (hd > 0){
            System.out.println("HD: " + hd);
        }else {
            System.out.println("Infelixmente não temos essa informação :(");
        }

    }
}