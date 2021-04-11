package com.example.tugas_akhir_p_tahap1_art2.recycler_adapter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.HistoryOrderActivity;
import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.OrderRuqyahActivity;
import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.PeruqyahActivity;
import com.example.tugas_akhir_p_tahap1_art2.login_dan_register.LoginActivity;
import com.example.tugas_akhir_p_tahap1_art2.login_dan_register.RegistrasiActivity;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelAkun;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelDashboard;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelPeruqyah;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerAdapterPeruqyah extends  RecyclerView.Adapter<RecyclerAdapterPeruqyah.MyAdapter> {

    Context context;
    List<ModelPeruqyah> modelPeruqyahList;
    int size;

    public RecyclerAdapterPeruqyah(Context context, List<ModelPeruqyah> modelPeruqyahList, int size) {
        this.context = context;
        this.modelPeruqyahList = modelPeruqyahList;
        this.size = size;
    }

    @NonNull
    @Override
    public RecyclerAdapterPeruqyah.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peruqyah, parent, false);
        return new MyAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapterPeruqyah.MyAdapter holder, int position) {
        final ModelPeruqyah modelPeruqyah = modelPeruqyahList.get(position);
//        holder.tvId.setText(modelPeruqyah.getId());
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

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peruqyah,null,true);
//
//        TextView tvIdPeruqyah = view.findViewById(R.id.tv_idperuqyah);
//        TextView tvNamaPeruqyah = view.findViewById(R.id.tv_namaperuqyah);
//        TextView tvAlamatPeruqyah = view.findViewById(R.id.tv_alamatperuqyah);
//        TextView tvHpPeruqyah = view.findViewById(R.id.tv_nohp_peruqyah);
//        ImageView gambarPeruqyah = view.findViewById(R.id.gambar_peruqyah);
//
//        tvIdPeruqyah.setText(modelPeruqyah.get(position).getId());
//        tvNamaPeruqyah.setText(modelPeruqyah.get(position).getNama());
//        tvAlamatPeruqyah.setText(modelPeruqyah.get(position).getAlamat());
//        tvHpPeruqyah.setText(modelPeruqyah.get(position).getNo_hp());
//        Glide.with(context).load(modelPeruqyah.get(position).getFoto()).into(gambarPeruqyah);
//
//        return view;
//    }
}

