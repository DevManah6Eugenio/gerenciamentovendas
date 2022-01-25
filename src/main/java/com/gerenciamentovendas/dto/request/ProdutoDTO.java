package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
	private UUID Id;
	private String codigo;
	private String nome;
	private Double percentualLucro;
	private Double valorVenda;
	private CategoriaDTO categoria;
	private List<EntradaProdutoDTO> entradaProduto;
}
