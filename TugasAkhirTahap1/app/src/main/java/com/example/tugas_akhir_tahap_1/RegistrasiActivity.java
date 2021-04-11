package com.example.tugas_akhir_tahap_1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrasiActivity extends AppCompatActivity {

    private TextView textViewRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewRegister = findViewById(R.id.header_registrasi);
        Typeface customFont = Typeface.createFromAsset(getAssets(), "font/ParadiskDemoMediumBold.ttf");
        textViewRegister.setTypeface(customFont);
    }
}
