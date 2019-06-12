package com.mohammad.domain.model;

import io.reactivex.annotations.NonNull;

public class BaseDomainMovieModel {

    private int mId;
    private String mTitle;
    private String mPoster;
    private String[] mGenres;
    private String[] mImages;

    public BaseDomainMovieModel(@NonNull int mId, @NonNull String mTitle,
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

    public String[] getGenres() {
        return mGenres;
    }

    public String[] getImages() {
        return mImages;
    }
}
