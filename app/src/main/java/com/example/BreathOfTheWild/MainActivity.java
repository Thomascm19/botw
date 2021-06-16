package com.example.BreathOfTheWild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.BreathOfTheWild.Materials.MaterialsActivity;
import com.example.BreathOfTheWild.Monsters.MonstersActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_login_monsters;
    private Button button_login_materials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
    }

    public void setView() {
        button_login_monsters = findViewById(R.id.button_login_monsters);
        button_login_monsters.setOnClickListener(this);

        button_login_materials = findViewById(R.id.button_login_materials);
        button_login_materials.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_login_monsters) {
            Intent intent = new Intent(this, MonstersActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button_login_materials){
            Intent intent = new Intent(this, MaterialsActivity.class);
            startActivity(intent);
        }
    }
}