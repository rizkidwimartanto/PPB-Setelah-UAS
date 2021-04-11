package com.example.ruqyahaswaja;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

public class AkunActivity extends Fragment {
    private EditText et_username ,et_password, et_rePassword;
    private Button setGambar, btnUpdate;
    private SharedPreferences sharedPreferences;
    String url = "http://192.168.43.14/adminKu_CI/BackendRuqyahAndroid/update_akun.php";
    private View paramView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.activitiy_akun, container, false);
        et_username = paramView.findViewById(R.id.edit_username);
        et_password = paramView.findViewById(R.id.edit_password);
        et_rePassword = paramView.findViewById(R.id.edit_passwordUlang);
        setGambar = paramView.findViewById(R.id.set_gambar);
        btnUpdate = paramView.findViewById(R.id.btn_update);

//        sharedPreferences = this.getActivity().getSharedPreferences(LoginActivity.myPref, Context.MODE_PRIVATE);

        setGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        return paramView;
    }

    public void update(){
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        final String passwordUlang = et_rePassword.getText().toString().trim();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Tunggu ...");

        if (username.isEmpty()){
            builder.setMessage("Username masih kosong");
            builder.show();
        }
        else if(password.isEmpty()){
            builder.setMessage("Password masih kosong");
            builder.show();
        }
        else if(passwordUlang.isEmpty()){
            builder.setMessage("Password ulang masih kosong");
            builder.show();
        }
        else{
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    et_username.setText("");
                    et_password.setText("");
                    et_rePassword.setText("");
                    Toast.makeText(getActivity(), response , Toast.LENGTH_LONG).show();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Update Error");
                    builder.show();
                }
            }
            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(params.put("username", username), username);
                    editor.putString(params.put("password", password), password);
                    editor.putString(params.put("password", passwordUlang), passwordUlang);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(request);
        }
    }
}
