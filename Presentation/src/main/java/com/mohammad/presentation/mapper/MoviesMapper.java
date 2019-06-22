package com.mohammad.presentation.mapper;

public interface MoviesMapper<V,D> {

    V mapToView(D mData);
}
