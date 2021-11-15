package com.mballem.curso.jasper.spring.repository;


import com.mballem.curso.jasper.spring.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

      //public Categoria findCategoriaByCategoriaId(Long categoriaId);
}


