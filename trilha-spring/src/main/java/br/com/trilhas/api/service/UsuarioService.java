package br.com.trilhas.api.service;

import org.springframework.stereotype.Service;

import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.entity.Usuario;
import br.com.trilhas.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioRespostaDTO cadastrar(UsuarioDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioRespostaDTO(
            salvo.getId(),
            salvo.getNome(),
            salvo.getEmail()
        );
    }
}