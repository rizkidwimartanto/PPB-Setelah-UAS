package com.example.tugas_akhir_p_tahap1_art2.recycler_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelAkun;

import java.util.List;

public class AdapterAkun extends ArrayAdapter<ModelAkun> {

    Context context;
    List<ModelAkun> modelAkun;


    public AdapterAkun(@NonNull Context context, List<ModelAkun> modelAkun) {
        super(context, R.layout.activity_fragment_akun,modelAkun);
        this.context = context;
        this.modelAkun = modelAkun;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fragment_akun,null,true);

        TextView tvID = view.findViewById(R.id.tv_id);
        TextView tvName = view.findViewById(R.id.tv_nama);

        tvID.setText(modelAkun.get(position).getId());
        tvName.setText(modelAkun.get(position).getNama());

        return view;
    }
}
