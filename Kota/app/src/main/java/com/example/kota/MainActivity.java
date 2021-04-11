package com.example.barang.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.barang.InsertData;
import com.example.barang.R;
import com.example.barang.model.ModelData;
import java.util.List;

public class AdapterData extends
        RecyclerView.Adapter<AdapterData.HolderData> {
    private List<ModelData> mItems ;
    private Context context;
    public AdapterData (Context context, List<ModelData> items)
    {
        this.mItems = items;
        this.context = context;
    }
    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View layout =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row
                        ,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }
    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelData md = mItems.get(position);
        holder.tvnmbrg.setText(md.getNmbrg());
        holder.tvkdbrg.setText(md.getKdbrg());
        holder.tvhrgbeli.setText(md.getHrgbeli());
        holder.tvhrgjual.setText(md.getHrgjual());
        holder.tvstok.setText(md.getStok());
        holder.md = md;
    }
    @Override
    public int getItemCount() {
        return mItems.size();
    }
    class HolderData extends RecyclerView.ViewHolder {
        TextView tvnmbrg, tvkdbrg, tvhrgbeli, tvhrgjual, tvstok;
        ModelData md;
        public HolderData(View view) {
            super(view);
            tvnmbrg = (TextView) view.findViewById(R.id.nmbrg);
            tvkdbrg = (TextView) view.findViewById(R.id.kdbrg);
            tvhrgbeli = (TextView) view.findViewById(R.id.hrgbeli);
            tvhrgjual = (TextView) view.findViewById(R.id.hrgjual);
            tvstok = (TextView) view.findViewById(R.id.stok);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context,
                            InsertData.class);
                    update.putExtra("update", 1);
                    update.putExtra("kdbrg", md.getKdbrg());
                    update.putExtra("nmbrg", md.getNmbrg());
                    update.putExtra("hrgbeli", md.getHrgbeli());
                    update.putExtra("hrgjua", md.getHrgjual());
                    update.putExtra("stok", md.getStok());
                    context.startActivity(update);
                }
            });
        }
    }
}