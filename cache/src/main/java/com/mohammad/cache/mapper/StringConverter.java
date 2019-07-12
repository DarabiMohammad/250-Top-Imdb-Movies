package com.mohammad.cache.mapper;

import android.arch.persistence.room.TypeConverter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.Serializable;

public class StringConverter implements Serializable {

    @TypeConverter
    public String fromArray(String[] mArray) {
        if (mArray == null)
            return null;
        return new Gson().toJson(mArray, new TypeToken<String[]>() {
        }.getType());
    }

    @TypeConverter
    public String[] toArray(String mString){
        if (mString.isEmpty())
            return null;
        return new Gson().fromJson(mString,new TypeToken<String>(){}.getType());
    }
}
