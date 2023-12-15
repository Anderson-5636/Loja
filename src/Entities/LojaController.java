package Entities;

import java.util.Scanner;

public class LojaController {
    private final Scanner scanner;
    private final Loja loja;

    public LojaController(Scanner scanner) {
        this.loja = new Loja();
        this.scanner = scanner;
    }

    public void addProdutoAuto(){
        loja.addProduto(new Computador("Descktop", 3.500, 8, 500));
        loja.addProduto(new Computador("Notbook", 4.500, 8, 1000));
        loja.addProduto(new Computador("Notbook", 3.000, 4, 500));
        loja.addProduto(new Computador("Descktop", 3.500, 8, 500));
    }

    public void menu() {
        System.out.println("---------------------------------------");
        System.out.println("------Bem vina a Loja Zerados!!!-------");
        System.out.println("---------------------------------------");
        System.out.println("**** Selecione a operação desejada ****");
        System.out.println("|     Opção 1 - Cadastrar |");
        System.out.println("|     Opção 2 - Listar    |");
        System.out.println("|     Opção 3 - Comprar   |");
        System.out.println("|     Opção 4 - Remover  |");
        System.out.println("|     Opção 5 - Sair      |");

    }
    public void processarOpcao(int escolha){
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                loja.addProduto();
                break;
            case 2:
                loja.listStock();
                break;
            case 3:
                loja.comprarProdutos();
                break;
            case 4:
                loja.listCarrinho();
                break;
            case 5:
                System.out.println("------Obrigado pela preferência!-------");
                System.out.println("\n");
                System.out.println("------------ Até breve!!! -------------");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                menu();
        }
    }
}