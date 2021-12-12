package com.gerenciamentovendas.repositories;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {

	Set<Telefone> findByFornecedor(Fornecedor fornecedor);
	
}
