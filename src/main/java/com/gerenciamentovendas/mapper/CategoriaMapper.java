package com.gerenciamentovendas.mapper;

import com.gerenciamentovendas.domain.Categoria;
import com.gerenciamentovendas.dto.request.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toModel(CategoriaDTO categoriaDTO);

    CategoriaDTO toDTO(Categoria categoria);
}
