package com.example.BreathOfTheWild.Monsters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.BreathOfTheWild.Materials.MaterialApi.MaterialRetrofitClient;
import com.example.BreathOfTheWild.Materials.Models.MaterialByID;
import com.example.BreathOfTheWild.Monsters.Models.MonsterByID;
import com.example.BreathOfTheWild.Monsters.MonsterApi.MonsterRetrofitClient;
import com.example.BreathOfTheWild.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonsterDetailActivity extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_detail);
        Bundle in = getIntent().getExtras();
        id = in.getString("id");
        getMonsterById(id);
    }

    private void getMonsterById(String id ){
        Call<MonsterByID> call = MonsterRetrofitClient.getInstance().getMonsterService().getMonster(id);
        call.enqueue(new Callback<MonsterByID>() {
            @Override
            public void onResponse(Call<MonsterByID> call, Response<MonsterByID> response) {
                MonsterByID monster = response.body();
                Toast.makeText(getApplicationContext(), monster.getData().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MonsterByID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}