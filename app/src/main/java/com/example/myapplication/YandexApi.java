package com.example.myapplication;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Headers;
        import retrofit2.http.Query;

public interface YandexApi {
    @GET("v1/forecast")
    @Headers("X-Yandex-API-Key: 53d94d3c-c1ce-4314-9de1-655482555d8e")
    Call <Info> getweather (@Query("lon") double lon, @Query("lat") double lat);

}
