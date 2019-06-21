package com.mohammad.remote.model.common;

import com.google.gson.annotations.SerializedName;

public class GenreModel {

    @SerializedName("id")
    private int mId;

    @SerializedName("name")
    private String mName;

    public GenreModel(int mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
