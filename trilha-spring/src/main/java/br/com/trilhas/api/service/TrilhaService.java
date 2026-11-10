package br.com.trilhas.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.trilhas.api.dto.TrilhaDTO;
import br.com.trilhas.api.dto.TrilhaRespostaDTO;
import br.com.trilhas.api.dto.UsuarioDTO;
import br.com.trilhas.api.dto.UsuarioRespostaDTO;
import br.com.trilhas.api.entity.Trilha;
import br.com.trilhas.api.entity.Usuario;
import br.com.trilhas.api.repository.TrilhaRepository;
import br.com.trilhas.api.repository.UsuarioRepository;

@Service
public class TrilhaService {
	
	private TrilhaRepository trilhaRepository;

	
    public TrilhaService(TrilhaRepository trilhaRepository) {
        this.trilhaRepository = trilhaRepository;
    }
    

    public TrilhaRespostaDTO cadastrar(TrilhaDTO dto) {
    	
    	Trilha trilha = new Trilha();
    	
    	
    	
    	trilha.setNome(dto.getNome());
    	trilha.setDescricao(dto.getDescricao());
    	trilha.setDistanciaMetros(dto.getDistanciaMetros());
    	
    	
    	
    	
    	
    	Trilha trilhaSalva = trilhaRepository.save(trilha);
    	
    	
    	
    	
    	
    	
    	return new TrilhaRespostaDTO(
    			
    			trilhaSalva.getId(), 
    			trilhaSalva.getNome(), 
    			trilhaSalva.getDescricao(), 
    			trilhaSalva.getDistanciaMetros()
    			);
    }
    
    
    
    
    
    
    
    
    public List<Trilha> listar()
    {
    	return trilhaRepository.findAll();
    }
    
    
    
    
    
    
    
    
    
    public Trilha editar(Long id, TrilhaDTO dto) {

        Trilha trilha = trilhaRepository.findById(id).orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        trilha.setNome(dto.getNome());
        trilha.setDescricao(dto.getDescricao());
        trilha.setDistanciaMetros(dto.getDistanciaMetros());

        return trilhaRepository.save(trilha);
    }
    
    
    
    
    public boolean deletar(long id)
    {
    	Trilha favorita = new Trilha();
    	favorita.setId(id);
    	trilhaRepository.delete(favorita);
    	return true;
    }
    
    
    
}
