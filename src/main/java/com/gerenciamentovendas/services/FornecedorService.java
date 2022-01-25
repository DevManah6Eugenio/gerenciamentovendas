package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.dto.request.FornecedorDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import com.gerenciamentovendas.mapper.FornecedorMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.repositories.EmailRepository;
import com.gerenciamentovendas.repositories.FornecedorRepository;
import com.gerenciamentovendas.repositories.TelefoneRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FornecedorService {

	private FornecedorRepository fornecedorRepository;

	private final FornecedorMapper fornecedorMapper = FornecedorMapper.INSTANCE;
	
	public FornecedorDTO buscar(UUID id) {
		Optional<Fornecedor> obj = fornecedorRepository.findById(id);
		Fornecedor ret = obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! Id: " + id));
		return fornecedorMapper.toDTO(ret);
	}

	public MessageResponseDTO cadastrar(FornecedorDTO fornecedorDTO) {
		Fornecedor fornecedor = fornecedorMapper.toModel(fornecedorDTO);
		Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);
		return createMessageResponse(fornecedorSalvo.getId(), "Fornecedor Salvo com sucesso");
	}

	public MessageResponseDTO atualizar(FornecedorDTO fornecedorDTO, UUID id) {
		verifyIfExists(id);
		fornecedorDTO.setId(id);
		Fornecedor fornecedor = fornecedorMapper.toModel(fornecedorDTO);
		Fornecedor obj = fornecedorRepository.save(fornecedor);
		return createMessageResponse(obj.getId(),"Fornecedor Atualizado com sucesso");
	}

	public MessageResponseDTO deletar(UUID id) {
		verifyIfExists(id);
		fornecedorRepository.deleteById(id);
		return createMessageResponse(id, "Fornecedor Removida com sucesso");
	}

	private Fornecedor verifyIfExists(UUID id) throws ObjectNotFoundException {
		return fornecedorRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado: " + id));
	}

	private MessageResponseDTO createMessageResponse(UUID id, String message) {
		return MessageResponseDTO.builder()
				.message(message + id)
				.build();
	}
}
