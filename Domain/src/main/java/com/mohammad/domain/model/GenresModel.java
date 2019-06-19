package com.mohammad.domain.model;

public class GenresModel {

    private int mId;
    private String mName;

    public GenresModel(int mId, String mName) {
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
