package com.gerenciamentovendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, UUID> {

}
