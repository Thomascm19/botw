package com.example.BreathOfTheWild.Monsters;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.BreathOfTheWild.R;
import com.example.BreathOfTheWild.Monsters.MonsterApi.MonsterRetrofitClient;
import com.example.BreathOfTheWild.Monsters.Models.Monsters;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MonstersActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Botw";
    Monsters monsters;
    ListView listMonsters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monsters);
        listMonsters = findViewById(R.id.listMonsters);
        getInfo();
    }

    private void getInfo() {
            Call<Monsters> monstersCall = MonsterRetrofitClient.getInstance().getMonsterService().getMonsters();
            monstersCall.enqueue(new Callback<Monsters>() {
                @Override
                public void onResponse(Call<Monsters> call, Response<Monsters> response) {
                    if (response.isSuccessful()){
                        monsters = response.body();
                        MonsterAdapter adapter = new MonsterAdapter(MonstersActivity.this, monsters.getMonsters());
                        listMonsters.setAdapter(adapter);
                    } else {
                        Log.e(TAG, "onResponse: " + response);
                    }
                }

                @Override
                public void onFailure(Call<Monsters> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getMessage());
                }
            });
    }


    @Override
    public void onClick(View v) {

    }
}