package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.model.Produto;
import com.mballem.curso.jasper.spring.repository.ProdutoRepository;
import com.mballem.curso.jasper.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl extends CrudServiceImpl<Produto, Long>  implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	protected JpaRepository<Produto, Long> getRepository() {
		return produtoRepository;
	}

	@Override
	public List<Produto> findByNomeContaining(String nome) {
		return this.produtoRepository.findByNomeContaining(nome);
	}

	@Override
	public List<Produto> findAllByCategoria_Id(Long id) {
		return this.produtoRepository.findAllByCategoria_Id(id);
	}

	@Override
	public Page<Produto> findAllByCategoria_Id(Long id, Pageable pageable) {
		return produtoRepository.findAllByCategoria_Id(id, pageable);
	}
}
