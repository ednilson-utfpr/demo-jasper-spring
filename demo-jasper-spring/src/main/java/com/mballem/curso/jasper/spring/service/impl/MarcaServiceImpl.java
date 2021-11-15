package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.model.Marca;
import com.mballem.curso.jasper.spring.repository.MarcaRepository;
import com.mballem.curso.jasper.spring.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl extends CrudServiceImpl<Marca, Long>  implements MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@Override
	protected JpaRepository<Marca, Long> getRepository() {
		return marcaRepository;
	}
}
