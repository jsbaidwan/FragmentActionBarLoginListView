package com.example.jaspreetsingh.fragmentactionbarloginlistview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import com.example.jaspreetsingh.fragmentactionbarloginlistview.BarcodeScanner.ScanActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;
    TextView result;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);

        //getSupportActionBar().setCustomView(R.layout.abs_layout);

        Button barcodeButton = (Button) getView().findViewById(R.id.button_scan_barcode);

        barcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), ScanActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }

}
