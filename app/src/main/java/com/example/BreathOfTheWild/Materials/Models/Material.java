package com.example.BreathOfTheWild.Materials.Models;

import com.google.gson.annotations.SerializedName;

public class Material {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
