package com.example.trip_packer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import androidx.fragment.app.Fragment;

public class AppInfoFragment extends Fragment {

    public AppInfoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_app_info_fragment, container, false);
    }
}