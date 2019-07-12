package com.mohammad.ui.model;

import io.reactivex.annotations.NonNull;

public class Movie {

    private int mId;
    private String mTitle;
    private String mPoster;
    private String[] mGenres;
    private String[] mImages;

    public Movie(@NonNull int mId, @NonNull String mTitle,
                 @NonNull String mPoster, @NonNull String[] mGenres,
                 @NonNull String[] mImages) {
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

    public String getGenres() {
        StringBuilder mGenresString = new StringBuilder();
        for (int i = 0; i < mGenres.length; i++) {
            mGenresString.append(mGenres[i].concat(", "));
        }
        return mGenresString.toString();
    }

    public String[] getImages() {
        return mImages;
    }
}
