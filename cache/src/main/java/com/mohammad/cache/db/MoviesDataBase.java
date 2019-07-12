package com.mohammad.cache.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.mohammad.cache.dao.CachedMoivesDao;
import com.mohammad.cache.dao.ConfigDao;
import com.mohammad.cache.mapper.StringConverter;
import com.mohammad.cache.model.CachedDetailedMovie;
import com.mohammad.cache.model.CachedGenres;
import com.mohammad.cache.model.Config;

@Database(entities = {CachedDetailedMovie.class, CachedGenres.class, Config.class},
        version = DbConstants.DB_VERSION, exportSchema = false)
@TypeConverters(StringConverter.class)
public abstract class MoviesDataBase extends RoomDatabase {

    private static MoviesDataBase mInstance = null;

    public abstract CachedMoivesDao getMoviesDao();

    public abstract ConfigDao getConfigDao();

    public static MoviesDataBase getInstance(Context mContext) {
        if (mInstance == null) {
            synchronized (MoviesDataBase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(mContext.getApplicationContext(),
                            MoviesDataBase.class, DbConstants.DB_NAME)
                            .build();
                }
            }
        }
        return mInstance;
    }
}
