package com.example.tugas_akhir_tahap_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMenu;
    private RecyclerView recyclerViewLayanan;
    private ArrayList<Model> modelArrayListMenu;
    private ArrayList<Model> modelArrayListLayanan;
    private CardView cardViewMenu;
    private RecyclerAdapterMenu adapterMenu;
    private RecyclerAdapterLayanan adapterLayanan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerViewMenu = findViewById(R.id.recycler_view_menu);
        recyclerViewLayanan = findViewById(R.id.recycler_view_layanan);

        cardViewMenu = findViewById(R.id.card_menu);

        addData();

        adapterMenu = new RecyclerAdapterMenu(modelArrayListMenu,this);
        adapterLayanan = new RecyclerAdapterLayanan(modelArrayListLayanan,this);

        GridLayoutManager mLayoutManagerMenu = new GridLayoutManager(this, 4);
        GridLayoutManager mLayoutManagerLayanan = new GridLayoutManager(this, 4);
        recyclerViewMenu.setLayoutManager(mLayoutManagerMenu);
        recyclerViewLayanan.setLayoutManager(mLayoutManagerLayanan);
        recyclerViewMenu.setAdapter(adapterMenu);
        recyclerViewLayanan.setAdapter(adapterLayanan);
    }

    private void addData() {
        modelArrayListMenu = new ArrayList<>();
        modelArrayListLayanan = new ArrayList<>();

        modelArrayListMenu.add(new Model("Call Center", "", R.drawable.call, 0));
        modelArrayListMenu.add(new Model("SMS", "", R.drawable.sms, 0));
        modelArrayListMenu.add(new Model("Sosmed", "", R.drawable.sosmed, 0));
        modelArrayListMenu.add(new Model("Email", "", R.drawable.email, 0));

        modelArrayListLayanan.add(new Model("", "Bekam", 0, R.drawable.bekam));
        modelArrayListLayanan.add(new Model("", "Totok", 0, R.drawable.totok));
        modelArrayListLayanan.add(new Model("", "Ruqyah", 0, R.drawable.bukuagama));
        modelArrayListLayanan.add(new Model("", "Gurah", 0, R.drawable.gurah));
        modelArrayListLayanan.add(new Model("", "Daftar Peruqyah", 0, R.drawable.register));
        modelArrayListLayanan.add(new Model("", "Lokasi Peruqyah", 0, R.drawable.lokasi));
        modelArrayListLayanan.add(new Model("", "Histori Order", 0, R.drawable.history));
        modelArrayListLayanan.add(new Model("", "Kritik dan Saran", 0, R.drawable.saran));
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
        if (item.getItemId()==R.id.update_password){
            startActivity(new Intent(this, UpdatePasswordActivity.class));
        } else if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        return true;
    }
}
