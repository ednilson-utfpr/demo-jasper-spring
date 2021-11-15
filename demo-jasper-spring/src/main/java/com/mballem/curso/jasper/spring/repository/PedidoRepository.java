package com.mballem.curso.jasper.spring.repository;


import com.mballem.curso.jasper.spring.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByClienteId(Long clienteId);
}
