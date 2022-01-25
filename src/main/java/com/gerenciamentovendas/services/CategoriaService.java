package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.CategoriaDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import com.gerenciamentovendas.mapper.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.repositories.CategoriaRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	Autowired
	private CategoriaMapper categoriaMapper;
	
	public CategoriaDTO buscar(UUID id) {
		Categoria categoria = verifyIfExists(id);
		CategoriaDTO categoriaDTO = categoriaMapper.toDTO(categoria);
		return categoriaDTO;
	}
	
	public MessageResponseDTO cadastrar(CategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaMapper.toModel(categoriaDTO)
		return repo.save(categoria);
	}
	
	public MessageResponseDTO atualizar(CategoriaDTO categoriaDTO) {
		this.buscar(categoria.getId());
		return repo.save(categoria);
	}
	
	public MessageResponseDTO deletar(UUID id) {
		this.verifyIfExists(id);
		repo.deleteById(id);
	}

	private Categoria verifyIfExists(UUID id) throws PersonNotFoundException {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(id));
	}
}