# Loja

## Visão Geral

Apresento a vocês o projeto "Loja". Foi um projeto idealizado pelo professor Carlos Neto no curso profissionalizante de Java no Senac, o objetivo desse projeto é colocar em prática a toda a nossa aprendizagem da linguagem. Neste projeto criei a loja virtual para vendas de eletrônicos, usando o paradigma da Programação Orientada a Objetos (POO) e aplicando os seus conceitos, como Classe, herança, Polimorfismo e encapsulamento. 
## Estrutura do Projeto

O projeto é organizado em classes distintas para facilitar a manutenção e extensibilidade do código. As principais classes são:

- **Main:** Classe principal que inicia a execução do programa. Instancia um `LojaController` para gerenciar a interação com o usuário.

```java
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
`````
- **LojaController:** É responsável por Controlar as operações da loja, exibir o menu e processar as escolhas do usuário. Mantém uma instância da classe `Loja`.
`````java
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
`````
- **Loja:** Gerencia o estoque de produtos, armazenando uma lista de produtos. Contém todos os métodos que a `LojaController` está usando.
````java
package entities;

import exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    private static ArrayList<Produto> estoque;
    private static int proximoId;

    public Loja() {
        estoque = new ArrayList<>();
        proximoId = 1;
    }

    public void adicionarProduto(Produto produto) {
        produto.setId(gerarProximoId());
        estoque.add(produto);
    }

    public void exibirEstoque() {
        if (estoque == null || estoque.isEmpty()) {
            System.out.println("Não possui um estoque ainda ou o estoque está vazio.");
        } else {
            System.out.println("===== Estoque da Loja de Mangas =====");
            for (Produto produto : estoque) {
                produto.exibirInfo();
                System.out.println("------------------------------");
            }
        }
    }

    public static int gerarProximoId() {
        for (Produto produto : estoque) {
            if (produto.getId() == proximoId) {
                proximoId++;
                return gerarProximoId();
            }
        }
        return proximoId;
    }

    public boolean atualizarProduto(int id) throws ProdutoNaoEncontradoException {
        for (Produto produto : estoque) {
            if (produto.getId() == id) {
                System.out.println("Informações atuais do produto:");
                produto.exibirInfo();
                return true;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com o ID " + id + " não encontrado.");
    }

    public Produto buscarProdutoPorId(int id) throws ProdutoNaoEncontradoException {
        for (Produto produto : estoque) {
            if (produto.getId() == id) {
                produto.exibirInfo();
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com o ID " + id + " não encontrado.");
    }

    public Produto solicitarNovasInformacoes(Scanner scanner, Produto produtoAtual) {
        System.out.println("Digite as novas informações do produto:");

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();

        System.out.print("Novo preço: ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();

        if (produtoAtual instanceof Manga) {
            System.out.print("Novo autor do Manga: ");
            String novoAutor = scanner.nextLine();
            ((Manga) produtoAtual).setAutor(novoAutor);
        }

        if (produtoAtual instanceof Livro) {
            System.out.print("Novo autor do Livro: ");
            String novoAutor = scanner.nextLine();

            System.out.print("Novo ano do Livro: ");
            int novoAno = scanner.nextInt();
            scanner.nextLine();
            ((Livro) produtoAtual).setAutor(novoAutor);
            ((Livro) produtoAtual).setAno(novoAno);
        }

        produtoAtual.setNome(novoNome);
        produtoAtual.setPreco(novoPreco);

        return produtoAtual;
    }

    public Produto removerProdutoByID(int id) throws ProdutoNaoEncontradoException {
        for (int i = 0; i < estoque.size(); i++) {
            Produto produto = estoque.get(i);
            if (id == produto.getId()) {
                estoque.remove(i);
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com o ID " + id + " não encontrado.");
    }

    public Produto comprarProduto(int id) throws ProdutoNaoEncontradoException{
        for (int i = 0; i < estoque.size(); i++) {
            Produto produto = estoque.get(i);
            if(produto.getId() == id){
                System.out.println("Produto comprado com Sucesso!");
                estoque.remove(i);
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com o ID " + id + " não encontrado.");
    }
}
````

- **Produto:** Classe abstrata que representa um produto atributos comuns a todos os produtos.
````Java
package Entities;

public abstract class Produto {

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
   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public double getPreco() {
      return preco;
   }

   public void setPreco(double preco) {
      this.preco = preco;
   }
   public void moreInfo(){

   }
}
````
- **Computador:** Subclasse de `Produto`, é responsável por representar e Adiciona atributos específicos, como o RAM e o HD.
````Java
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
      System.out.println("Nome: " + getDescricao());
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
````

- **ComputadorFactory:** Responsável por implementa um Factory Method, assim,  facilitando a criação de objetos de maneira consistente.

````Java
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

````

- **Periferico:** Subclasse de `Produto`,representa os perifericos.

````Java
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
````

- **perifericoFactory:** Subclasse de `Produto`, especializada para representar os peifericos.
````Java
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

````
- **ProductNotFound:** Classe de Excpetions que irá lidar com possiveis erros futuros no código.
````java
package Exception;

public class ProductNotFound extends Exception {
   public ProductNotFound(String mensagem) {
      super(mensagem);
   }
}
````

## Funcionalidades Principais

### 1. Adição de Computadores/Perifericos

A classe `LojaController` permite ao usuário adicionar novos produtos à loja. Utiliza o switch case para definir qual tipo de produto e chamar o certo `Factory` para criar instâncias dos produtos.

### 2. Exibir o Estoque

O usuário pode visualizar o estoque atual da loja, exibindo informações sobre cada produto dentro do estoque da loja, como computadores e perifericos.

### 3. Remoção de Produtos

Possibilidade de remover um produto do estoque usando o seu ID.

### 4. Compra de Produtos

Permite ao usuário comprar um produto usando o seu ID, assim, removendo-o do estoque.

### 5. Geração Automática de IDs

A classe `Loja` implementa um método para gerar IDs sequenciais automaticamente, assim,  facilitando a criação de futuros produtos.

### 7. Manipulação de Exceções

Introdução de uma exceção personalizada, `ProductNotFound`, para lidar com casos em que um produto não é encontrado.

## Uso Básico

1**Adicionar um Produto:**
    - Escolha a opção `1` no menu.
    - Insira os dados do produto quando solicitado.

2**Exibir o Estoque:**
    - Selecione a opção `2` no menu.
    - Visualize as informações sobre os produtos no estoque.
    
3**Comprar um Produto:**
    - Selecione a opção `3` no menu.
    - Insira o ID do manga que você deseja comprar.
    - E confirme a compra.
4**Remover um Produto:**
    - Escolha a opção `4` no menu.
    - Insira o ID do produto que você deseja remover.

5. **Encerrar o Programa:**
    - Selecione a opção `0` no menu.

## Melhorias e Expansões Futuras

1. **Persistência de Dados:**
    - Adição de persistência de dados para salvar e carregar informações do estoque entre execuções do programa.
2. **Validação de Entradas:**
    - Implementação de verificações e validações para garantir que as entradas do usuário estejam corretas.
3. **Novos Tipos de Produtos:**
    - Expansão do sistema para lidar com diferentes tipos de produtos além de mangas e livros.
4. **Atualização de Produtos:**
   - Atualizar produtos já existentes que estão gravados no sistema, usando o ID do produto.

## Conclusão

Foi maravilhosa essa oportunidade e experiência de me aprimorar como um iniciante na programação durante todo esse curso, pois aqui pude ver e medir falhas e acertos, pude não só aprimorar certos conhecimentos, como também tive a oportunidade de adiquirir muitas outras Skills.
Este projeto me proporcionou uma grande experiência em aprimorar os meus conhecimentos de Java e praticá-lo.