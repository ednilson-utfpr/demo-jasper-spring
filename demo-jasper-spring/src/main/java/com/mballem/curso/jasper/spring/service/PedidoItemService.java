package com.mballem.curso.jasper.spring.service;


import com.mballem.curso.jasper.spring.model.PedidoItem;

import java.util.List;

public interface PedidoItemService extends CrudService<PedidoItem, Long> {
    List<PedidoItem> findAllByPedido_Cliente_Id(Long clienteId);
    List<PedidoItem> findAllByPedidoId(Long pedidoId);
}
