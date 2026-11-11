package br.com.trilhas.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trilhas.api.dto.TrilhaDTO;
import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.entity.Trilha;
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
    
    public Usuario buscar(Long id)
    {
    	return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }
    
    
    public List<Usuario> listar()
    {
    	return usuarioRepository.findAll();
    }
    
    
    public Usuario editar(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return usuarioRepository.save(usuario);
    }
    
    
    public boolean deletar(long id)
    {
    	Usuario usuario = new Usuario();
    	usuario.setId(id);
    	usuarioRepository.delete(usuario);
    	return true;
    }
    
    
}