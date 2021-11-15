package com.mballem.curso.jasper.spring.service;


import com.mballem.curso.jasper.spring.model.Pedido;

import java.util.List;

public interface PedidoService extends CrudService<Pedido, Long> {
    List<Pedido> findAllByClienteId(Long clienteId);
}
