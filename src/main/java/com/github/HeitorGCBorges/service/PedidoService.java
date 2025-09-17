package com.github.HeitorGCBorges.service;

import com.github.HeitorGCBorges.dao.PedidoDAO;
import com.github.HeitorGCBorges.model.Item;
import com.github.HeitorGCBorges.model.Pedido;

import java.util.List;

public class PedidoService {

    private final PedidoDAO pedidoDAO;
    private int proximoId = 1;

    public PedidoService() {
        this.pedidoDAO = new PedidoDAO();
    }
    
    public Pedido registrarPedido(String nomeCliente, List<Item> itens) {
        int novoId = proximoId;

        
        Pedido novoPedido = new Pedido(novoId, nomeCliente);

        for (Item item : itens) {
            novoPedido.adicionarItem(item);
        }

        this.pedidoDAO.adicionarPedido(novoPedido);

        proximoId++;

        return novoPedido;
    }
    
    public boolean removerPedido(int id) {
        Pedido pedidoParaRemover = pedidoDAO.buscarPedidoPorId(id);

        if (pedidoParaRemover != null) {
            pedidoDAO.removerPedido(id);
            return true;
        }

        return false;
    }
    
    public List<Pedido> listarPedidos() {
        return pedidoDAO.listarPedidos();
    }
    
    public Pedido buscarPedidoPorId(int id) {
        return pedidoDAO.buscarPedidoPorId(id);
    }
}