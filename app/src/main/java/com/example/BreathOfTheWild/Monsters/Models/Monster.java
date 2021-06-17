package com.example.BreathOfTheWild.Monsters.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Monster {

    @SerializedName("category")
    private String category;

    @SerializedName("common_locations")
    private List<String> commonLocations = null;

    @SerializedName("description")
    private String description;

    @SerializedName("drops")
    private List<String> drops = null;

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCommonLocations() {
        return commonLocations;
    }

    public void setCommonLocations(List<String> commonLocations) {
        this.commonLocations = commonLocations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDrops() {
        return drops;
    }

    public void setDrops(List<String> drops) {
        this.drops = drops;
    }
}
