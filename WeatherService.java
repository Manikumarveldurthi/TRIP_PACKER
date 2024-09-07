package com.example.trip_packer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WeatherService extends AppCompatActivity {

    private EditText cityEditText, countryEditText, areaEditText;
    private Button searchButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_service);

        cityEditText = findViewById(R.id.editTextCity);
        countryEditText = findViewById(R.id.editTextCountry);
        areaEditText = findViewById(R.id.editTextArea);
        searchButton = findViewById(R.id.buttonSearch);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = cityEditText.getText().toString();
                String country = countryEditText.getText().toString();
                String area = areaEditText.getText().toString();

                openGoogleWeather(city, country, area);
            }
        });
    }

    private void openGoogleWeather(String city, String country, String area) {

        String searchQuery = "https://www.google.com/search?q=weather+" + city + "+" + area + ",+" + country;


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(searchQuery));


        startActivity(intent);
    }
}
