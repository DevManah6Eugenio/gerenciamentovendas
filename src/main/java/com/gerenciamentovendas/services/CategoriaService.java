package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(UUID id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Categoria cadastrar(Categoria categoria) {
		return repo.save(categoria);
	}
	
	public Categoria atualizar(Categoria categoria) {
		return repo.save(categoria);
	}
	
	public void deletar(UUID id) {
		repo.deleteById(id);
	}
}