package com.example.trip_packer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_packer.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class SendOtpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);

        final EditText inputMobile= findViewById(R.id.inputMobile);
        Button buttonGetOTP= findViewById(R.id.buttongetotp);

        final ProgressBar progressBar=findViewById(R.id.progressbar);

        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputMobile.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(SendOtpActivity.this, "", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                buttonGetOTP.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+inputMobile.getText().toString(),60, TimeUnit.SECONDS,
                        SendOtpActivity.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
                        {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(view.GONE);
                                buttonGetOTP.setVisibility(view.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                progressBar.setVisibility(view.GONE);
                                buttonGetOTP.setVisibility(view.VISIBLE);
                                Toast.makeText(SendOtpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                               progressBar.setVisibility(View.GONE);
                                buttonGetOTP.setVisibility(view.VISIBLE);
                                Intent intent=new Intent(getApplicationContext(),VerifyOtpActivity.class);
                                intent.putExtra("mobile",inputMobile.getText().toString());
                                intent.putExtra("verifiactionId",verificationId);
                                startActivity(intent);
                            }
                        }
                );

            }
        });


    }
}