package com.example.tugas_akhir_tahap_1;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterMenu extends RecyclerView.Adapter<RecyclerAdapterMenu.MyViewHolder> {
    private ArrayList<Model> modelList;
    private Context context;
    private Activity activity;

    public RecyclerAdapterMenu(ArrayList<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterMenu.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent,false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterMenu.MyViewHolder holder, int position) {
        final Model model = modelList.get(position);
        holder.namaMenu.setText(model.getNamaMenu());
        holder.imageViewMenu.setImageResource(model.getGambarMenu());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namaMenu;
        CardView cardViewMenu;
        ImageView imageViewMenu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMenu = itemView.findViewById(R.id.tv_menu);
            cardViewMenu = itemView.findViewById(R.id.card_menu);
            imageViewMenu = itemView.findViewById(R.id.gambar_menu);
        }
    }
}
