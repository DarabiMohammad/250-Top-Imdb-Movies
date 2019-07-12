package com.mohammad.ui.mapper;

public interface ViewMapper<P, V> {

    V mapToView(P mPresentation);
}
