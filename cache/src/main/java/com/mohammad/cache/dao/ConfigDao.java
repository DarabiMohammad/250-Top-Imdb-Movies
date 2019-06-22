package com.mohammad.cache.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.mohammad.cache.model.Config;

import io.reactivex.Single;

@Dao
public interface ConfigDao {

    @Query("SELECT * FROM config LIMIT 1")
    Single<Config> getConfig();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertConfig(Config mConfig);
}
