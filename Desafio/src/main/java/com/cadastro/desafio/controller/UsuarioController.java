package com.cadastro.desafio.controller;

import com.cadastro.desafio.data.UsuarioDTO;
import com.cadastro.desafio.model.Usuario;
import com.cadastro.desafio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/listar", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuario>> listar() {
        try {
            List<Usuario> retorno = usuarioService.listaUsuarios();
            if (retorno.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuario) {
        try {
            return ResponseEntity.ok(usuarioService.salvar(usuario));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
