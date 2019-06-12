package com.mohammad.domain.model;

public class DomainGenresModel {

    private int mId;
    private String mName ;

    public DomainGenresModel(int mId, String mName) {
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
