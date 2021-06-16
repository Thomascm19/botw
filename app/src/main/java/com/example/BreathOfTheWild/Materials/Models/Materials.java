package com.example.BreathOfTheWild.Materials.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Materials {
    @SerializedName("data")
    private List<Material> data;

    public List<Material> getMaterial() {
        return data;
    }

    public void setRequest(List<Material> data) {
        this.data = data;
    }
}
