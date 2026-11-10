package br.com.trilhas.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.trilhas.api.entity.Trilha;
import br.com.trilhas.api.entity.Usuario;

public interface TrilhaRepository extends JpaRepository<Trilha, Long> {
	
	
}
