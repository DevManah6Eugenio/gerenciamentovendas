package com.gerenciamentovendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentovendas.domain.EntradaProduto;

@Repository
public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, UUID> {

}
