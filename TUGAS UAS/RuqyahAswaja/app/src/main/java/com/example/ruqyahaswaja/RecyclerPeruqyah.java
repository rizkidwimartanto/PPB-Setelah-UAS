package com.example.ruqyahaswaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerPeruqyah extends RecyclerView.Adapter<RecyclerPeruqyah.MyAdapter> {
    Context context;
    List<ModelPeruqyah> modelPeruqyahList;
    int size;

    public RecyclerPeruqyah(Context context, List<ModelPeruqyah> modelPeruqyahList, int size) {
        this.context = context;
        this.modelPeruqyahList = modelPeruqyahList;
        this.size = size;
    }

    @NonNull
    @Override
    public RecyclerPeruqyah.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peruqyah, parent, false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerPeruqyah.MyAdapter holder, int position) {
        final ModelPeruqyah modelPeruqyah = modelPeruqyahList.get(position);
        holder.tvId.setText(modelPeruqyah.getId());
        holder.tvNama.setText(modelPeruqyah.getNama());
        holder.tvAlamat.setText(modelPeruqyah.getAlamat());
        holder.tvNoHp.setText(modelPeruqyah.getNo_hp());
        Glide.with(context).load(modelPeruqyah.getPhoto()).into(holder.gambarPeruqyah);
    }

    @Override
    public int getItemCount() {
        return modelPeruqyahList.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView tvId, tvNama, tvAlamat, tvNoHp;
        ImageView gambarPeruqyah;
        Button buttonPilih;
        CardView cardPeruqyah;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_idperuqyah);
            tvNama = itemView.findViewById(R.id.tv_namaperuqyah);
            tvAlamat = itemView.findViewById(R.id.tv_alamatperuqyah);
            tvNoHp = itemView.findViewById(R.id.tv_nohp_peruqyah);
            gambarPeruqyah = itemView.findViewById(R.id.gambar_peruqyah);
            buttonPilih = itemView.findViewById(R.id.btn_pilih);
            cardPeruqyah = itemView.findViewById(R.id.card_peruqyah);
        }
    }
}
