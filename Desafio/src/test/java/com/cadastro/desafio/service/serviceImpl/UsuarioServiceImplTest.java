package com.cadastro.desafio.service.serviceImpl;

import com.cadastro.desafio.data.UsuarioDTO;
import com.cadastro.desafio.exception.BusinessException;
import com.cadastro.desafio.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @InjectMocks
    UsuarioServiceImpl service;

    @Mock
    UsuarioRepository repository;

    UsuarioDTO usuariodto;

    @BeforeEach
    public void setUp() {
        usuariodto = new UsuarioDTO(1L, null,"willian@gmail.com","senha123", "senha123");
    }

    @Test
    void salvarNomeNUll() {
        final BusinessException e = assertThrows(BusinessException.class, () -> {
            service.salvar(usuariodto);
        });

        assertThat(e, notNullValue());
        assertThat(e.getMessage(), is("Erro ao salvar o usuário."));
        assertThat(e.getCause(), notNullValue());
        assertThat(e.getCause().getMessage(), is("Nome é um campo obrigatório."));
        verifyNoInteractions(repository);
    }
}