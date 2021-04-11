package com.example.tugas_akhir_p_tahap1_art2.halaman_utama;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelDashboard;
import com.example.tugas_akhir_p_tahap1_art2.recycler_adapter.RecyclerAdapterLayanan;
import com.example.tugas_akhir_p_tahap1_art2.recycler_adapter.RecyclerAdapterMenu;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends Fragment {
    private RecyclerView recyclerViewMenu;
    private RecyclerView recyclerViewLayanan;
    private List<ModelDashboard> modelDashboardListMenus = new ArrayList<>();
    private List<ModelDashboard> modelDashboardListLayanan = new ArrayList<>();
    private RecyclerAdapterMenu recyclerAdapterMenu;
    private RecyclerAdapterLayanan recyclerAdapterLayanan;
    private View paramView;

    public DashboardActivity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.activity_fragment_dashboard, container, false);
        addData();
        recyclerViewMenu = paramView.findViewById(R.id.recycler_view_menu);
        recyclerViewLayanan = paramView.findViewById(R.id.recycler_view_layanan);
        recyclerViewMenu.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerViewLayanan.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerAdapterMenu = new RecyclerAdapterMenu(getActivity(), modelDashboardListMenus, modelDashboardListMenus.size());
        recyclerAdapterLayanan = new RecyclerAdapterLayanan(getActivity(), modelDashboardListLayanan, modelDashboardListLayanan.size());
        recyclerViewMenu.setAdapter(recyclerAdapterMenu);
        recyclerViewLayanan.setAdapter(recyclerAdapterLayanan);

        return paramView;
    }

    private void addData() {
        modelDashboardListMenus.add(new ModelDashboard("Call Center", "", R.string.call_centre, R.drawable.call,
                0, R.drawable.call));
        modelDashboardListMenus.add(new ModelDashboard("SMS", "", R.string.sms, R.drawable.sms,
                0, R.drawable.sms));
        modelDashboardListMenus.add(new ModelDashboard("Sosmed", "", R.string.sosmed, R.drawable.sosmed,
                0, R.drawable.sosmed));
        modelDashboardListMenus.add(new ModelDashboard("Email", "", R.string.email, R.drawable.email,
                0, R.drawable.email));
        modelDashboardListLayanan.add(new ModelDashboard("", "Bekam", R.string.text_bekam, 0,
                R.drawable.bekam, R.drawable.bekam));
        modelDashboardListLayanan.add(new ModelDashboard("", "Ruqyah", R.string.text_ruqyah, 0,
                R.drawable.bukuagama, R.drawable.bukuagama));
        modelDashboardListLayanan.add(new ModelDashboard("", "Totok", R.string.text_totok, 0,
                R.drawable.totok, R.drawable.totok));
        modelDashboardListLayanan.add(new ModelDashboard("", "Gurah", R.string.text_totok, 0,
                R.drawable.gurah, R.drawable.gurah));
        modelDashboardListLayanan.add(new ModelDashboard("", "Daftar Peruqyah", R.string.text_totok, 0,
                R.drawable.register, R.drawable.register));
        modelDashboardListLayanan.add(new ModelDashboard("", "Lokasi", R.string.text_totok, 0,
                R.drawable.lokasi, R.drawable.lokasi));
        modelDashboardListLayanan.add(new ModelDashboard("", "History Order", R.string.text_totok, 0,
                R.drawable.history, R.drawable.history));
        modelDashboardListLayanan.add(new ModelDashboard("", "Al Quran",R.string.text_totok, 0,
                R.drawable.kitabagama, R.drawable.kitabagama));
    }
}
