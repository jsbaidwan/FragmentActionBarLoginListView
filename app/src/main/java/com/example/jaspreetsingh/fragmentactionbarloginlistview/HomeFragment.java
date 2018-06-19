package com.example.jaspreetsingh.fragmentactionbarloginlistview;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import com.example.jaspreetsingh.fragmentactionbarloginlistview.BarcodeScanner.ScanActivity;
import com.google.android.gms.vision.barcode.Barcode;

import static android.app.Activity.RESULT_OK;


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

        Button barcodeButton = (Button) getActivity().findViewById(R.id.button_scan_barcode);

        result = (TextView) rootView.findViewById(R.id.result);

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }


        barcodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // To start scan barcode activity
                Intent intent = new Intent(getActivity(), ScanActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data != null){
                final Barcode barcode = data.getParcelableExtra("barcode");
                result.post(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(barcode.displayValue);
                    }
                });

            }
        }
    }
}
