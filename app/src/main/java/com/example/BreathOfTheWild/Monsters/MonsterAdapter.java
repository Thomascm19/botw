package com.example.BreathOfTheWild.Monsters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.BreathOfTheWild.Materials.Models.Material;
import com.example.BreathOfTheWild.R;
import com.example.BreathOfTheWild.Monsters.Models.Monster;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MonsterAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Monster> monsters;

    public MonsterAdapter(Activity activity, List<Monster> monsterList){
        this.activity = activity;
        this.monsters = monsterList;
    }

    @Override
    public int getCount() {
        return monsters.size();
    }

    @Override
    public Object getItem(int position) {
        return monsters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.monster_item, null);
        }

        Monster monster = monsters.get(position);
        TextView nameMonster = v.findViewById(R.id.monsterName);
        nameMonster.setText(monster.getName());

        getImage(v, monster);

        return v;
    }

    private void getImage(View v, Monster monster) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            ImageView monsterImage = v.findViewById(R.id.mosnterImage);
            URL url = new URL(monster.getImage());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            monsterImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
