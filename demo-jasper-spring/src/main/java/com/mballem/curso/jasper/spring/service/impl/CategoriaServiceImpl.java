package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.model.Categoria;
import com.mballem.curso.jasper.spring.repository.CategoriaRepository;
import com.mballem.curso.jasper.spring.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends CrudServiceImpl<Categoria, Long>  implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	protected JpaRepository<Categoria, Long> getRepository() {
		return categoriaRepository;
	}


	//@Override
	public Categoria findCategoriaByCategoriaId(Long categoriaId) {
//		return categoriaRepository.findCategoriaByCategoriaId(categoriaId);
	return null;
	}


}
