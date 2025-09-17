package com.github.HeitorGCBorges;

import com.github.HeitorGCBorges.controller.PedidoController;
import com.github.HeitorGCBorges.service.PedidoService;
import com.github.HeitorGCBorges.view.PedidoView;

public class Main {
    public static void main(String[] args) {
        PedidoService service = new PedidoService();
        PedidoView view = new PedidoView();

        PedidoController controller = new PedidoController(service, view);

        controller.iniciar();
    }
}