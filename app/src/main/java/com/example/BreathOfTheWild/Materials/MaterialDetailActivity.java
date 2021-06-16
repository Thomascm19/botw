package com.example.BreathOfTheWild.Materials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.BreathOfTheWild.Materials.MaterialApi.MaterialRetrofitClient;
import com.example.BreathOfTheWild.Materials.Models.Material;
import com.example.BreathOfTheWild.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialDetailActivity extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_detail);
        Bundle in = getIntent().getExtras();
        id = in.getString("id");
        getMaterialById(id);
    }

    private void getMaterialById(String id ){
        Call<Material> call = MaterialRetrofitClient.getInstance().getMaterialService().getMaterial(id);
        call.enqueue(new Callback<Material>() {
            @Override
            public void onResponse(Call<Material> call, Response<Material> response) {
                Material material = response.body();
                Toast.makeText(getApplicationContext(), material.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Material> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}