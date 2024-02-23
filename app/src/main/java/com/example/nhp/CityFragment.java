package com.example.nhp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CityFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        Button xacnhan = view.findViewById(R.id.xacnhannoidi);
        EditText tinhdi = view.findViewById(R.id.edTinhdi);
        EditText tinhden = view.findViewById(R.id.edTinhden);
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valuetinhdi = tinhdi.getText().toString();
                String valuetinhden = tinhden.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Tinhdi", valuetinhdi);
                bundle.putString("Tinhden", valuetinhden);

                TimkiemFragment timkiemFragment   = new TimkiemFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, timkiemFragment);
                transaction.addToBackStack(null);
                timkiemFragment.setArguments(bundle);
                transaction.commit();
            }
        });
        return view;
    }
}

