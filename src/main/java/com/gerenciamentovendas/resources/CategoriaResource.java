package com.gerenciamentovendas.resources;

import java.net.URI;
import java.util.UUID;

import com.gerenciamentovendas.dto.request.CategoriaDTO;
import com.gerenciamentovendas.dto.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciamentovendas.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) 
	public ResponseEntity<CategoriaDTO> getCategoria(@PathVariable UUID id) {
		CategoriaDTO obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public MessageResponseDTO postCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		return service.cadastrar(categoriaDTO);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		//return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT) 
	public MessageResponseDTO putCategoria(@RequestBody CategoriaDTO categoriaDTO, @PathVariable UUID id) {
		return service.atualizar(categoriaDTO, id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE) 
	public MessageResponseDTO deleteCategoria(@PathVariable UUID id) {
		return service.deletar(id);
	}
}
