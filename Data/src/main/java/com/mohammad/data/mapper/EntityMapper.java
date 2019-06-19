package com.mohammad.data.mapper;

public interface EntityMapper<E,D> {

    D mapFromEntity(E mEntity);

    E mapToEntity(D mDomain) ;
}
