package com.example.tugas_akhir_p_tahap1_art2.halaman_utama;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas_akhir_p_tahap1_art2.R;

public class lokasiactivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi);

        webView.findViewById(R.id.webLokasi);
        webView.loadUrl("https://maps.app.goo.gl/qZwydLwKzy7TrJHV8");
    }
}
