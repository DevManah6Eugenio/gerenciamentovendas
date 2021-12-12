package com.gerenciamentovendas.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Fornecedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "uuid-binary")
	private UUID id;
	
	@Column(nullable = false, length = 14)
	private String cnpj;
	
	private String razaoSocial;
	
	@Column(nullable = false, length = 40)
	private String nomeFantasia;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "fornecedor")
	private Set<Email> emails;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "fornecedor")
	private Set<Telefone> telefones;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "fornecedor")
	private Set<Entrada> entrada;
	
}
