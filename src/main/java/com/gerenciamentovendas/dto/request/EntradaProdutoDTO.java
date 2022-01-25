package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaProdutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private UUID id;
	private Double quantidade;
	private Double valorCompra;
	private ProdutoDTO produto;
	private EntradaDTO entreda;
}
