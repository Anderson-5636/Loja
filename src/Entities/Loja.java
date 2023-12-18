package Entities;

import  Exception. ProductNotFound;
import java.util.ArrayList;

public class Loja {
    private static ArrayList<Produto> stock;
    private static int nextId;

    public Loja() {
        stock = new ArrayList<>();
        nextId = 1;
    }

    public void addProduto(Produto produto) {
        produto.setId(gerarId());
        stock.add(produto);
    }

    public static void listStock() {
        if (stock == null || stock.isEmpty()) {
            System.out.println("Ainda Não Temos Nenhum Produto Cadstrado");
        } else {
            System.out.println("----------- Produtos Disponíveis ----------");

            for (Produto produto : stock) {
                produto.moreInfo();
                System.out.println("___________________________________________");
            }
        }

    }

    public static int gerarId() {
        for (Produto produto : stock) {
            if (produto.getId() == nextId) {
                nextId++;
                return gerarId();
            }
        }
        return nextId;
    }
    public Produto buscarPorId(int id) throws ProductNotFound {
        for (Produto produto : stock) {
            if (produto.getId() == id) {
                produto.moreInfo();
                return produto;
            }
        }
        throw new ProductNotFound ("Produto cujo ID " + id + " não foi encontrado.");
    }

    public Produto deleteProdutoById(int id) throws ProductNotFound {
        for (int i = 0; i < stock.size(); i++) {
            Produto produto = stock.get(i);
            if (id == produto.getId()) {
                stock.remove(i);
                return produto;
            }
        }
        throw new ProductNotFound("Produto cujo ID " + id + " não foi encontrado.");

    }

    public Produto comprarProduto(int id) throws ProductNotFound {
        for (int i = 0; i < stock.size(); i++) {
            Produto produto = stock.get(i);
            if (produto.getId() == id) {
                System.out.println("!!!Parabéns Pela Sua Compra!!!");
                stock.remove(i);
                return produto;
            }
        }
        throw new ProductNotFound("Produto cujo ID " + id + " não foi encontrado.");
    }

}

