package com.example.BreathOfTheWild.Materials;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.BreathOfTheWild.Materials.Models.Material;
import com.example.BreathOfTheWild.R;

import java.util.List;

public class MaterialAdapter extends BaseAdapter {

    protected Activity activity;
    protected List<Material> data;

    public MaterialAdapter(Activity activity, List<Material> materialList){
        this.activity = activity;
        this.data = materialList;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
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
            v = inf.inflate(R.layout.material_item, null);
        }

        Material material = this.data.get(position);
        TextView nameMaterial = v.findViewById(R.id.materialName);
        nameMaterial.setText(material.getName());

        TextView materialId = v.findViewById(R.id.materialID);
        materialId.setText(material.getMaterialId());

        return v;
    }
}
