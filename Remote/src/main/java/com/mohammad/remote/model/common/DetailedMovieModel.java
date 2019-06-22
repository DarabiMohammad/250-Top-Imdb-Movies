package com.mohammad.remote.model.common;

import com.google.gson.annotations.SerializedName;

public class DetailedMovieModel extends MovieModel{

    @SerializedName("year")
    private String mYear;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("imdb_rating")
    private String mImdbRating;

    @SerializedName("rated")
    private String mRated;

    @SerializedName("released")
    private String mReleasd;

    @SerializedName("runtime")
    private String mRuntime;

    @SerializedName("director")
    private String mDirector;

    @SerializedName("writer")
    private String mWriter;

    @SerializedName("actors")
    private String mActors;

    @SerializedName("plot")
    private String mPlot;

    @SerializedName("awards")
    private String mAwards;

    @SerializedName("metascore")
    private String mMetaScore;

    @SerializedName("imdb_votes")
    private String mImdbVotes;

    @SerializedName("imdb_id")
    private String mImdbId;

    @SerializedName("type")
    private String mType ;

    public DetailedMovieModel(int mId, String mTitle,
                              String mPoster, String[] mGenres,
                              String[] mImages,String mYear,
                              String mCountry, String mImdbRating,
                              String mRated, String mReleasd,
                              String mRuntime, String mDirector,
                              String mWriter, String mActors, String mPlot,
                              String mAwards, String mMetaScore,
                              String mImdbVotes, String mImdbId,
                              String mType) {
        super(mId,mTitle,mPoster,mGenres,mImages);
        this.mYear = mYear;
        this.mCountry = mCountry;
        this.mImdbRating = mImdbRating;
        this.mRated = mRated;
        this.mReleasd = mReleasd;
        this.mRuntime = mRuntime;
        this.mDirector = mDirector;
        this.mWriter = mWriter;
        this.mActors = mActors;
        this.mPlot = mPlot;
        this.mAwards = mAwards;
        this.mMetaScore = mMetaScore;
        this.mImdbVotes = mImdbVotes;
        this.mImdbId = mImdbId;
        this.mType = mType;
    }

    public String getYear() {
        return mYear;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getImdbRating() {
        return mImdbRating;
    }

    public String getRated() {
        return mRated;
    }

    public String getReleasd() {
        return mReleasd;
    }

    public String getRuntime() {
        return mRuntime;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getWriter() {
        return mWriter;
    }

    public String getmActors() {
        return mActors;
    }

    public String getPlot() {
        return mPlot;
    }

    public String getAwards() {
        return mAwards;
    }

    public String getMetaScore() {
        return mMetaScore;
    }

    public String getImdbVotes() {
        return mImdbVotes;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public String getType() {
        return mType;
    }
}
