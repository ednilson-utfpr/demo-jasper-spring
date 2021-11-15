package com.mballem.curso.jasper.spring.service.impl;


import com.mballem.curso.jasper.spring.model.Situacao;
import com.mballem.curso.jasper.spring.repository.SituacaoRepository;
import com.mballem.curso.jasper.spring.service.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SituacaoServiceImpl extends CrudServiceImpl<Situacao, Long>  implements SituacaoService {

    @Autowired
    private SituacaoRepository situacaoRepository;

    @Override
    protected JpaRepository<Situacao, Long> getRepository() {
        return situacaoRepository;
    }
}
