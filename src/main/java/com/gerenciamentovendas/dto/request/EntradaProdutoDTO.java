package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaProdutoDTO {
	private UUID id;
	private Double quantidade;
	private Double valorCompra;
	private ProdutoDTO produto;
	private EntradaDTO entreda;
}
