//package com.example.tugas_akhir_p_tahap1_art2.sharedprefmanager;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//
//import com.example.tugas_akhir_p_tahap1_art2.halaman_utama.MainActivity;
//import com.example.tugas_akhir_p_tahap1_art2.login_dan_register.LoginActivity;
//import com.example.tugas_akhir_p_tahap1_art2.model_ruqyah.ModelAkun;
//
//import java.util.HashMap;
//
//public class SessionManager {
//    SharedPreferences sharedPreferences;
//    public SharedPreferences.Editor editor;
//    public Context context;
//    int PRIVATE_MODE = 0;
//
//    public static final String SHARED_PREF_NAME = "LOGIN";
//    public static final String LOGIN = "IS LOGIN";
//    public static final String KEY_NAMA = "NAMA";
//    public static final String KEY_USERNAME = "USERNAME";
//    public static final String KEY_FOTO = "keyfoto";
//    public static final String KEY_ID = "keyid";
//
//    public SessionManager(Context context) {
//        this.context = context;
//        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, PRIVATE_MODE);
//        editor = sharedPreferences.edit();
//    }
//
//    public void createSession(String username){
//        editor.putBoolean(LOGIN, true);
//        editor.putString(KEY_USERNAME, username);
//        editor.apply();
//    }
//
//    public boolean isLoggin(){
//        return  sharedPreferences.getBoolean(LOGIN, false);
//    }
//
//    public void checkLogin(){
//        if (!this.isLoggin()){
//            Intent intent = new Intent(context, LoginActivity.class);
//            context.startActivity(intent);
//            ((MainActivity) context).finish();
//        }
//    }
//
//    public HashMap<String, String> getUserDetail(){
//        HashMap<String, String> user = new HashMap<>();
//        user.put(KEY_USERNAME, sharedPreferences.getString(KEY_USERNAME, null));
//
//        return user;
//    }
//
//    public void logout(){
//        editor.clear();
//        editor.commit();
//        Intent intent = new Intent(context, LoginActivity.class);
//        context.startActivity(intent);
//        ((MainActivity) context).finish();
//    }
//
//    //    private static SharedPrefManager mInstance;
////    private static Context mCtx;
////
////    private SharedPrefManager(Context context) {
////        mCtx = context;
////    }
////
////    public static synchronized SharedPrefManager getInstance(Context context) {
////        if (mInstance == null) {
////            mInstance = new SharedPrefManager(context);
////        }
////        return mInstance;
////    }
////
////    public void userLogin(ModelAkun user) {
////        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
////        SharedPreferences.Editor editor = sharedPreferences.edit();
////        editor.putInt(KEY_ID, user.getId());
////        editor.putString(KEY_NAMA, user.getNama());
////        editor.putString(KEY_USERNAME, user.getUsername());
////        editor.apply();
////    }
////
////    public boolean isLoggedIn() {
////        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
////        return sharedPreferences.getString(KEY_USERNAME, null) != null;
////    }
////
////    //this method will give the logged in user
////    public ModelAkun getUser() {
////        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
////        return new ModelAkun(
////                sharedPreferences.getInt(KEY_ID, -1),
////                sharedPreferences.getString(KEY_NAMA, null),
////                sharedPreferences.getString(KEY_USERNAME, null),
////                sharedPreferences.getString(KEY_FOTO, null)
////        );
////    }
////
////    //this method will logout the user
////    public void logout() {
////        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
////        SharedPreferences.Editor editor = sharedPreferences.edit();
////        editor.clear();
////        editor.apply();
////        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
////    }
//}
