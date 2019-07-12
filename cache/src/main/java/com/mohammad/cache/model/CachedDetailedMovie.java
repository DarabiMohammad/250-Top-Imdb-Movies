package com.mohammad.cache.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.mohammad.cache.db.DbConstants;

@Entity(tableName = DbConstants.MOVIES_TABLE_NAME,
        indices = {@Index(value = "movie_id", unique = true)}, inheritSuperIndices = true)
public class CachedDetailedMovie {


    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    private int mId;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "poster")
    private String mPoster;

    @ColumnInfo(name = "genres")
    private String mGenres;

    @ColumnInfo(name = "images_path")
    private String mImages;

    @ColumnInfo(name = "year")
    private String mYear;

    @ColumnInfo(name = "country")
    private String mCountry;

    @ColumnInfo(name = "imdb_rating")
    private String mImdbRating;

    @ColumnInfo(name = "rated")
    private String mRated;

    @ColumnInfo(name = "released")
    private String mReleased;

    @ColumnInfo(name = "runtime")
    private String mRuntime;

    @ColumnInfo(name = "director")
    private String mDirector;

    @ColumnInfo(name = "writer")
    private String mWriter;

    @ColumnInfo(name = "actors")
    private String mActors;

    @ColumnInfo(name = "plot")
    private String mPlot;

    @ColumnInfo(name = "awards")
    private String mAwards;

    @ColumnInfo(name = "meta_score")
    private String mMetaScore;

    @ColumnInfo(name = "imdb_votes")
    private String mImdbVotes;

    @ColumnInfo(name = "imdb_id")
    private String mImdbId;

    @ColumnInfo(name = "type")
    private String mType;

    public CachedDetailedMovie(int mId, String mTitle,
                               String mPoster, String mGenres,
                               String mImages, String mYear,
                               String mCountry, String mImdbRating,
                               String mRated, String mReleased,
                               String mRuntime, String mDirector,
                               String mWriter, String mActors,
                               String mPlot, String mAwards,
                               String mMetaScore, String mImdbVotes,
                               String mImdbId, String mType) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mPoster = mPoster;
        this.mGenres = mGenres;
        this.mImages = mImages;
        this.mYear = mYear;
        this.mCountry = mCountry;
        this.mImdbRating = mImdbRating;
        this.mRated = mRated;
        this.mReleased = mReleased;
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
        return mGenres;
    }

    public String getImages() {
        return mImages;
    }

    public int getMovieId() {
        return mId;
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

    public String getReleased() {
        return mReleased;
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
