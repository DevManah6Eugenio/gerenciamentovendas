package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {

	private UUID id;
	private String ddd;
	private String numero;
	private FornecedorDTO fornecedorDTO;
}
