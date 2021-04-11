package com.example.tugas_akhir_tahap_1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView textViewLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textViewLogin = findViewById(R.id.header_login);
        Typeface customFont = Typeface.createFromAsset(getAssets(), "font/ParadiskDemoMediumBold.ttf");
        textViewLogin.setTypeface(customFont);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
    }

    public void click_regitrasi(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistrasiActivity.class);
        startActivity(intent);
    }

    public void click_login(View view) {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}
