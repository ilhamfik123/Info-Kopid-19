package com.ilhamfikri.info_kopid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menyambungkan ke Layout
        setContentView(R.layout.activity_splash);

        // Instansiasi Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            // Membuat intent jika sudah 2 detik berlalu
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}
