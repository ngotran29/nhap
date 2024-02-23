package com.example.nhp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.hbb20.CountryCodePicker;

public class TaikhoanFragment extends Fragment {
    private static final String ARG_USERNAME = "username";

    public TaikhoanFragment() {
        // Constructor public rỗng bắt buộc
    }

    public static TaikhoanFragment newInstance(String username) {
        TaikhoanFragment fragment = new TaikhoanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout cho fragment này
        View view = inflater.inflate(R.layout.fragment_taikhoan, container, false);
        // Tìm các view bằng ID
        TextView tv_tv = view.findViewById(R.id.tv_tv);
        ActivityResultLauncher<Intent> someActivityResultLauncherNgo = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == 296) {
                            // There are no request codes

                            Intent data = result.getData();
                            // do something
                            // Cập nhật giá trị cho tvlogin_tk
//                            assert data != null;

                            String username = null;
                            if (data != null) {
                                username = data.getDataString();
                                username = data.getParcelableExtra("key_username");
                                username = data.getStringExtra(Utils.KEY_USERNAME);
                            }
                            tv_tv.setText(username);
                        }
                    }
                });



        tv_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển đến LoginActivity khi tvlogin_tk được nhấp
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                someActivityResultLauncherNgo.launch(intent);
            }
        });


        return view;
    }
}