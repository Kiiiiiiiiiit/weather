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
    TextView nowDtA;
    Button reload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperature = findViewById(R.id.Saratov);
        reload = findViewById(R.id.Reload);
        nowDtA = findViewById(R.id.NowDt);
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
                        String nowDt = response.body().getNowdt();
                        System.out.println(nowDt);
                        StringBuilder temp = new StringBuilder();
                        temp.append(nowDt.charAt(11));
                        System.out.println(nowDt.charAt(11));

                        temp.append(nowDt.charAt(12));
                        System.out.println(nowDt.charAt(12));

                        int saratovTime = Integer.parseInt(temp.toString());
                        saratovTime +=4;
                        if(saratovTime>24){
                            saratovTime=-24;
                        }
                        System.out.println(saratovTime);
                        StringBuilder tempB = new StringBuilder(nowDt);
                        System.out.println(tempB.toString());
                        tempB.replace(11,13, String.valueOf(saratovTime));
                        tempB.replace(10, 11, " ");
                        tempB.delete(19,24);
                        System.out.println(tempB.toString());
                        temperature.setText(String.valueOf(tempA));
                        nowDtA.setText(String.valueOf(tempB.toString()));
                    }

                    @Override
                    public void onFailure(Call<Info> call, Throwable t) {
                        t.printStackTrace();
                    }});
    }
}