package com.example.BreathOfTheWild.Monsters.Service;

import com.example.BreathOfTheWild.Monsters.Models.Monsters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MonsterService {

    String BASE_URL = "https://botw-compendium.herokuapp.com/api/v2/";

    @GET("category/monsters")
    Call<Monsters> getMonsters();
}
