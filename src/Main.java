import Entities.LojaController;

import Exception.ProductNotFound;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ProductNotFound {
        Scanner scanner = new Scanner(System.in);
        LojaController lojaController = new LojaController(scanner);

        lojaController.addProdutoAuto();

        int escolha = -1;
        do {
            try {
                LojaController.menu();
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();

                LojaController.processarOpcao(escolha);
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira uma opção válida.");
                scanner.nextLine();
            }
        }while (escolha != 0);{
            try {
                LojaController.menu();
                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();
                scanner.nextLine();

                LojaController.processarOpcao(escolha);
            }catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira uma opção válida.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}