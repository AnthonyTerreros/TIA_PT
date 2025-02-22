package com.tiapt.backend_prueba_tecnica_tia.utils;

import java.util.List;

import org.springframework.data.domain.Page;

public interface GenericMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    default Page<D> toDto(Page<E> entityPage) {
        return entityPage.map(data -> toDto(data));
    }
}