package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;

	public Produto buscar(UUID id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Produto cadastrar(Produto produto) {
		return repo.save(produto);
	}

	public Produto atualizar(Produto produto) {
		return repo.save(produto);
	}

	public void deletar(UUID id) {
		repo.deleteById(id);
	}
}
