package Entities;

import java.util.Scanner;

public class ComputadorFactory {
    public static Produto novoProduto(Scanner scanner){
        System.out.print("Digite a descrição: ");
        String descricao     = scanner.nextLine();

        System.out.print("Digite o preço do Computador: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite a velocidade de memória (RAM) no formato inteiro: ");
        int ram = scanner.nextInt();

        System.out.print("Digite a quantidade de armazenamento (HD) no formato inteiro: ");
        int hd = scanner.nextInt();

        return new Computador(descricao, preco, ram, hd );
    }
}
