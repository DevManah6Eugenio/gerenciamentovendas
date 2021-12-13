package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.repositories.EmailRepository;
import com.gerenciamentovendas.repositories.FornecedorRepository;
import com.gerenciamentovendas.repositories.TelefoneRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

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
		Fornecedor ret = obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Id: " + id));
		ret.setEmails(repoEmail.findByFornecedor(ret));
		ret.setTelefones(repoTelefone.findByFornecedor(ret));
		return ret; 
	}

	public Fornecedor cadastrar(Fornecedor fornecedor) {
		fornecedor.setId(null);
		Fornecedor obj = repoFornecedor.save(fornecedor);
		repoEmail.saveAll(fornecedor.getEmails());
		repoTelefone.saveAll(fornecedor.getTelefones());
		return this.buscar(obj.getId());
	}

	public Fornecedor atualizar(Fornecedor fornecedor) {
		Fornecedor obj = repoFornecedor.save(fornecedor);		
		repoEmail.saveAll(fornecedor.getEmails());
		repoTelefone.saveAll(fornecedor.getTelefones());
		return this.buscar(obj.getId());
	}

	public void deletar(UUID id) {
		repoFornecedor.deleteById(id);
	}
}
