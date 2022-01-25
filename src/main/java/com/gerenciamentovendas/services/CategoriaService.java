package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.CategoriaDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import com.gerenciamentovendas.mapper.CategoriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.repositories.CategoriaRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;
	
	public CategoriaDTO buscar(UUID id) {
		Categoria categoria = verifyIfExists(id);
		CategoriaDTO categoriaDTO = categoriaMapper.toDTO(categoria);
		return categoriaDTO;
	}
	
	public MessageResponseDTO cadastrar(CategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaMapper.toModel(categoriaDTO);
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return createMessageResponse(categoriaSalva.getId(), "Categoria Salva com sucesso");
	}
	
	public MessageResponseDTO atualizar(CategoriaDTO categoriaDTO, UUID id) {
		verifyIfExists(id);
		Categoria categoria = categoriaMapper.toModel(categoriaDTO);
		categoria.setId(id);
		categoriaRepository.save(categoria);
		return createMessageResponse(id, "Categoria Atualizada com sucesso");
	}
	
	public MessageResponseDTO deletar(UUID id) {
		this.verifyIfExists(id);
		categoriaRepository.deleteById(id);
		return createMessageResponse(id,"Categoria Removida com sucesso");
	}

	private Categoria verifyIfExists(UUID id) throws ObjectNotFoundException {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Consultoria não encontrada: " + id));
	}

	private MessageResponseDTO createMessageResponse(UUID id, String message) {
		return MessageResponseDTO.builder()
				.message(message + id)
				.build();
	}
}