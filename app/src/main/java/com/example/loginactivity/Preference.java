package com.example.loginactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preference {
    //Pendlekarasian untuk menghubungkan dengan URL file login_siswa.php
    //Alamat url disesuaikan dengan ip yang diterima
    public static final String Login_URL = "https://192.168.43.209/Folder%20PHP/login_siswa.php";

    /*
     ** Pendeklarasian key-data berupa String, sebagai wadah penyimpan data,
     ** Jadi tiap data mempunyai key yang berbeda satu sama lain
     */

    //key untuk email dan password yang didefinisikan di POST login_siswa.php
    public static final String KEY_USER_Login = "username";
    public static final String KEY_PASS_Login = "password";
    public static final String KEY_LOGIN_SUKSES = "success";

    /** Pendlekarasian Shared Preferences yang berdasarkan parameter context**/
    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static void setLogin_User (Context context, String username) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_USER_Login, username);
        editor.apply();
    }
    public static String getLogin_User(Context context) {
        return getSharedPreferences(context).getString(KEY_USER_Login, "");
    }


    public static void setLogin_Pass (Context context, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(KEY_PASS_Login, password);
        editor.apply();
    }
    public static String getLogin_Pass(Context context) {
        return  getSharedPreferences(context).getString(KEY_PASS_Login, "");
    }


    public static boolean setLoginSukses(Context context, boolean status) {
       return getSharedPreferences(context).getBoolean(KEY_LOGIN_SUKSES, false);
    }
    public static boolean getLoginSukses(Context context) {
        return getSharedPreferences(context).getBoolean(KEY_LOGIN_SUKSES, false);
    }

}
