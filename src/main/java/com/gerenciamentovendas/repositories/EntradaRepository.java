package com.gerenciamentovendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentovendas.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, UUID> {

}
