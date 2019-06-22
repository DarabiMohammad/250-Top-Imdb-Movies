package com.mohammad.cache.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.mohammad.cache.dao.CachedMoivesDao;
import com.mohammad.cache.dao.ConfigDao;
import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.cache.model.CachedGenres;
import com.mohammad.cache.model.CachedMovie;
import com.mohammad.cache.model.Config;

import javax.inject.Inject;

@Database(entities = {CachedMovie.class, CachedDetailedMovie.class, CachedGenres.class, Config.class},
        version = DbConstants.DB_VERSION, exportSchema = false)
public abstract class MoviesDataBase extends RoomDatabase {

    private MoviesDataBase mInstance = null;

    @Inject
    MoviesDataBase() {
    }

    public abstract CachedMoivesDao getMoviesDao();

    public abstract ConfigDao getConfigDao();

    public MoviesDataBase getInstance(Context mContext) {
        if (mInstance == null) {
            synchronized (this) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(mContext.getApplicationContext(),
                            MoviesDataBase.class,DbConstants.DB_NAME)
                            .build();
                }
            }
        }
        return mInstance;
    }
}
