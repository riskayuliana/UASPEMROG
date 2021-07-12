package com.anz.tokoapps.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anz.tokoapps.R;
import com.anz.tokoapps.model.Entry_barang;
import com.anz.tokoapps.rest.ApiInterface;


import java.util.List;

public class ListArrayAdapter extends RecyclerView.Adapter<ListArrayAdapter.HolderBarang> {
    private Context ctx;
    private List<Entry_barang> listBarang;

    public ListArrayAdapter(Context ctx, List<Entry_barang> listBarang) {
        this.ctx = ctx;
        this.listBarang = listBarang;
    }

    ApiInterface apiData;

    @NonNull
    @Override
    public HolderBarang onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        HolderBarang holder = new HolderBarang(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderBarang holder, int position) {
        Entry_barang dm = listBarang.get(position);

        holder.tvId.setText(String.valueOf(dm.getIdBarang()));
        holder.tvNama.setText("Nama Barang \t\t: "+dm.getNamaBarang());
        holder.tvBeli.setText("Harga Beli  \t\t\t\t\t: "+dm.getHargabeliBarang());
        holder.tvJual.setText("Harga Jual  \t\t\t\t\t: "+dm.getHargajualBarang());
        holder.tvJumlah.setText("Jumlah Barang \t: "+dm.getJumlah());
        holder.tvEntry.setText(dm.getEntryBy());
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public class HolderBarang extends RecyclerView.ViewHolder{
        TextView tvId, tvNama, tvBeli, tvJual, tvJumlah, tvEntry;

        public HolderBarang(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_idbrg);
            tvNama = itemView.findViewById(R.id.tv_namabrg);
            tvBeli = itemView.findViewById(R.id.tv_belibrg);
            tvJual = itemView.findViewById(R.id.tv_jualbrg);
            tvJumlah = itemView.findViewById(R.id.tv_jumlahbrg);
            tvEntry = itemView.findViewById(R.id.tv_entrybrg);
        }
    }
}