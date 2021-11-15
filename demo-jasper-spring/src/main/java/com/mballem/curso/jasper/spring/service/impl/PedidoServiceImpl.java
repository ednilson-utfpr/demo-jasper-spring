package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.model.Pedido;
import com.mballem.curso.jasper.spring.repository.PedidoRepository;
import com.mballem.curso.jasper.spring.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends CrudServiceImpl<Pedido, Long>  implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    protected JpaRepository<Pedido, Long> getRepository() {
        return pedidoRepository;
    }

    @Override
    public List<Pedido> findAllByClienteId(Long clienteId) {
        return pedidoRepository.findAllByClienteId(clienteId);
    }
}
