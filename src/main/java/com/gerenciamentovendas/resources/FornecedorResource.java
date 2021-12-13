package com.gerenciamentovendas.resources;

import java.net.URI;
import java.util.UUID;

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
	public ResponseEntity<Fornecedor> getFornecedor(@PathVariable UUID id) {
		Fornecedor obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Fornecedor> postFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor obj = service.cadastrar(fornecedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<Fornecedor> putFornecedor(@RequestBody Fornecedor fornecedor, @PathVariable UUID id) {
		fornecedor.setId(id);
		Fornecedor obj = service.atualizar(fornecedor);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<Fornecedor> deleteFornecedor(@PathVariable UUID id) {
		Fornecedor obj = service.buscar(id);
		service.deletar(id);
		return ResponseEntity.ok().body(obj);
	}

}
