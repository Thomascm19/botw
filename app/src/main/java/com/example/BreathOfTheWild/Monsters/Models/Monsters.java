package com.example.BreathOfTheWild.Monsters.Models;

import java.util.List;

public class Monsters {

    private List<Monster> data;

    public List<Monster> getMonsters() {
        return data;
    }

    public void setRequest(List<Monster> request) {
        this.data = request;
    }
}
