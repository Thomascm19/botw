package com.example.BreathOfTheWild.Materials;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.BreathOfTheWild.Materials.MaterialApi.MaterialRetrofitClient;
import com.example.BreathOfTheWild.Materials.Models.MaterialByID;
import com.example.BreathOfTheWild.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MaterialDetailActivity extends AppCompatActivity {

    private String id;
    private TextView material_name_detail;
    private TextView material_category_detail;
    private TextView material_cooking_detail;
    private TextView material_description_detail;
    private TextView material_hearts_detail;
    private ImageView material_name_image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_detail);
        Bundle in = getIntent().getExtras();
        setView();
        id = in.getString("id");
        getMaterialById(id);
    }

    public void setView() {
        material_name_detail = findViewById(R.id.monsterNameDetail);
        material_category_detail = findViewById(R.id.monsterCategoryDetail);
        material_cooking_detail = findViewById(R.id.monsterLocationsDetail);
        material_description_detail = findViewById(R.id.monsterDescriptionDetail);
        material_hearts_detail = findViewById(R.id.monsterDropsDetail);
        material_name_image_detail = findViewById(R.id.monsterNameImageDetail);
    }

    private void getMaterialById(String id) {
        Call<MaterialByID> call = MaterialRetrofitClient.getInstance().getMaterialService().getMaterial(id);
        call.enqueue(new Callback<MaterialByID>() {
            @Override
            public void onResponse(Call<MaterialByID> call, Response<MaterialByID> response) {
                MaterialByID material = response.body();
                material_name_detail.setText(material.getData().getName());
                material_category_detail.setText(material.getData().getCategory());
                material_cooking_detail.setText(material.getData().getCooking_effect());
                material_description_detail.setText(material.getData().getDescription());
                material_hearts_detail.setText(material.getData().getHearts_recovered());
                getImage(material);
            }

            @Override
            public void onFailure(Call<MaterialByID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getImage(MaterialByID material) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL url = new URL(material.getData().getImage());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            material_name_image_detail.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}