package com.example.BreathOfTheWild.Monsters.Models;
import com.google.gson.annotations.SerializedName;

public class MonsterByID {
    @SerializedName("data")
    private Monster data;

    public Monster getData() {
        return data;
    }

    public void setData(Monster data) {
        this.data = data;
    }
}
