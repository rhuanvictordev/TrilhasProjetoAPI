package br.com.trilhas.api.controllers;

import org.springframework.web.bind.annotation.*;

import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioRespostaDTO cadastrar(@RequestBody UsuarioDTO dto) {
        return usuarioService.cadastrar(dto);
    }
}