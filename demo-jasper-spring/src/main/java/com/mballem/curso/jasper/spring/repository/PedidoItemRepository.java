package com.mballem.curso.jasper.spring.repository;


import com.mballem.curso.jasper.spring.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
    List<PedidoItem> findAllByPedido_Cliente_Id(Long clienteId);
    List<PedidoItem> findAllByPedidoId(Long pedidoId);
}
