package com.curiousca.jsonretro.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @Expose
    @SerializedName("payload")
    public ArrayList<PayLoad> payload;

    public ArrayList<PayLoad> getPayload() {
        return payload;
    }

    public void setPayload(ArrayList<PayLoad> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Data{" +
                "payload=" + payload +
                '}';
    }
}
