package com.mballem.curso.jasper.spring.repository;


import com.mballem.curso.jasper.spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findClienteByUsuarioId(Long usuarioId);
}
