package com.gerenciamentovendas.repositories;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentovendas.domain.Email;
import com.gerenciamentovendas.domain.Fornecedor;

public interface EmailRepository extends JpaRepository<Email, UUID> {
	
	Set<Email> findByFornecedor(Fornecedor fornecedor);
}
