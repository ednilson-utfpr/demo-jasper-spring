package com.mballem.curso.jasper.spring.repository;

import com.mballem.curso.jasper.spring.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
}
