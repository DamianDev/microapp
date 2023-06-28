package com.damiandev.microapp.microappcustomers.mapper.base;

public interface BaseMapper<DTO, ENTITY> {
    ENTITY dtoToEntity(DTO dto);
    DTO entityToDto(ENTITY entity);
}
