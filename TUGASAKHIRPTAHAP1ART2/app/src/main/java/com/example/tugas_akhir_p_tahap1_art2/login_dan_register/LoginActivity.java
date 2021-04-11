package com.example.tugas_akhir_p_tahap1_art2.login_dan_register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.MainActivity;
import com.example.tugas_akhir_p_tahap1_art2.R;
//import com.example.tugas_akhir_p_tahap1_art2.sharedprefmanager.SessionManager;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private TextView textViewLogin;
//    SessionManager sessionManager;
//    String url = "https://jaringanruqyahaswaja.000webhostapp.com/CRUD_VOLLEY/login.php";
    String url = "http://192.168.43.14/adminKu_CI/BackendRuqyahAndroid/login.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        sessionManager = new SessionManager(this);

        textViewLogin = findViewById(R.id.header_login);
        Typeface customFont = Typeface.createFromAsset(getAssets(), "font/ParadiskDemoMediumBold.ttf");
        textViewLogin.setTypeface(customFont);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
    }

    public void click_regitrasi(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistrasiActivity.class);
        startActivity(intent);
    }

    public void click_login(View view) {
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Tunggu ...");

        if (et_username.getText().toString().equals("")){
            Toast.makeText(this, "Masukkan Username", Toast.LENGTH_SHORT).show();
        }
        else if (et_password.getText().toString().equals("")){
            Toast.makeText(this, "Masukkan Password", Toast.LENGTH_SHORT).show();
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    if (response.equalsIgnoreCase("Login Berhasil")){
                        et_username.setText("");
                        et_password.setText("");
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("username", username);
                    params.put("password", password);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        }
    }
}
