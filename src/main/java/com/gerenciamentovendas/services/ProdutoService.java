package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.ProdutoDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.repositories.ProdutoRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;

	public ProdutoDTO buscar(UUID id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: " + id));
	}

	public MessageResponseDTO cadastrar(ProdutoDTO produtoDTO) {
		produto.setId(null);
		return repo.save(produto);
	}

	public MessageResponseDTO atualizar(ProdutoDTO produtoDTO) {
		this.buscar(produto.getId());
		return repo.save(produto);
	}

	public MessageResponseDTO deletar(UUID id) {
		repo.deleteById(id);
	}
}
