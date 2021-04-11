package com.example.ruqyahaswaja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private EditText et_id;
    private Button btn_login;
    private TextView textViewLogin;
    public static final String url = "http://192.168.43.14/adminKu_CI/BackendRuqyahAndroid/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        textViewLogin = findViewById(R.id.header_login);
//        Typeface customFont = Typeface.createFromAsset(getAssets(), "font/ParadiskDemoMediumBold.ttf");
//        textViewLogin.setTypeface(customFont);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_id = findViewById(R.id.et_id);
        btn_login = findViewById(R.id.btn_login);

    }

    public void click_regitrasi(View view) {
        Intent intentRegistrasi = new Intent(LoginActivity.this, RegistrasiActivity.class);
        startActivity(intentRegistrasi);
    }

    public void click_login(View view) {
        final String id = et_id.getText().toString().trim();
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Tunggu ...");

        if (et_username.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("Username masih kosong");
            builder.show();
        }
        else if (et_password.getText().toString().equals("")){
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("Password masih kosong");
            builder.show();
        }
        else{
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Login Berhasil")){
                        progressDialog.show();
                        progressDialog.dismiss();
                        et_username.setText("");
                        et_password.setText("");
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("Username atau password salah");
                        builder.show();
                    }
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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