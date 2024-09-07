package com.example.trip_packer;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class ShareService extends IntentService {

    public ShareService() {
        super("ShareService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Toast.makeText(this, "Share Service Started", Toast.LENGTH_SHORT).show();
}
}