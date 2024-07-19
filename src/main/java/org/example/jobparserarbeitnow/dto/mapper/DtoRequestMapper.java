package org.example.jobparserarbeitnow.dto.mapper;

public interface DtoRequestMapper<D, M> {
    M toModel(D dto);
}
