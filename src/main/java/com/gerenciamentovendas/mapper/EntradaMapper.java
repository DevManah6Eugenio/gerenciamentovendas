package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.Entrada;
import com.gerenciamentovendas.dto.request.EntradaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntradaMapper {
    EntradaMapper INSTANCE = Mappers.getMapper(EntradaMapper.class);
    Entrada toModel(EntradaDTO entradaDTO);
    EntradaDTO toDTO(Entrada entrada);
}
