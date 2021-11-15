package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.model.Massa;
import com.mballem.curso.jasper.spring.repository.MassaRepository;
import com.mballem.curso.jasper.spring.service.MassaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MassaServiceImpl extends CrudServiceImpl<Massa, Long>  implements MassaService {

    @Autowired
    private MassaRepository massaRepository;

    @Override
    protected JpaRepository<Massa, Long> getRepository() {
        return massaRepository;
    }


}
