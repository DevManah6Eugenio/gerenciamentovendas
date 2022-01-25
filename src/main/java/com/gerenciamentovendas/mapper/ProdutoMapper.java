package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.Produto;
import com.gerenciamentovendas.dto.request.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
    Produto toModel(ProdutoDTO produtoDTO);
    ProdutoDTO toDTO(Produto produto);
}
