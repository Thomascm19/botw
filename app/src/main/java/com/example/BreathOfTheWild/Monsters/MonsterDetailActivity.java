package com.example.BreathOfTheWild.Monsters;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.BreathOfTheWild.Monsters.Models.MonsterByID;
import com.example.BreathOfTheWild.Monsters.MonsterApi.MonsterRetrofitClient;
import com.example.BreathOfTheWild.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonsterDetailActivity extends AppCompatActivity {

    private String id;
    private TextView monster_name_detail;
    private TextView monster_category_detail;
    private TextView monster_locations_detail;
    private TextView monster_description_detail;
    private TextView monster_drops_detail;
    private ImageView monster_name_image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_detail);
        Bundle in = getIntent().getExtras();
        setView();
        id = in.getString("id");
        getMonsterById(id);
    }

    public void setView() {
        monster_name_detail = findViewById(R.id.monsterNameDetail);
        monster_category_detail = findViewById(R.id.monsterCategoryDetail);
        monster_locations_detail = findViewById(R.id.monsterLocationsDetail);
        monster_description_detail = findViewById(R.id.monsterDescriptionDetail);
        monster_drops_detail = findViewById(R.id.monsterDropsDetail);
        monster_name_image_detail = findViewById(R.id.monsterNameImageDetail);
    }

    private void getMonsterById(String id ){
        Call<MonsterByID> call = MonsterRetrofitClient.getInstance().getMonsterService().getMonster(id);
        call.enqueue(new Callback<MonsterByID>() {
            @Override
            public void onResponse(Call<MonsterByID> call, Response<MonsterByID> response) {
                MonsterByID monster = response.body();
                monster_name_detail.setText(monster.getData().getName());
                monster_category_detail.setText(monster.getData().getCategory());
                monster_description_detail.setText(monster.getData().getDescription());
                getLocation(monster);
                getDrops(monster);
                getImage(monster);
            }

            @Override
            public void onFailure(Call<MonsterByID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDrops(MonsterByID monster) {
        if(monster.getData().getDrops() != null) {
            StringBuilder builderDrops = new StringBuilder();
            for (String drop : monster.getData().getDrops()) {
                builderDrops.append(drop);
                builderDrops.append(", ");
            }
            monster_drops_detail.setText(builderDrops);
        }
    }

    private void getLocation(MonsterByID monster) {
        if(monster.getData().getCommonLocations() != null) {
            StringBuilder builder = new StringBuilder();
            for (String location : monster.getData().getCommonLocations()) {
                builder.append(location);
                builder.append(", ");
            }
            monster_locations_detail.setText(builder);
        }
    }

    private void getImage(MonsterByID monster) {
        try {
            SetStrictMode();
            URL url = new URL(monster.getData().getImage());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            monster_name_image_detail.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SetStrictMode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}