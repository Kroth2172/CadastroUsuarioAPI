package com.cadastro.desafio.service;

import com.cadastro.desafio.data.UsuarioDTO;
import com.cadastro.desafio.model.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listaUsuarios();

    UsuarioDTO salvar(UsuarioDTO usuario) throws Exception;

}
