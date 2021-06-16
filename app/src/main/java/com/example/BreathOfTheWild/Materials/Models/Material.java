package com.example.BreathOfTheWild.Materials.Models;

import com.google.gson.annotations.SerializedName;

public class Material {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialId() {
        return id;
    }

    public void setMaterialId(String id) {
        this.id = id;
    }

}
