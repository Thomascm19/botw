package com.example.BreathOfTheWild.Materials.Models;

import com.google.gson.annotations.SerializedName;

public class Material {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private String image;

    @SerializedName("category")
    private String category;

    @SerializedName("cooking_effect")
    private String cooking_effect;

    @SerializedName("description")
    private String description;

    @SerializedName("hearts_recovered")
    private String hearts_recovered;


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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCooking_effect() {
        return cooking_effect;
    }

    public void setCooking_effect(String cooking_effect) {
        this.cooking_effect = cooking_effect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHearts_recovered() {
        return hearts_recovered;
    }

    public void setHearts_recovered(String hearts_recovered) {
        this.hearts_recovered = hearts_recovered;
    }
}
