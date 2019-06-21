package com.mohammad.remote.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MoviesApiServiceFactory {

    private final String BASE_URL = "http://moviesapi.ir/api/v1/";

    public MoviesApiMethods makeMoviesApiMethods(boolean mIsDebugMode){
        return makeRetrofitService(makeOkHttpClient(makeLoggingInterceptor(mIsDebugMode)));
    }

    private HttpLoggingInterceptor makeLoggingInterceptor(boolean mIsDebugMode) {
        HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor();
        if (mIsDebugMode)
            mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        else
            mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        return mLoggingInterceptor ;
    }

    private OkHttpClient makeOkHttpClient(HttpLoggingInterceptor mLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(mLoggingInterceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS).build();
    }

    private MoviesApiMethods makeRetrofitService(OkHttpClient mClient){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(mClient)
                .build().create(MoviesApiMethods.class);
    }
}
