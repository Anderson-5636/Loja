package Entities;
import Exception.ProductNotFound;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LojaController {
    private static Scanner scanner;
    private static Loja loja;

    public LojaController(Scanner scanner) {
        this.loja = new Loja();
        this.scanner = scanner;
    }

    public void addProdutoAuto(){
        loja.addProduto(new Computador("Descktop", 3500, 8 , 500));
        loja.addProduto(new Computador("Notbook", 4500, 8, 1000));
        loja.addProduto(new Computador("Notbook", 3000, 4, 500));
        loja.addProduto(new Computador("Descktop", 3500, 8, 500));
        loja.addProduto(new Periferico("Mouse", 35));
        loja.addProduto(new Periferico("Teclado", 250));
        loja.addProduto(new Periferico("Led RGB", 350));
        loja.addProduto(new Periferico("Fone", 50));

    }

    public static void menu() {
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
    public static void processarOpcao(int opcao){
        int id = 0;

        switch (opcao) {
            case 1:
                System.out.println("------Temos estes produtos em Loja:------");
                System.out.println("*******      1 - Computador       *******");
                System.out.println("*******      2 - Periféricos      *******");
                System.out.print("Qual é o tipo de Produto desejado: ");
                int escolha2 = scanner.nextInt();
                try {
                    switch (escolha2) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Adicionar o novo computador:");
                            Produto novoComputador = ComputadorFactory.novoProduto(scanner);
                            loja.addProduto(novoComputador);
                            System.out.println("Cadastrado com sucesso!!!");
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("Adicionar um periférico:");
                            Produto novoPeriferico = perifericoFactory.novoProduto(scanner);
                            loja.addProduto(novoPeriferico);
                            System.out.println("Cadastrado com sucesso!!!");
                            break;
                        default:
                            System.out.println("Opção inválida, por favor tente novamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um dado válido!");
                    scanner.nextLine();
                }
                break;
            case 2:
                loja.listStock();
                break;
            case 3:
                System.out.println("Qual o produto que você quer comprar?");
                System.out.print("Digite o ID do produto: ");
                id = scanner.nextInt();
                System.out.println("_____________________________________");
                try {
                    if (loja.buscarPorId(id) != null) {
                        scanner.nextLine();
                        System.out.print("Deseja comprar este produto? (S - Sim | N - Não): ");
                        char resposta = scanner.nextLine().toUpperCase().charAt(0);
                        if (resposta == 'S') {
                            loja.comprarProduto(id);
                        } else {
                            System.out.println("Compra cancelada!");
                        }
                    }
                } catch (InputMismatchException | ProductNotFound e) {
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                }
                break;
            case 4:
                System.out.println("______________________________________________");
                System.out.print("Digite o id do produto que você deseja remover: ");
                id = scanner.nextInt();
                try {
                    scanner.nextLine();
                    Produto produtoId = loja.deleteProdutoById(id);
                    System.out.println("Este será o produto Deletado!");
                    produtoId.moreInfo();
                    System.out.println("         !!!SUCESSO!!!        ");
                    System.out.println("--- O produto foi Removido ---");
                } catch (InputMismatchException | ProductNotFound e) {
                    System.out.println("Entrada inválida. Por favor, insira um número válido.");
                    scanner.nextLine();
                }
                break;
            case 5:
                System.out.println("------Obrigado pela preferência!-------");
                System.out.println("\n");
                System.out.println("------------ Até breve!!! -------------");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
        }
    }

}