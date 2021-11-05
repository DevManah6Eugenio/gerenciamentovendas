package com.gerenciamentovendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentovendas.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

}
