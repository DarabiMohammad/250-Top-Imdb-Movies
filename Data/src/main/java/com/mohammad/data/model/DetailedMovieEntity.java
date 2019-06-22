package com.mohammad.data.model;

import io.reactivex.annotations.NonNull;

public class DetailedMovieEntity extends MovieEntity {

    private String mYear;
    private String mCountry;
    private String mImdbRating;
    private String mRated;
    private String mReleasd;
    private String mRuntime;
    private String mDirector;
    private String mWriter;
    private String mActors;
    private String mPlot;
    private String mAwards;
    private String mMetaScore;
    private String mImdbVotes;
    private String mImdbId;
    private String mType;

    public DetailedMovieEntity(@NonNull int mId, @NonNull String mTitle,
                               @NonNull String mPoster, @NonNull String[] mGenres,
                               @NonNull String[] mImages, @NonNull String mYear,
                               @NonNull String mCountry, @NonNull String mImdbRating,
                               @NonNull String mRated, @NonNull String mReleasd,
                               @NonNull String mRuntime, @NonNull String mDirector,
                               @NonNull String mWriter, @NonNull String mActors,
                               @NonNull String mPlot, @NonNull String mAwards,
                               @NonNull String mMetaScore, @NonNull String mImdbVotes,
                               @NonNull String mImdbId, @NonNull String mType) {
        super(mId, mTitle, mPoster, mGenres, mImages);
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

    public String getActors() {
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
