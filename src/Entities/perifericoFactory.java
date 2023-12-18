package Entities;

import java.util.Scanner;

public class perifericoFactory {
    public static Produto novoProduto(Scanner scanner){
        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        return new Periferico (descricao, preco);
    }
}
