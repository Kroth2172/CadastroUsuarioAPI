package com.cadastro.desafio.service.serviceImpl;

import com.cadastro.desafio.data.UsuarioDTO;
import com.cadastro.desafio.exception.BusinessException;
import com.cadastro.desafio.model.Usuario;
import com.cadastro.desafio.repository.UsuarioRepository;
import com.cadastro.desafio.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository clienteRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Usuario> listaUsuarios() {
        try{
            return clienteRepository.findAll();
        } catch (final Exception e) {
            throw new BusinessException("Erro ao listar todos os usuários.", e);
        }
    }
    
    @Override
	public UsuarioDTO salvar(UsuarioDTO dto)  {
        try {
            // Validações dos campos
            Assert.notNull(dto.getNome(), "Nome é um campo obrigatório.");
            Assert.notNull(dto.getEmail(), "E-mail é um campo obrigatório.");
            Assert.notNull(dto.getSenha(), "Senha é um campo obrigatório.");

            if (!dto.getSenha().equalsIgnoreCase(dto.getSenhaConfirmar())) {
                throw new BusinessException("As senhas não são iguais.");
            }

            Usuario usuario = toEntity(dto);
            clienteRepository.save(usuario);
            return toDTO(usuario);
        } catch (final Exception e) {
            throw new BusinessException("Erro ao salvar o usuário.", e);
        }
	}

    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UsuarioDTO dto = new UsuarioDTO();
        dto = modelMapper.map(usuario, UsuarioDTO.class);
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Usuario usuario = new Usuario();
        usuario = modelMapper.map(dto, Usuario.class);

        return usuario;
    }
}