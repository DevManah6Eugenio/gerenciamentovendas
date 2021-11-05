package com.gerenciamentovendas.resources;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> getProduto(@PathVariable UUID id) {
		Produto obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		Produto obj = service.cadastrar(produto);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto, @PathVariable UUID id) {
		produto.setId(id);
		Produto obj = service.atualizar(produto);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Produto> deleteProduto(@PathVariable UUID id) {
		Produto obj = service.buscar(id);
		service.deletar(id);
		return ResponseEntity.ok().body(obj);
	}

}
