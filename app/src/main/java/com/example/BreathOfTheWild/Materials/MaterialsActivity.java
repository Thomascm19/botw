package com.example.BreathOfTheWild.Materials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.BreathOfTheWild.Materials.MaterialApi.MaterialRetrofitClient;
import com.example.BreathOfTheWild.Materials.Models.Materials;
import com.example.BreathOfTheWild.Monsters.Models.Monsters;
import com.example.BreathOfTheWild.Monsters.MonsterAdapter;
import com.example.BreathOfTheWild.Monsters.MonsterApi.MonsterRetrofitClient;
import com.example.BreathOfTheWild.Monsters.MonstersActivity;
import com.example.BreathOfTheWild.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "Botw";
    Materials materials;
    ListView listMaterials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        listMaterials = findViewById(R.id.listMaterials);
        getInfo();
        listMaterials.setOnItemClickListener(this);
    }

    private void getInfo() {
        Call<Materials> materialsCall = MaterialRetrofitClient.getInstance().getMaterialService().getMaterials();
        materialsCall.enqueue(new Callback<Materials>() {
            @Override
            public void onResponse(Call<Materials> call, Response<Materials> response) {
                if (response.isSuccessful()){
                    materials = response.body();
                    MaterialAdapter adapter = new MaterialAdapter(MaterialsActivity.this, materials.getMaterial());
                    listMaterials.setAdapter(adapter);
                } else {
                    Log.e(TAG, "onResponse: " + response);
                }
            }

            @Override
            public void onFailure(Call<Materials> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent in = new Intent(this , MaterialDetailActivity.class);
        in.putExtra("id", materials.getMaterial().get(position).getMaterialId());
        startActivity(in);
    }
}