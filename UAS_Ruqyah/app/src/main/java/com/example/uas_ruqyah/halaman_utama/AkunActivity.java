package com.example.tugas_akhir_p_tahap1_art2.halaman_utama;

import android.app.ProgressDialog;
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
    private Button btn_update, btn_setImage;
    private View paramView;
    private TextView textViewNama;
    private ImageView img_akun;
    private Bitmap bitmap;
    private String urlupdate = "https://jaringanruqyahaswaja.000webhostapp.com/CRUD_VOLLEY/editprofil.php";
    private String urltampil = "https://jaringanruqyahaswaja.000webhostapp.com/CRUD_VOLLEY/tampil.php";

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
        img_akun = paramView.findViewById(R.id.gambar_akun);
        btn_setImage = paramView.findViewById(R.id.set_gambar);

        tampilData();

        btn_update.setOnClickListener(new View.OnClickListener() {
            final String nama = textViewNama.getText().toString();
            final String username = et_username.getText().toString();
            final String password = et_password.getText().toString();
            final String id = et_id.getText().toString();
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Tunggu ...");

                if (et_username.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Masukkan Username", Toast.LENGTH_SHORT).show();
                }
                else if (et_password.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Masukkan Password", Toast.LENGTH_SHORT).show();
                }
                else{
                    progressDialog.show();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, urlupdate,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    progressDialog.dismiss();
                                    et_username.setText("");
                                    et_password.setText("");
                                    Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressDialog.dismiss();
                                    Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                                }
                            })
                    {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("id", id);
                            params.put("nama", nama);
                            params.put("username", username);
                            params.put("password", password);
                            return params;
                        }
                    };

                    //adding our stringrequest to queue
                    Volley.newRequestQueue(getActivity()).add(stringRequest);
                }
            }
        });
        return paramView;
    }

    private void tampilData(){
        final String username = et_username.getText().toString();
        final String password = et_password.getText().toString();
        final String id = et_id.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urltampil,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        et_username.setText("");
                        et_password.setText("");
                        Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };

        //adding our stringrequest to queue
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }

    //        btn_setImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dexter.withActivity(getActivity()).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                        .withListener(new PermissionListener() {
//                            @Override
//                            public void onPermissionGranted(PermissionGrantedResponse response) {
//                                Intent intent = new Intent(Intent.ACTION_PICK);
//                                intent.setType("image/*");
//                                startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
//                            }
//
//                            @Override
//                            public void onPermissionDenied(PermissionDeniedResponse response) {
//
//                            }
//
//                            @Override
//                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
//                                token.continuePermissionRequest();
//                            }
//                        }).check();
//            }
//        });

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == 1 && requestCode == RESULT_OK && data != null){
//            Uri filePath = data.getData();
//            try {
//                InputStream inputStream = getActivity().getContentResolver().openInputStream(filePath);
//                bitmap = BitmapFactory.decodeStream(inputStream);
////                img_akun.setImageResource(getActivity().bitmap);
//            }catch (FileNotFoundException e){
//                e.printStackTrace();
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

}
