package com.mohammad.cache.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.mohammad.cache.db.DbConstants;

@Entity(tableName = DbConstants.CONFIG_TABLE_NAME,indices = @Index("last_cache_time"))
public class Config {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int mId ;

    @ColumnInfo(name = "last_cache_time")
    private long mLastCacheTime ;

    public Config(long mLastCacheTime) {
        this.mLastCacheTime = mLastCacheTime;
    }

    public long getLastCacheTime() {
        return mLastCacheTime;
    }
}
