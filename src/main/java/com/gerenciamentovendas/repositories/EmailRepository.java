package com.gerenciamentovendas.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentovendas.domain.Email;

public interface EmailRepository extends JpaRepository<Email, UUID> {

}
