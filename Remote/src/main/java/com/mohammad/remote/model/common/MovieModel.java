package com.mohammad.remote.model.common;

import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("poster")
    private String mPoster;

    @SerializedName("genres")
    private String[] mGenres;

    @SerializedName("images")
    private String[] mImages;

    public MovieModel(int mId, String mTitle,
                      String mPoster, String[] mGenres,
                      String[] mImages) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mPoster = mPoster;
        this.mGenres = mGenres;
        this.mImages = mImages;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPoster() {
        return mPoster;
    }

    public String[] getGenres() {
        return mGenres;
    }

    public String[] getImages() {
        return mImages;
    }
}
