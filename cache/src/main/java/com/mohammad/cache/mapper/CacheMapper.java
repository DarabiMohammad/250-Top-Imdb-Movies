package com.mohammad.cache.mapper;

public abstract class CacheMapper<C,E> {

    abstract E mapFromCache(C mCacheModel);

    abstract C mapToCache(E mEntityModel);

    String toString(String[] mArray){
        if (mArray.length<1)
            return null;
        StringBuilder mOutput = new StringBuilder();
        for(String mModel : mArray){
            mOutput.append(mModel).append(",");
        }
        return mOutput.toString();
    }

    String[] fromString(String mString){
        return mString.split(",");
    }
}
