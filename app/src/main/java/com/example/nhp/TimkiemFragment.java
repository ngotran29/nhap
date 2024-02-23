package com.example.nhp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TimkiemFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timkiem, container, false);
        Button bttimkiem = view.findViewById(R.id.bttimkiem);
        bttimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChuyenDiFragment chuyendi = new ChuyenDiFragment();

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, chuyendi);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView noidi = view.findViewById(R.id.tvNoidi);
        noidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityFragment city = new CityFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, city);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView noiden = view.findViewById(R.id.tvNoiden);
        noiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CityFragment cityden = new CityFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, cityden);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        TextView ngaydi = view.findViewById(R.id.tvNgaydi);
        ngaydi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NgaydiFragment ngaydi = new NgaydiFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, ngaydi);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        Bundle bundle = getArguments();
        if(bundle !=null)
        {
            String tinhdi = bundle.getString("Tinhdi");
            String tinhden = bundle.getString("Tinhden");
            noidi.setText(tinhdi);
            noiden.setText(tinhden);
        }

        return view;

    }


}

