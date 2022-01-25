package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;
	private String nome;
	private List<ProdutoDTO> produtos;
}
