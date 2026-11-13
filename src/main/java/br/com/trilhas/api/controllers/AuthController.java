package br.com.trilhas.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.trilhas.api.dto.LoginDTO;
import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.entity.Usuario;
import br.com.trilhas.api.repository.UsuarioRepository;
import br.com.trilhas.api.security.JwtUtil;
import br.com.trilhas.api.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private UsuarioRepository usuarioRepository;
	private UsuarioService usuarioService;
	private JwtUtil jwtUtil;
	
	public AuthController(UsuarioRepository usuarioRepository, JwtUtil jwtUtil, UsuarioService usuarioService) {
	    this.usuarioService = usuarioService;
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
	
	@PostMapping("/register")
	public UsuarioRespostaDTO register(@RequestBody UsuarioDTO dto) {
		return usuarioService.cadastrar(dto);
	}

}