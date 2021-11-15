package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.repository.ClienteRepository;

import com.mballem.curso.jasper.spring.model.Cliente;
import com.mballem.curso.jasper.spring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends CrudServiceImpl<Cliente, Long>  implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }

    @Override
    public Cliente findClienteByUsuarioId(Long usuarioId) {
        return clienteRepository.findClienteByUsuarioId(usuarioId);
    }
}
