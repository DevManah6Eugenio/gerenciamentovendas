package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.Telefone;
import com.gerenciamentovendas.dto.request.TelefoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TelefoneMapper {
    TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);
    Telefone toModel(TelefoneDTO telefoneDTO);
    TelefoneDTO toDTO(Telefone telefone);
}
