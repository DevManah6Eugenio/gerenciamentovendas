package com.gerenciamentovendas.services;

import java.util.Optional;
import java.util.UUID;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.dto.request.ProdutoDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import com.gerenciamentovendas.mapper.ProdutoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.repositories.ProdutoRepository;
import com.gerenciamentovendas.services.exceptions.ObjectNotFoundException;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	private final ProdutoMapper produtoMapper = ProdutoMapper.INSTANCE;

	public ProdutoDTO buscar(UUID id) {
		Produto produto = verifyIfExists(id);
		ProdutoDTO produtoDTO = produtoMapper.toDTO(produto);
		return produtoDTO;
	}

	public MessageResponseDTO cadastrar(ProdutoDTO produtoDTO) {
		Produto produto = produtoMapper.toModel(produtoDTO);
		Produto produtoSalvo = produtoRepository.save(produto);
		return createMessageResponse(produtoSalvo.getId(), "");
	}

	public MessageResponseDTO atualizar(ProdutoDTO produtoDTO, UUID id) {
		verifyIfExists(id);
		Produto produto = produtoMapper.toModel(produtoDTO);
		Produto produtoSalvo = produtoRepository.save(produto);
		return createMessageResponse(produtoSalvo.getId(), "");
	}

	public MessageResponseDTO deletar(UUID id) {
		verifyIfExists(id);
		produtoRepository.deleteById(id);
		return createMessageResponse(id,"Produto Removido com sucesso");
	}

	private Produto verifyIfExists(UUID id) throws ObjectNotFoundException {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado: " + id));
	}

	private MessageResponseDTO createMessageResponse(UUID id, String message) {
		return MessageResponseDTO.builder()
				.message(message + id)
				.build();
	}
}
