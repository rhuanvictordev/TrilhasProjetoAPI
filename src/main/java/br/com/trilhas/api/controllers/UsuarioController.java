package br.com.trilhas.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.trilhas.api.dto.TrilhaDTO;
import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.entity.Trilha;
import br.com.trilhas.api.entity.Usuario;
import br.com.trilhas.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/usuarios")
@SecurityRequirement(name = "Bearer Authentication")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id){
    	return usuarioService.buscar(id);
    }
    
    @GetMapping
    public List<Usuario> listar(){
    	return usuarioService.listar();
    }
    
    /*
    @PostMapping
    public UsuarioRespostaDTO cadastrar(@RequestBody UsuarioDTO dto) {
        return usuarioService.cadastrar(dto);
    }
    */
    
    @PutMapping("/{id}")
    public Usuario editar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
        return usuarioService.editar(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id)
    {
    	return usuarioService.deletar(id);
    }
    
}