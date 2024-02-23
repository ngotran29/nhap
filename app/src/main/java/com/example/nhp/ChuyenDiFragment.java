package com.example.nhp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ChuyenDiFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ChuyenDiFragment chuyendi = new ChuyenDiFragment();
        return inflater.inflate(R.layout.fragment_chuyen_di, container, false);
    }
}