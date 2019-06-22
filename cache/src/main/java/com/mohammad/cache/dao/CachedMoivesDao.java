package com.mohammad.cache.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.cache.model.CachedGenres;
import com.mohammad.cache.model.CachedMovie;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface CachedMoivesDao {

    @Query("SELECT * FROM movies")
    Flowable<List<CachedMovie>> getAllMoviesFromCache();

    @Query("SELECT * FROM movies WHERE movie_id = :mMovieId LIMIT 1")
    Flowable<CachedMovie> getMovieByIdFromCache(int mMovieId);

    @Query("SELECT * FROM movies WHERE title LIKE :mTitle")
    Flowable<List<CachedMovie>> getMoiveByNameFromCache(String mTitle);

    @Query("SELECT * FROM movies WHERE movie_id IN (:mMovieIds)")
    Flowable<List<CachedMovie>> getSpecialGenreMoviesFromCache(int[] mMovieIds);

    @Query("SELECT * FROM detailed_movie WHERE detailed_movie_id = :mMovieId LIMIT 1")
    Flowable<CachedDetailedMovie> getDetailedMovieFromCache(int mMovieId);

    @Query("SELECT * FROM genres")
    Flowable<List<CachedGenres>> getAllGenresFromCache();

    @Query("SELECT genre_movies_id FROM genres WHERE genre_id = :genreId LIMIT 1")
    int[] getSpecialGenreMoiveIdsFromCache(int genreId);

    @Query("DELETE FROM movies")
    void clearAllMoviesFromCache();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable saveMoviesToCache(List<CachedMovie> mMovies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable saveDetailedMovieToCache(CachedDetailedMovie mDetailedMovie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable saveGenresToCache(List<CachedGenres> mGenres);

    @Query("UPDATE genres SET genre_movies_id = :mMovieIds WHERE genre_id = :genreId")
    Completable updateSpecialGenreMovieIds(int[] mMovieIds, int genreId);
}
