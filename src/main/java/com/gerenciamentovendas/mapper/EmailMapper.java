package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.Email;
import com.gerenciamentovendas.dto.request.EmailDTO;
import org.mapstruct.factory.Mappers;

public interface EmailMapper {
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    Email toModel(EmailDTO emailDTO);

    EmailDTO toDTO(Email email);
}
