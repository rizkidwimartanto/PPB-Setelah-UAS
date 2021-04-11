package com.example.tugas_akhir_p_tahap1_art2.halaman_utama;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.login_dan_register.LoginActivity;

public class PeruqyahActivity extends AppCompatActivity {
    private String url = "https://jaringanruqyahaswaja.000webhostapp.com/CRUD_VOLLEY/tambah.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peruqyah);
    }

    public void click_pilih1(View view) {
        startActivity(new Intent(this, OrderRuqyahActivity.class));
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Tunggu ...");
//
//        progressDialog.show();
//        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                progressDialog.dismiss();
//                Toast.makeText(PeruqyahActivity.this,response, Toast.LENGTH_LONG).show();
//                startActivity(new Intent(PeruqyahActivity.this, OrderRuqyahActivity.class));
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                progressDialog.dismiss();
//                Toast.makeText(PeruqyahActivity.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
//            }
//        }
//        ){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("nama", nama);
//                params.put("username", username);
//                params.put("password", password);
//                params.put("password", rePassword);
//                params.put("foto", "");
//                params.put("total_biaya","");
//                return params;
//            }
//        };
//        RequestQueue requestQueue = Volley.newRequestQueue(PeruqyahActivity.this);
//        requestQueue.add(request);

    }

    public void click_pilih2(View view) {
        startActivity(new Intent(this, OrderRuqyahActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
        return true;
    }
}
