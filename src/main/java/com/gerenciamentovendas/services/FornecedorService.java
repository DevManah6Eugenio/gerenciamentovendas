package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository repo;

	public Fornecedor buscar(UUID id) {
		Optional<Fornecedor> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public Fornecedor cadastrar(Fornecedor fornecedor) {
		return repo.save(fornecedor);
	}

	public Fornecedor atualizar(Fornecedor fornecedor) {
		return repo.save(fornecedor);
	}

	public void deletar(UUID id) {
		repo.deleteById(id);
	}
}
