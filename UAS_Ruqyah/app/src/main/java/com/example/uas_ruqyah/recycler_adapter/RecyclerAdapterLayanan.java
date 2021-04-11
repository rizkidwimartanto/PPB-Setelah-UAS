package com.example.tugas_akhir_p_tahap1_art2.recycler_adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.HistoryOrderActivity;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelDashboard;
import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.PeruqyahActivity;
import com.example.tugas_akhir_p_tahap1_art2.R;

import java.util.List;

public class RecyclerAdapterLayanan extends RecyclerView.Adapter<RecyclerAdapterLayanan.MyAdapter> {

    Context context;
    List<ModelDashboard> modelDashboardList;
    int size;
    View view;

    public RecyclerAdapterLayanan(Context context, List<ModelDashboard> modelDashboardList, int size) {
        this.context = context;
        this.modelDashboardList = modelDashboardList;
        this.size = size;
    }

    @NonNull
    @Override
    public RecyclerAdapterLayanan.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan, parent, false);
        return new MyAdapter(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapterLayanan.MyAdapter holder, int position) {
        final ModelDashboard modelDashboard = modelDashboardList.get(position);
        holder.tvNamaLayanan.setText(modelDashboard.getNamaLayanan());
        holder.imageLayanan.setImageResource(modelDashboard.getGambarLayanan());
        if (modelDashboard.getNamaLayanan()=="Bekam" || modelDashboard.getNamaLayanan()=="Ruqyah" || modelDashboard.getNamaLayanan()=="Totok"
                || modelDashboard.getNamaLayanan()=="Gurah") {
            holder.cardLayanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                    View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.activity_deskripsi, null);
                    TextView tvDeskripsi;
                    ImageView imageDeskripsi;

                    tvDeskripsi = dialogView.findViewById(R.id.tv_deskripsi);
                    imageDeskripsi = dialogView.findViewById(R.id.gambar_deksripsi);
                    tvDeskripsi.setText(modelDashboard.getNamaDeskripsi());
                    imageDeskripsi.setImageResource(modelDashboard.getGambarDeskripsi());
                    builder.setView(dialogView);
                    builder.setCancelable(true);
                    builder.show();
                }
            });
        }

        if (modelDashboard.getNamaLayanan()=="Daftar Peruqyah"){
        holder.cardLayanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.activity_daftar, null);
                    Intent intent = new Intent(v.getContext(), PeruqyahActivity.class);
                    TextView tvHeaderLayanan;
                    ImageView imageLayanan;

                    tvHeaderLayanan = dialogView.findViewById(R.id.header_layanan);
                    imageLayanan = dialogView.findViewById(R.id.gambar_layanan);
                    tvHeaderLayanan.setText(modelDashboard.getNamaLayanan());
                    imageLayanan.setImageResource(modelDashboard.getGambarLayanan());
                    v.getContext().startActivity(intent);
            }

        });
        }

        if (modelDashboard.getNamaLayanan()=="History Order"){
            holder.cardLayanan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.activity_history_order, null);
                    Intent intent = new Intent(v.getContext(), HistoryOrderActivity.class);
                    v.getContext().startActivity(intent);
                }

            });
        }
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView tvNamaLayanan;
        ImageView imageLayanan;
        CardView cardLayanan;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            tvNamaLayanan = itemView.findViewById(R.id.tv_layanan);
            imageLayanan = itemView.findViewById(R.id.gambar_layanan);
            cardLayanan = itemView.findViewById(R.id.card_layanan);
        }
    }
}
