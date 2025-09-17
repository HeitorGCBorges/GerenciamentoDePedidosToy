package com.github.HeitorGCBorges.view;

import com.github.HeitorGCBorges.model.Item;
import com.github.HeitorGCBorges.model.Pedido;

import java.util.List;
import java.util.Scanner;

public class PedidoView {

    private final Scanner scanner;

    public PedidoView() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento de Pedidos ---");
        System.out.println("1. Registrar Pedido");
        System.out.println("2. Remover Pedido");
        System.out.println("3. Listar Pedidos");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public Pedido coletarDadosNovoPedido() {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Pedido dadosPedido = new Pedido(0, nomeCliente);

        String continuar;
        do {
            System.out.print("Digite o nome do item: ");
            String nomeItem = scanner.nextLine();
            System.out.print("Digite o preço do item: ");
            double precoItem = scanner.nextDouble();
            scanner.nextLine();

            dadosPedido.adicionarItem(new Item(nomeItem, precoItem));

            System.out.print("Deseja adicionar outro item? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        return dadosPedido;
    }

    public int solicitarIdParaRemocao() {
        System.out.print("Digite o número do pedido que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public void exibirListaDePedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado no momento.");
            return;
        }

        System.out.println("\n--- Lista de Pedidos Registrados ---");
        for (Pedido pedido : pedidos) {
            System.out.println("----------------------------------------");
            System.out.println("Pedido Nº: " + pedido.getId());
            System.out.println("Cliente: " + pedido.getNome());
            System.out.println("Itens:");
            for (Item item : pedido.getItens()) {
                System.out.println("- " + item.toString());
            }
            System.out.printf("Total: R$ %.2f\n", pedido.calcularTotal());
            System.out.println("----------------------------------------");
        }
    }

    public void exibirConfirmacaoPedido(Pedido pedido) {
        System.out.println("\n========================================");
        System.out.println("  Pedido Registrado com Sucesso!");
        System.out.println("========================================");
        System.out.println("Pedido Nº: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getNome());
        System.out.println("----------------------------------------");
        System.out.println("Itens:");
        for (Item item : pedido.getItens()) {
            System.out.println("- " + item.getnome() + " - R$ " + String.format("%.2f", item.getPreco()));
        }
        System.out.println("----------------------------------------");
        System.out.printf("Total: R$ %.2f\n", pedido.calcularTotal());
        System.out.println("========================================");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}