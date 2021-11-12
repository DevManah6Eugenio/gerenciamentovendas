package com.gerenciamentovendas.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrada implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-binary")
	private UUID id;
	
	private Date data;
	
	private Double custosAdicionais;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "entrada")
	private List<EntradaProduto> entradaProduto;
}
