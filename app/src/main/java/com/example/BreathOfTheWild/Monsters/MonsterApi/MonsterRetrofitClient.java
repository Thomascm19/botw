package com.example.BreathOfTheWild.Monsters.MonsterApi;

import com.example.BreathOfTheWild.Monsters.Service.MonsterService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MonsterRetrofitClient {
    private static MonsterRetrofitClient instance = null;
    private MonsterService monsterService;

    private MonsterRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MonsterService.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        monsterService = retrofit.create(MonsterService.class);
    }

    public static synchronized MonsterRetrofitClient getInstance(){
        if (instance == null){
            instance = new MonsterRetrofitClient();
        }
        return instance;
    }

    public MonsterService getMonsterService(){
        return monsterService;
    }

}
