package com.example.myapplication;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {
    private static Retrofit retrofit;
    HttpLoggingInterceptor inter = new HttpLoggingInterceptor();
    private Gson gson = new GsonBuilder().create();
    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weather.yandex.ru/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
