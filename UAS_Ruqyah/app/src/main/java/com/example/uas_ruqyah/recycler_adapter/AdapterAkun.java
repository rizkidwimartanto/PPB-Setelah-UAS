package com.example.tugas_akhir_p_tahap1_art2.recycler_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelAkun;

import java.util.List;

public class AdapterAkun extends RecyclerView.Adapter<AdapterAkun.MyAdapter> {

    Context context;
    List<ModelAkun> modelAkunList;
    int size;

    public AdapterAkun(Context context, List<ModelAkun> modelAkunList, int size) {
        this.context = context;
        this.modelAkunList = modelAkunList;
        this.size = size;
    }

    public AdapterAkun(FragmentActivity akunActivity, List<ModelAkun> modelAkunList) {

    }

    @NonNull
    @Override
    public AdapterAkun.MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fragment_akun, parent, false);
        return new MyAdapter(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterAkun.MyAdapter holder, int position) {
        final ModelAkun modelAkun = modelAkunList.get(position);
        holder.tvId.setText(modelAkun.getId());
        holder.tvNamaLengkap.setText(modelAkun.getNama());
        holder.tvUsername.setText(modelAkun.getUsername());
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        TextView tvNamaLengkap, tvUsername, tvPassword, tvId;
        ImageView imageAkun;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            tvNamaLengkap = itemView.findViewById(R.id.tv_nama);
            tvUsername = itemView.findViewById(R.id.username);
            tvPassword = itemView.findViewById(R.id.password);
            tvId = itemView.findViewById(R.id.tv_id);
            imageAkun = itemView.findViewById(R.id.gambar_akun);
        }
    }
}
