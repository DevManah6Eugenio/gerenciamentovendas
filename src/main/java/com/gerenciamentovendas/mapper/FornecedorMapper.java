package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.Fornecedor;
import com.gerenciamentovendas.dto.request.FornecedorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FornecedorMapper {
    FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);
    Fornecedor toModel(FornecedorDTO fornecedorDTO);
    FornecedorDTO toDTO(Fornecedor fornecedor);
}
