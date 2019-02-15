package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView temperature;
    Button reload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperature = findViewById(R.id.Saratov);
        reload = findViewById(R.id.Reload);
        LoadTemperature();
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadTemperature();
            }
        });

    }

    void LoadTemperature() {
        App.getRetrofit().create(YandexApi.class).getweather(45.980877, 51.603046)
                .enqueue(new Callback<Info>() {
                    @Override
                    public void onResponse(Call<Info> call, Response<Info> response) {
                        int tempA = response.body().getFact().getTemp();
                        temperature.setText(String.valueOf(tempA));
                    }

                    @Override
                    public void onFailure(Call<Info> call, Throwable t) {
                        t.printStackTrace();
                    }});
    }
}