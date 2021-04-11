package com.example.ruqyahaswaja;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends Fragment {
    RecyclerView listViewPeruqyah;
    RecyclerPeruqyah recyclerAdapterPeruqyah;
    List<ModelPeruqyah> modelPeruqyahList = new ArrayList<>();
    ModelPeruqyah modelPeruqyah;
    private String url = "http://192.168.43.14/adminKu_CI/BackendRuqyahAndroid/tampilperuqyah.php";
    private View paramView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paramView = inflater.inflate(R.layout.activity_peruqyah, container, false);
        listViewPeruqyah = paramView.findViewById(R.id.list_peruqyah);
        listViewPeruqyah.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerAdapterPeruqyah = new RecyclerPeruqyah(getActivity(), modelPeruqyahList, modelPeruqyahList.size());
        listViewPeruqyah.setAdapter(recyclerAdapterPeruqyah);
        tampilData();

        return paramView;
    }

    private void tampilData() {
        StringRequest request = new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    modelPeruqyahList.clear();
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        String success = jsonObject.getString("success");
                        if (success.equals("1")){
                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                String id = object.getString("id");
                                String nama = object.getString("nama");
                                String alamat = object.getString("alamat");
                                String no_hp = object.getString("no_hp");
                                String photo = object.getString("photo");

                                modelPeruqyah = new ModelPeruqyah(id,nama,alamat,no_hp,photo);

                                modelPeruqyahList.add(modelPeruqyah);
                                recyclerAdapterPeruqyah.notifyDataSetChanged();
                            }
                        }
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}
