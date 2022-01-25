package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String ddd;
	private String numero;
	private FornecedorDTO fornecedorDTO;
}
