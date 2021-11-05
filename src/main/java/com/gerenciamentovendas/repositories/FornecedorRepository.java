package com.gerenciamentovendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentovendas.domain.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

}
