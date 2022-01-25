package com.gerenciamentovendas.resources;

import java.net.URI;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.ProdutoDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoDTO> getProduto(@PathVariable UUID id) {
		ProdutoDTO obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public MessageResponseDTO postProduto(@RequestBody ProdutoDTO produtoDTO) {
		return service.cadastrar(produtoDTO);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public MessageResponseDTO putProduto(@RequestBody ProdutoDTO produtoDTO, @PathVariable UUID id) {
		return service.atualizar(produtoDTO, id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public MessageResponseDTO deleteProduto(@PathVariable UUID id) {
		return service.deletar(id);
	}

}
