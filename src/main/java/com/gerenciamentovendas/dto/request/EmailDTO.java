package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO {
	private UUID id;
	private String enderecoEletronico;
	private FornecedorDTO fornecedor;
}
