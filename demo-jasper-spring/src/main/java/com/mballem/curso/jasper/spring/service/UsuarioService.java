package com.mballem.curso.jasper.spring.service;


import com.mballem.curso.jasper.spring.model.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long>{
    Usuario findByEmail(String email);
    Usuario findByUsername(String username);
    void updatePassword(String password, Long userId);
}
