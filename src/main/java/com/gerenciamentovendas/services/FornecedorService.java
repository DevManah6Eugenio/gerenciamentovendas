package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.repositories.EmailRepository;
import com.gerenciamentovendas.repositories.FornecedorRepository;
import com.gerenciamentovendas.repositories.TelefoneRepository;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository repoFornecedor;
	@Autowired
	private EmailRepository repoEmail;
	@Autowired
	private TelefoneRepository repoTelefone;
	
	public Fornecedor buscar(UUID id) {
		Optional<Fornecedor> obj = repoFornecedor.findById(id);
		return obj.orElse(null);
	}

	public Fornecedor cadastrar(Fornecedor fornecedor) {
		Fornecedor obj = repoFornecedor.save(fornecedor);
		repoEmail.saveAll(fornecedor.getEmails());
		repoTelefone.saveAll(fornecedor.getTelefones());
		return this.buscar(obj.getId());
	}

	public Fornecedor atualizar(Fornecedor fornecedor) {
		return repoFornecedor.save(fornecedor);
	}

	public void deletar(UUID id) {
		repoFornecedor.deleteById(id);
	}
}
