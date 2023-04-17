package com.cntt2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment_1 extends Fragment {
    Button btnfr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Fragment 1", "onCreateView");
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        btnfr=(Button) getActivity().findViewById(R.id.btnfra1);
        btnfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Bạn vừa clik vào fragment 1",Toast.LENGTH_LONG).show();
            }
        });
    }
}