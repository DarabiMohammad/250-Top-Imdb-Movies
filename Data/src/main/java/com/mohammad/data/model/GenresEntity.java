package com.mohammad.data.model;

public class GenresEntity {

    private int mId;
    private String mName;

    public GenresEntity(int mId, String mName) {
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
