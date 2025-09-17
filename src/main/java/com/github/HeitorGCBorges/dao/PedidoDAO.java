package com.github.HeitorGCBorges.dao;

import com.github.HeitorGCBorges.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    private List<Pedido> pedidos = new ArrayList<>();

    public void adicionarPedido (Pedido pedido){
        pedidos.add(pedido);
    }

    public void removerPedido (int id){
        pedidos.removeIf(pedido -> pedido.getId() == id);
    }

    public List<Pedido> listarPedidos(){
        return pedidos;
    }

    public Pedido buscarPedidoPorId(int id){
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
