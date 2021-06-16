package com.example.BreathOfTheWild.Monsters.Service;

import com.example.BreathOfTheWild.Materials.Models.MaterialByID;
import com.example.BreathOfTheWild.Monsters.Models.MonsterByID;
import com.example.BreathOfTheWild.Monsters.Models.Monsters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonsterService {

    String BASE_URL = "https://botw-compendium.herokuapp.com/api/v2/";

    @GET("category/monsters")
    Call<Monsters> getMonsters();

    @GET("entry/{id}")
    Call<MonsterByID> getMonster(@Path("id") String id);
}
