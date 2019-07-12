package com.mohammad.ui.model;

public class Genre {

    private int mId;
    private String mName;

    public Genre(int mId, String mName) {
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
