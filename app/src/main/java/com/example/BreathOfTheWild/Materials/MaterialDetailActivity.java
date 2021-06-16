package com.example.BreathOfTheWild.Materials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.BreathOfTheWild.Materials.MaterialApi.MaterialRetrofitClient;
import com.example.BreathOfTheWild.Materials.Models.Material;
import com.example.BreathOfTheWild.Materials.Models.MaterialByID;
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
        Call<MaterialByID> call = MaterialRetrofitClient.getInstance().getMaterialService().getMaterial(id);
        call.enqueue(new Callback<MaterialByID>() {
            @Override
            public void onResponse(Call<MaterialByID> call, Response<MaterialByID> response) {
                MaterialByID material = response.body();
                Toast.makeText(getApplicationContext(), material.getData().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MaterialByID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}