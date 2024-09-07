package com.example.trip_packer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    ImageView imgYoutube, imgInstagram, imgTelegram;
    TextView txtEmail,txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        startAboutUsService();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About Us");


        AppInfoFragment appInfoFragment = new AppInfoFragment();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.app_info_fragment_container, appInfoFragment);
        fragmentTransaction.commit();


        imgYoutube = findViewById(R.id.imgYoutube);
        imgInstagram = findViewById(R.id.imgInstagram);
        imgTelegram = findViewById(R.id.imgTelegram);
        txtEmail = findViewById(R.id.txtEmail);
        txtemail = findViewById(R.id.txtemail);

        imgYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle YouTube click
                openUrl("https://youtube.com/@manikumarveldurthi1116?si=W8ozeUls3bQfOm23");
            }
        });

        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle email click
                sendEmail("manikumar0459@gmail.com", "From trip packer");
            }
        });
        txtemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle email click
                sendEmail("yqcbgamer@gmail.com", "From trip packer");
            }
        });


        imgInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Instagram click
                openUrl("https://www.instagram.com/mr_manikumar143/");
            }
        });

        imgTelegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Telegram click
                openUrl("https://t.me/manikumar14");
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void startAboutUsService() {
        Intent intent = new Intent(this, AboutUsService.class);
        startService(intent);
    }



    private void openUrl(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    private void sendEmail(String email, String subject) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + email));
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
