package org.example.jobparserarbeitnow.dto.mapper;

public interface DtoResponseMapper<D, M> {
    D toDto(M model);
}
