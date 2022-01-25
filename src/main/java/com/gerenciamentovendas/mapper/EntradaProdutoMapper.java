package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.EntradaProduto;
import com.gerenciamentovendas.dto.request.EntradaProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntradaProdutoMapper {
    EntradaProdutoMapper INSTANCE = Mappers.getMapper(EntradaProdutoMapper.class);
    EntradaProduto toModel(EntradaProdutoDTO entradaProdutoDTO);
    EntradaProdutoDTO toDTO(EntradaProduto entradaProduto);
}
