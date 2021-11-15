package com.mballem.curso.jasper.spring.repository;


import com.mballem.curso.jasper.spring.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    List<Produto> findByNomeContaining(String nome);
    List<Produto> findAllByCategoria_Id(Long id);
    Page<Produto> findAllByCategoria_Id(Long id, Pageable pageable);
}












