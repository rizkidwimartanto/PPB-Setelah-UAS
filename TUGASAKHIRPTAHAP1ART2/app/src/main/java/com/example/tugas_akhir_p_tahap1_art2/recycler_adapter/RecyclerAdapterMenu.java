package com.example.tugas_akhir_p_tahap1_art2.recycler_adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelDashboard;
import com.example.tugas_akhir_p_tahap1_art2.R;

import java.util.List;

public class RecyclerAdapterMenu extends RecyclerView.Adapter<RecyclerAdapterMenu.MyAdapter> {

    Context context;
    List<ModelDashboard> modelDashboardList;
    int size;

    public RecyclerAdapterMenu(Context context, List<ModelDashboard> modelDashboardList, int size) {
        this.context = context;
        this.modelDashboardList = modelDashboardList;
        this.size = size;
    }

    @NonNull
    @Override
    public RecyclerAdapterMenu.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MyAdapter(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterMenu.MyAdapter holder, int position) {
        final ModelDashboard modelDashboard = modelDashboardList.get(position);
        holder.tvNamaMenu.setText(modelDashboard.getNamaMenu());
        holder.imageMenu.setImageResource(modelDashboard.getGambarMenu());
        holder.cardMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                View dialogView = LayoutInflater.from(v.getRootView().getContext()).
                        inflate(R.layout.activity_deskripsi, null);
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

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView tvNamaMenu;
        ImageView imageMenu;
        CardView cardMenu;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            tvNamaMenu = itemView.findViewById(R.id.tv_menu);
            imageMenu = itemView.findViewById(R.id.gambar_menu);
            cardMenu = itemView.findViewById(R.id.card_menu);
        }
    }
}
