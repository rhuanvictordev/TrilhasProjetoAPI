package br.com.trilhas.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trilhas.api.dto.LoginDTO;
import br.com.trilhas.api.entity.Usuario;
import br.com.trilhas.api.repository.UsuarioRepository;
import br.com.trilhas.api.security.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final UsuarioRepository usuarioRepository;
	private final JwtUtil jwtUtil;
	
	public AuthController(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
	    this.usuarioRepository = usuarioRepository;
	    this.jwtUtil = jwtUtil;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO dto) {

	    Usuario usuario = usuarioRepository.findByEmail(dto.getEmail()).orElse(null);

	    if (usuario == null || !usuario.getSenha().equals(dto.getSenha())) {
	        throw new RuntimeException("Email ou senha inválidos");
	    }

	    return jwtUtil.gerarToken(usuario.getEmail());
	}

}