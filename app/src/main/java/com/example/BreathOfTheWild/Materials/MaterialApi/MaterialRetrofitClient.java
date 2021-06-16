package com.example.BreathOfTheWild.Materials.MaterialApi;

import com.example.BreathOfTheWild.Materials.Service.MaterialService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MaterialRetrofitClient {
    private static MaterialRetrofitClient instance = null;
    private MaterialService materialService;

    private MaterialRetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MaterialService.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        materialService = retrofit.create(MaterialService.class);
    }

    public static synchronized MaterialRetrofitClient getInstance(){
        if (instance == null){
            instance = new MaterialRetrofitClient();
        }
        return instance;
    }

    public MaterialService getMaterialService(){
        return materialService;
    }
}
