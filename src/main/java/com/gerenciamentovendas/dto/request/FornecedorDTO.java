package com.gerenciamentovendas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private Set<EmailDTO> emails;
	private Set<TelefoneDTO> telefones;
	private Set<EntradaDTO> entrada;
}
