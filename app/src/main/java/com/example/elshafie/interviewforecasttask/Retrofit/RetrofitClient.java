package com.example.elshafie.interviewforecasttask.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Elshafie on 11/17/2018.
 */

public class RetrofitClient {
    private static Retrofit instence;
    
    public static Retrofit getInstance() {
        if(instence==null)
            instence =new Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return instence;
    }
}
