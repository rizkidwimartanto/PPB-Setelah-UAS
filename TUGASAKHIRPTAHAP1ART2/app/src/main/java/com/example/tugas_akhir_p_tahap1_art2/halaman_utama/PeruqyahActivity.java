package com.example.tugas_akhir_p_tahap1_art2.halaman_utama;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.login_dan_register.LoginActivity;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelPeruqyah;
import com.example.tugas_akhir_p_tahap1_art2.recycler_adapter.RecyclerAdapterPeruqyah;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PeruqyahActivity extends AppCompatActivity {
    RecyclerView listViewPeruqyah;
    RecyclerAdapterPeruqyah recyclerAdapterPeruqyah;
    List<ModelPeruqyah> modelPeruqyahList = new ArrayList<>();
    ModelPeruqyah modelPeruqyah;
    private String url = "http://192.168.43.14/uas_android/tampilperuqyah.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peruqyah);
        listViewPeruqyah = findViewById(R.id.list_peruqyah);
        listViewPeruqyah.setLayoutManager(new GridLayoutManager(PeruqyahActivity.this, 2));
        recyclerAdapterPeruqyah = new RecyclerAdapterPeruqyah(PeruqyahActivity.this, modelPeruqyahList, modelPeruqyahList.size());
        listViewPeruqyah.setAdapter(recyclerAdapterPeruqyah);
        tampilData();
    }

    private void tampilData() {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        modelPeruqyahList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            String success = jsonObject.getString("success");
                            if (success.equals("1")){
                                for (int i = 0; i < jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String id = object.getString("id");
                                    String nama = object.getString("nama");
                                    String alamat = object.getString("alamat");
                                    String no_hp = object.getString("no_hp");
                                    String photo = object.getString("photo");

                                    modelPeruqyah = new ModelPeruqyah(id,nama,alamat,no_hp,photo);

                                    modelPeruqyahList.add(modelPeruqyah);
                                    recyclerAdapterPeruqyah.notifyDataSetChanged();
                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PeruqyahActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        return true;
    }
}
