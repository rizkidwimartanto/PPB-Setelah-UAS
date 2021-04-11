package com.example.ruqyahaswaja;

import android.app.Activity;
import android.app.AlertDialog;
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

import java.util.HashMap;
import java.util.Map;

public class RegistrasiActivity extends AppCompatActivity {
    private EditText et_nama ,et_username ,et_password, et_rePassword;
    Button btn_registrasi;
    ModelAkun modelAkun;
    String url = "http://192.168.43.14/adminKu_CI/BackendRuqyahAndroid/registrasi.php";
    private TextView textViewRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        et_nama = findViewById(R.id.et_namalengkap);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_rePassword = findViewById(R.id.et_repassword);
        btn_registrasi = findViewById(R.id.btn_registrasi);
        textViewRegister = findViewById(R.id.header_registrasi);

//        Typeface customFont = Typeface.createFromAsset(getAssets(), "font/ParadiskDemoMediumBold.ttf");
//        textViewRegister.setTypeface(customFont);

        btn_registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrasi();
            }
        });
    }

    public void registrasi() {
        final String nama = et_nama.getText().toString().trim();
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        final String rePassword = et_rePassword.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu ...");

        if (et_nama.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrasiActivity.this);
            builder.setMessage("Nama masih kosong");
            builder.show();
        }
        else if (et_username.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrasiActivity.this);
            builder.setMessage("Username masih kosong");
            builder.show();
        }
        else if (et_password.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrasiActivity.this);
            builder.setMessage("Password masih kosong");
            builder.show();
        }
        else if (et_rePassword.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrasiActivity.this);
            builder.setMessage("Password ulang masih kosong");
            builder.show();
        }
        else if (password.equals(rePassword) == false){
            AlertDialog.Builder builder = new AlertDialog.Builder(RegistrasiActivity.this);
            builder.setMessage("Password tidak sama");
            builder.show();
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    et_nama.setText("");
                    et_username.setText("");
                    et_password.setText("");
                    et_rePassword.setText("");
                    Intent intent = new Intent(RegistrasiActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegistrasiActivity.this);
                    builder.setMessage("Registrasi Gagal");
                    builder.show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("nama_konsumen", nama);
                    params.put("username", username);
                    params.put("password", password);
                    params.put("password", rePassword);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        }
    }
}
