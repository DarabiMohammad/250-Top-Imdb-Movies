package com.mohammad.domain.model;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class DomainMovieModel {

    private int mId;
    private String mTitle;
    private String mPoster;
    private List<String> mGenres;
    private List<String> mImages;

    public DomainMovieModel(@NonNull int mId, @NonNull String mTitle,
                            @NonNull String mPoster, @NonNull List<String> mGenres,
                            @NonNull List<String> mImages) {
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

    public List<String> getGenres() {
        return mGenres;
    }

    public List<String> getImages() {
        return mImages;
    }
}
