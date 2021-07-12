package com.anz.tokoapps.ui.aboutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.anz.tokoapps.R;

public class AboutAppFragment extends Fragment {

    private AboutAppViewModel aboutAppViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutAppViewModel =
                new ViewModelProvider(this).get(AboutAppViewModel.class);
        View root = inflater.inflate(R.layout.fragment_aboutapp, container, false);
        final TextView textView = root.findViewById(R.id.text_aboutapp);
        aboutAppViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}