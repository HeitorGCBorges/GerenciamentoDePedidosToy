package com.github.HeitorGCBorges.controller;

import com.github.HeitorGCBorges.model.Pedido;
import com.github.HeitorGCBorges.service.PedidoService;
import com.github.HeitorGCBorges.view.PedidoView;

import java.util.List;

public class PedidoController {
    private final PedidoService pedidoService;
    private final PedidoView pedidoView;

    public PedidoController(PedidoService pedidoService, PedidoView pedidoView) {
        this.pedidoService = pedidoService;
        this.pedidoView = pedidoView;
    }

    public void iniciar() {
        boolean executando = true;
        while (executando) {
            int opcao = pedidoView.exibirMenu();

            switch (opcao) {
                case 1:
                    registrarNovoPedido();
                    break;
                case 2:
                    removerPedidoExistente();
                    break;
                case 3:
                    listarTodosPedidos();
                    break;
                case 4:
                    executando = false;
                    pedidoView.exibirMensagem("Saindo do sistema... Até logo!");
                    break;
                default:
                    pedidoView.exibirMensagem("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void registrarNovoPedido() {
        Pedido dadosDoPedido = pedidoView.coletarDadosNovoPedido();

        Pedido pedidoRegistrado = pedidoService.registrarPedido(
                dadosDoPedido.getNome(),
                dadosDoPedido.getItens()
        );

        pedidoView.exibirConfirmacaoPedido(pedidoRegistrado);
    }

    private void removerPedidoExistente() {
        int id = pedidoView.solicitarIdParaRemocao();

        boolean removido = pedidoService.removerPedido(id);

        if (removido) {
            pedidoView.exibirMensagem("Pedido removido com sucesso!");
        } else {
            pedidoView.exibirMensagem("Erro: Pedido com ID " + id + " não encontrado.");
        }
    }

    private void listarTodosPedidos() {
        List<Pedido> todosOsPedidos = pedidoService.listarPedidos();

        pedidoView.exibirListaDePedidos(todosOsPedidos);
    }
}