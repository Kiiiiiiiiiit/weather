package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("now")
    @Expose
    private int now;
    @SerializedName("now_dt")
    @Expose
    private String nowdt;
    @SerializedName("fact")
    @Expose
    private Fact fact;

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public String getNowdt() {
        return nowdt;
    }

    public void setNowdt(String nowdt) {
        this.nowdt = nowdt;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }
}
