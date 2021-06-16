package com.example.BreathOfTheWild.Monsters.Models;

import com.google.gson.annotations.SerializedName;

public class Monster {

    private String name;

    private String id;

    @SerializedName("image")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonsterID() {
        return id;
    }

    public void setMonsterID(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
