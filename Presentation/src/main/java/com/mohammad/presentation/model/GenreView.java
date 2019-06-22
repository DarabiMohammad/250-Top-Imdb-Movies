package com.mohammad.presentation.model;

public class GenreView {

    private int mId;
    private String mName;

    public GenreView(int mId, String mName) {
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
