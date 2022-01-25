package com.gerenciamentovendas.resources;

import java.net.URI;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.FornecedorDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.services.FornecedorService;

@RestController
@RequestMapping(value="/fornecedores")
public class FornecedorResource {

	@Autowired
	private FornecedorService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) 
	public ResponseEntity<FornecedorDTO> getFornecedor(@PathVariable UUID id) {
		FornecedorDTO obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public MessageResponseDTO postFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
		return service.cadastrar(fornecedorDTO);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT) 
	public MessageResponseDTO putFornecedor(@RequestBody FornecedorDTO fornecedorDTO, @PathVariable UUID id) {
		return service.atualizar(fornecedorDTO, id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE) 
	public MessageResponseDTO deleteFornecedor(@PathVariable UUID id) {
		return service.deletar(id);
	}

}
