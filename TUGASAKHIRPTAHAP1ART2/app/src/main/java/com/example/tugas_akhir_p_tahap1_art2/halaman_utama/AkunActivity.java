package com.example.tugas_akhir_p_tahap1_art2.halaman_utama;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelAkun;
import com.example.tugas_akhir_p_tahap1_art2.recycler_adapter.AdapterAkun;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AkunActivity extends Fragment {
    private EditText et_id, et_username, et_password;
    private Button btn_update;
    private View paramView;
    private TextView textViewNama;
//    private String urlupdate = "https://jaringanruqyahaswaja.000webhostapp.com/CRUD_VOLLEY/editprofil.php";
    private String urlupdate = "http://192.168.43.14/uas_android/update_akun.php";
//    private String urltampil = "https://jaringanruqyahaswaja.000webhostapp.com/CRUD_VOLLEY/tampil.php";

    public AkunActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.activity_fragment_akun, container, false);
        et_username = paramView.findViewById(R.id.edit_username);
        et_password = paramView.findViewById(R.id.edit_password);
        et_id = paramView.findViewById(R.id.edit_id);
        textViewNama = paramView.findViewById(R.id.tv_nama);
        btn_update = paramView.findViewById(R.id.btn_update);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = et_username.getText().toString();
                final String password = et_password.getText().toString();
                final String id = et_id.getText().toString();

                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setMessage("Updating....");
                progressDialog.show();

                StringRequest request = new StringRequest(Request.Method.POST, urlupdate,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String> params = new HashMap<String,String>();

                        params.put("id",id);
                        params.put("name",username);
                        params.put("email",password);

                        return params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(request);


            }
        });

        return paramView;
    }
}
