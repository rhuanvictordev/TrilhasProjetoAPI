package br.com.trilhas.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trilhas.api.dto.TrilhaDTO;
import br.com.trilhas.api.dto.TrilhaRespostaDTO;
import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.entity.Trilha;
import br.com.trilhas.api.entity.Usuario;
import br.com.trilhas.api.repository.TrilhaRepository;
import br.com.trilhas.api.service.TrilhaService;
import br.com.trilhas.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/api/trilhas")
@SecurityRequirement(name = "Bearer Authentication")
public class TrilhaController {
	
	private TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }
    
    @GetMapping("/{id}")
    public Trilha buscar(@PathVariable Long id){
    	return trilhaService.buscar(id);
    }
    
    @GetMapping
    public List<Trilha> listar(){
    	
    	return trilhaService.listar();
    }
    
    @PostMapping
    public TrilhaRespostaDTO cadastrar(@RequestBody TrilhaDTO dto) {
        return trilhaService.cadastrar(dto);
    }
    
    
    @PutMapping("/{id}")
    public Trilha editar(@PathVariable Long id, @RequestBody TrilhaDTO dto) {
        return trilhaService.editar(id, dto);
    }
    
    
    @DeleteMapping("/{id}")
    public boolean deletar(@PathVariable Long id)
    {
    	return trilhaService.deletar(id);
    }
    
    
}
