package com.mohammad.cache.mapper;

public interface CacheMapper<C,E> {

    E mapFromCache(C mCacheModel);

    C mapToCache(E mEntityModel);
}
