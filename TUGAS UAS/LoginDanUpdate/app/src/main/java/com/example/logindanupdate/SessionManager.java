package com.example.logindanupdate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAMAKONSUMEN = "nama_konsumen";
    public static final String USERNAME = "username";
    public static final String ID = "id";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String id, String nama_konsumen, String username){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAMAKONSUMEN, nama_konsumen);
        editor.putString(USERNAME, username);
        editor.putString(ID, id);
        editor.apply();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){

        if (!this.isLoggin()){
            Intent i = new Intent(context, MainActivity.class);
            context.startActivity(i);
            ((AkunActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){

        HashMap<String, String> user = new HashMap<>();
        user.put(ID, sharedPreferences.getString(ID, null));
        user.put(NAMAKONSUMEN, sharedPreferences.getString(NAMAKONSUMEN, null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));

        return user;
    }

    public void logout(){

        editor.clear();
        editor.commit();
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
        ((AkunActivity) context).finish();

    }
}
