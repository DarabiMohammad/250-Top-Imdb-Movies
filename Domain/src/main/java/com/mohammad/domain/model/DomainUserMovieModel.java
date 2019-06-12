package com.mohammad.domain.model;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

public class DomainUserMovieModel<T> {

    private String mTitle;
    private String mImdbId ;
    private String mCountry ;
    private String mYear ;
    private String mDirector ;
    private String mImdbRating ;
    private String mImdbVotes;
    private T mPoster ;

    public DomainUserMovieModel(@NonNull String mTitle, @NonNull String mImdbId,
                                @NonNull String mCountry, @NonNull String mYear,
                                @Nullable String mDirector,@Nullable String mImdbRating,
                                @Nullable String mImdbVotes,@Nullable T mPoster) {
        this.mTitle = mTitle;
        this.mImdbId = mImdbId;
        this.mCountry = mCountry;
        this.mYear = mYear;
        this.mDirector = mDirector;
        this.mImdbRating = mImdbRating;
        this.mImdbVotes = mImdbVotes;
        this.mPoster = mPoster;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getYear() {
        return mYear;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getImdbRating() {
        return mImdbRating;
    }

    public String getImdbVotes() {
        return mImdbVotes;
    }

    public T getPoster() {
        return mPoster;
    }
}
