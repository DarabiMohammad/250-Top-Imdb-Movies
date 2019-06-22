package com.mohammad.cache.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.mohammad.cache.db.DbConstants;

@Entity(tableName = DbConstants.GENRES_TABLE_NAME,
        foreignKeys = @ForeignKey(entity = CachedMovie.class,
                parentColumns = "movie_id",
                childColumns = "genre_movies_id",
                onDelete = ForeignKey.CASCADE))
public class CachedGenres {

    @PrimaryKey
    @ColumnInfo(name = "genre_id")
    private int mId;

    @ColumnInfo(name = "genre_movies_id")
    private int[] mMoviesId;

    @ColumnInfo(name = "genre_name")
    private String mName;

    public CachedGenres(int mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public void setMoviesId(int[] mMoviesId) {
        this.mMoviesId = mMoviesId;
    }

    public int getId() {
        return mId;
    }

    public int[] getMoviesId() {
        if (mMoviesId.length > 0)
            return mMoviesId;
        else
            throw new UnsupportedOperationException("There Is No Cached Movie For This Genre");
    }

    public String getName() {
        return mName;
    }
}
