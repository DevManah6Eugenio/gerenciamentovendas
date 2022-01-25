package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.repositories.ProdutoRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;

	public Produto buscar(UUID id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: " + id));
	}

	public Produto cadastrar(Produto produto) {
		produto.setId(null);
		return repo.save(produto);
	}

	public Produto atualizar(Produto produto) {
		this.buscar(produto.getId());
		return repo.save(produto);
	}

	public void deletar(UUID id) {
		repo.deleteById(id);
	}
}
