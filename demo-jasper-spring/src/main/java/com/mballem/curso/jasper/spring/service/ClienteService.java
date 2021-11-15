package com.mballem.curso.jasper.spring.service;


import com.mballem.curso.jasper.spring.model.Cliente;

public interface ClienteService extends CrudService<Cliente, Long> {
    Cliente findClienteByUsuarioId(Long usuarioId);
}
