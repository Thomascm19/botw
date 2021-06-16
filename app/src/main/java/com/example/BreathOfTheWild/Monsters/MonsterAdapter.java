package com.example.BreathOfTheWild.Monsters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.BreathOfTheWild.R;
import com.example.BreathOfTheWild.Monsters.Models.Monster;

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

        TextView monsterID = v.findViewById(R.id.monsterID);
        monsterID.setText(monster.getMonsterID());

        return v;
    }
}
