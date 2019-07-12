package com.mohammad.cache.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.cache.model.CachedGenres;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class CachedMoivesDao {

    @Query("SELECT * FROM movies")
    public abstract Flowable<List<CachedDetailedMovie>> getAllMoviesFromCache();

    @Query("SELECT * FROM movies WHERE movie_id = :mMovieId LIMIT 1")
    abstract Flowable<CachedDetailedMovie> getMovieByIdFromCache(int mMovieId);

    @Query("SELECT * FROM movies WHERE title LIKE :mTitle")
    public abstract Flowable<List<CachedDetailedMovie>> getMoiveByNameFromCache(String mTitle);

    @Query("SELECT * FROM movies WHERE movie_id IN (:mMovieIds)")
    public abstract Flowable<List<CachedDetailedMovie>> getSpecialGenreMoviesFromCache(int[] mMovieIds);

    @Query("SELECT * FROM movies WHERE movie_id = :mMovieId LIMIT 1")
    public abstract Flowable<CachedDetailedMovie> getDetailedMovieFromCache(int mMovieId);

    @Query("SELECT * FROM genres")
    public abstract Flowable<List<CachedGenres>> getAllGenresFromCache();

    @Query("SELECT genre_movies_id FROM genres WHERE genre_id = :genreId LIMIT 1")
    public abstract String getSpecialGenreMoiveIdsFromCache(int genreId);

    @Query("DELETE FROM movies")
    public abstract void clearAllMoviesFromCache();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveMoviesToCache(List<CachedDetailedMovie> mMovies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveDetailedMovieToCache(CachedDetailedMovie mDetailedMovie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveGenresToCache(List<CachedGenres> mGenres);

    @Query("UPDATE genres SET genre_movies_id = :mMovieIds WHERE genre_id = :genreId")
    public abstract void updateSpecialGenreMovieIds(String mMovieIds, int genreId);
}
