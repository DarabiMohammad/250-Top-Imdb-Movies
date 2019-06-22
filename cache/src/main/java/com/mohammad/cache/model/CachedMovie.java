package com.mohammad.cache.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.mohammad.cache.db.DbConstants;

@Entity(tableName = DbConstants.MOVIES_TABLE_NAME,
        indices = {@Index(value = "title", unique = true),
                @Index(value = "movie_id", unique = true)})
public class CachedMovie {

    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    private int mId;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "poster")
    private String mPoster;

    @ColumnInfo(name = "genres")
    private String[] mGenres;

    @ColumnInfo(name = "images_path")
    private String[] mImages;

    public CachedMovie(int mId, String mTitle, String mPoster,
                       String[] mGenres, String[] mImages) {
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
