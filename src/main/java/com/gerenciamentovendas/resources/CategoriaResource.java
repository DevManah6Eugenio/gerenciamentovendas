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

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Categoria> getCategoria(@PathVariable UUID id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> postCategoria(@RequestBody Categoria categoria) {
		Categoria obj = service.cadastrar(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT) 
	public ResponseEntity<?> putCategoria(@RequestBody Categoria categoria, @PathVariable UUID id) {
		categoria.setId(id);
		service.atualizar(categoria);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE) 
	public ResponseEntity<?> deleteCategoria(@PathVariable UUID id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
