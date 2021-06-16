package com.example.BreathOfTheWild.Materials.Models;

import com.google.gson.annotations.SerializedName;

public class MaterialByID {
    @SerializedName("data")
    private Material data;

    public Material getData() {
        return data;
    }

    public void setData(Material data) {
        this.data = data;
    }
}
