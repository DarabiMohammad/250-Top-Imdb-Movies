package com.mohammad.remote.model.common;

import com.google.gson.annotations.SerializedName;

public class UserMovieModel<T> {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("imdb_id")
    private String mImdbId ;

    @SerializedName("country")
    private String mCountry ;

    @SerializedName("year")
    private String mYear ;

    @SerializedName("director")
    private String mDirector ;

    @SerializedName("imdb_rating")
    private String mImdbRating ;

    @SerializedName("imdb_votes")
    private String mImdbVotes;

    @SerializedName("poster")
    private T mPoster ;

    public UserMovieModel(String mTitle, String mImdbId,
                          String mCountry, String mYear,
                          String mDirector, String mImdbRating,
                          String mImdbVotes, T mPoster) {
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
