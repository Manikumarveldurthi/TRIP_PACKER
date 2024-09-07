package com.example.trip_packer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        if (!isNetworkAvailable()) {
            showNoInternetConnectionDialog();
        }


        GridLayout gridLayout = findViewById(R.id.gridLayout);
        CardView PackingitemsButtonCardView = findViewById(R.id.packingitemsButtonCardView);
        CardView aboutAppButtonCardView = findViewById(R.id.aboutAppButtonCardView);
        CardView SuggestPlacesButtonCardView = findViewById(R.id.suggestplacesCardView);
        CardView SuggestionsButtonCardView = findViewById(R.id.suggestionsCardView);


        PackingitemsButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openpackingActivity();
            }
        });
       aboutAppButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openaboutappActivity();
            }
        });
       SuggestPlacesButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                opensuggestplacesActivity();
            }
        });
        SuggestionsButtonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openSmartSuggestionsActivity();
            }
        });


    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
    private void showNoInternetConnectionDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.broadcast, null);


        TextView textViewMessage = dialogView.findViewById(R.id.textViewMessage);
        if (textViewMessage != null) {
            textViewMessage.setText("No Internet Connection");
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        final AlertDialog dialog = builder.create();
        dialog.show();
    }


    private void openpackingActivity() {

        Intent intent = new Intent(Dashboard.this, MainActivity.class);
        startActivity(intent);
    }

   private void openaboutappActivity () {

        Intent intent = new Intent(Dashboard.this, AboutUs.class);
        startActivity(intent);
    }

    private void opensuggestplacesActivity () {

        Intent intent = new Intent(Dashboard.this, Suggestplaces  .class);
        startActivity(intent);
    }

    private void openSmartSuggestionsActivity () {

        Intent intent = new Intent(Dashboard.this, packing .class);
        startActivity(intent);
    }


}




