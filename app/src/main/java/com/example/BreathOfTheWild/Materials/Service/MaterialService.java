package com.example.BreathOfTheWild.Materials.Service;

import com.example.BreathOfTheWild.Materials.Models.Material;
import com.example.BreathOfTheWild.Materials.Models.MaterialByID;
import com.example.BreathOfTheWild.Materials.Models.Materials;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MaterialService {
    String BASE_URL = "https://botw-compendium.herokuapp.com/api/v2/";

    @GET("category/materials")
    Call<Materials> getMaterials();

    @GET("entry/{id}")
    Call<MaterialByID> getMaterial(@Path("id") String id);
}
