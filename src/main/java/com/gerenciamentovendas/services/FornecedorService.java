package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.FornecedorDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
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
	
	public FornecedorDTO buscar(UUID id) {
		Optional<Fornecedor> obj = repoFornecedor.findById(id);
		Fornecedor ret = obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Id: " + id));
		ret.setEmails(repoEmail.findByFornecedor(ret));
		ret.setTelefones(repoTelefone.findByFornecedor(ret));
		return ret; 
	}

	public MessageResponseDTO cadastrar(FornecedorDTO fornecedorDTO) {
		fornecedor.setId(null);
		Fornecedor obj = repoFornecedor.save(fornecedor);
		repoEmail.saveAll(fornecedor.getEmails());
		repoTelefone.saveAll(fornecedor.getTelefones());
		return this.buscar(obj.getId());
	}

	public MessageResponseDTO atualizar(FornecedorDTO fornecedorDTO) {
		this.buscar(fornecedor.getId());
		Fornecedor obj = repoFornecedor.save(fornecedor);		
		repoEmail.saveAll(fornecedor.getEmails());
		repoTelefone.saveAll(fornecedor.getTelefones());
		return this.buscar(obj.getId());
	}

	public MessageResponseDTO deletar(UUID id) {
		this.buscar(id);
		repoFornecedor.deleteById(id);
	}
}
