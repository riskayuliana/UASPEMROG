package com.anz.tokoapps.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.anz.tokoapps.activity.MainActivity;

import javax.annotation.Nullable;

public class Exit extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().finish();
    }
}
