package com.anz.tokoapps.ui.laporanbarang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anz.tokoapps.Adapter.ListArrayAdapter;
import com.anz.tokoapps.R;
import com.anz.tokoapps.model.Entry_barang;
import com.anz.tokoapps.response.ResponseBarang;
import com.anz.tokoapps.rest.ApiClient;
import com.anz.tokoapps.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanBarangFragment extends Fragment {
    private RecyclerView rvBarang;
    private RecyclerView.Adapter adBarang;
    private RecyclerView.LayoutManager lmBarang;
    private List<Entry_barang> listBarang = new ArrayList<>();

    private static final String TAG = LaporanBarangFragment.class.getSimpleName();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(getActivity());
        View root = inflater.inflate(R.layout.fragment_laporanbarang, container, false);

        rvBarang = root.findViewById(R.id.rv_barang);
        lmBarang = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvBarang.setLayoutManager(lmBarang);
        Barang();
        return root;
    }

    public void Barang(){
        ApiInterface apiData = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseBarang> tampilData = apiData.ardLihatBarang();

        tampilData.enqueue(new Callback<ResponseBarang>() {
            @Override
            public void onResponse(Call<ResponseBarang> call, Response<ResponseBarang> response) {
                String status = response.body().getStatus();
                String message = response.body().getMessage();
                Toast.makeText(getContext(), "Status : "+status+" | Message : "+message, Toast.LENGTH_SHORT).show();
                listBarang=response.body().getData();
                adBarang = new ListArrayAdapter(getActivity(), listBarang);
                rvBarang.setAdapter(adBarang);
                adBarang.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseBarang> call, Throwable t) {
                Toast.makeText(getContext(), "Gagal Menghubungi Server : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}