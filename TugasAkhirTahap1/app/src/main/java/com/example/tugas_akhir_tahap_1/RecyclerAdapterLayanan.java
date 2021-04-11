package com.example.tugas_akhir_tahap_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapterLayanan extends RecyclerView.Adapter<RecyclerAdapterLayanan.MyViewHolder> {
    private ArrayList<Model> modelList;
    private Context context;

    public RecyclerAdapterLayanan(ArrayList<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterLayanan.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layanan, parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterLayanan.MyViewHolder holder, int position) {
        final Model model = modelList.get(position);
        holder.tv_namaLayanan.setText(model.getNamaLayanan());
        holder.tv_imageViewLayanan.setImageResource(model.getGambarLayanan());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_namaLayanan;
        CardView tv_cardViewLayanan;
        ImageView tv_imageViewLayanan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_namaLayanan = itemView.findViewById(R.id.tv_layanan);
            tv_cardViewLayanan = itemView.findViewById(R.id.card_layanan);
            tv_imageViewLayanan = itemView.findViewById(R.id.gambar_layanan);
        }
    }
}

