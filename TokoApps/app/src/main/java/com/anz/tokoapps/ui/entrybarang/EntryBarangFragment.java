package com.anz.tokoapps.ui.entrybarang;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anz.tokoapps.R;

import com.anz.tokoapps.response.ResponseBarang;
import com.anz.tokoapps.rest.ApiClient;
import com.anz.tokoapps.rest.ApiInterface;


import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntryBarangFragment extends Fragment {

    @BindView(R.id.edt_namabarang)
    EditText namaBarang;

    @BindView(R.id.edt_hargabeli)
    EditText hargaBeli;

    @BindView(R.id.edt_hargajual)
    EditText hargaJual;

    @BindView(R.id.edt_jumlah)
    EditText jumlahBarang;

    @BindView(R.id.edt_entryby)
    EditText entryBy;

    @BindView(R.id.btn_save)
    Button Save;

    @BindView(R.id.btn_proses)
    Button Proses;

    private String namabarang, hargabelibarang, hargajualbarang, jumlah, entryby;

    int hitjual = 0, hitbeli = 0, hitjumlah = 0, hasil;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_entrybarang, container, false);

        ButterKnife.bind(getActivity());

        namaBarang = root.findViewById(R.id.edt_namabarang);
        hargaBeli = root.findViewById(R.id.edt_hargabeli);
        hargaJual = root.findViewById(R.id.edt_hargajual);
        jumlahBarang = root.findViewById(R.id.edt_jumlah);
        entryBy = root.findViewById(R.id.edt_entryby);
        Save = root.findViewById(R.id.btn_save);
        Proses = root.findViewById(R.id.btn_proses);

        Proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitbeli = Integer.parseInt(hargaBeli.getText().toString());
                hitjumlah = Integer.parseInt(jumlahBarang.getText().toString());

                hitjual = hitbeli*hitjumlah;
                hasil = (hitjual*10/100)+hitjual;
                hargaJual.setText(Double.toString(hasil));
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namabarang = namaBarang.getText().toString();
                hargabelibarang = hargaBeli.getText().toString();
                hargajualbarang = hargaJual.getText().toString();
                jumlah = jumlahBarang.getText().toString();
                entryby = entryBy.getText().toString();

                if(namabarang.trim().equals("")){
                    namaBarang.setError("Nama barang harus diisi");
                }else if(hargabelibarang.trim().equals("")){
                    hargaBeli.setError("Harga barang harus diisi");
                }else if(hargajualbarang.trim().equals("")){
                    hargaJual.setError("Harga jual harus diisi");
                }else if(jumlah.trim().equals("")) {
                    jumlahBarang.setError("Jumlah harus diisi");
                }else if (entryby.trim().equals("")){
                    entryBy.setError("Entry by harus diisi");
                }else {
                    entry_barang();
                }
            }
        });
        return root;
    }

    private void entry_barang() {
        ApiInterface apiData = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBarang> entry_barang = apiData.entry_barang(namabarang, hargabelibarang, hargajualbarang, jumlah, entryby);

        entry_barang.enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                Toast.makeText(getContext(),"Data berhasil di input",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {
                Toast.makeText(getContext(),"Gagal" +t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}