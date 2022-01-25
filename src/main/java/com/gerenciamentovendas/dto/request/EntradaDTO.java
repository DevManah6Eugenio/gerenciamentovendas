package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaDTO {
	private UUID id;
	private Date data;
	private Double custosAdicionais;
	private FornecedorDTO fornecedor;
	private List<EntradaProdutoDTO> entradaProduto;
}
