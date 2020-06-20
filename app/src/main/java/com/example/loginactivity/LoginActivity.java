package com.example.loginactivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    //deklarasi view
    private EditText vUsername, vPassword;
    //deklarasi context
    private Context context;
    //deklarasi Textview
    TextView tvlupa_password;
    //deklarasi button
    Button btnLogin;
    // membuat progressDialog
    //ProgressDialog pDialog;
    //menghubungkan url login
    ProgressBar bar;

    public static final String Login_URL = "http://192.168.43.209/FolderPHP/login_siswa.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Inisialisasi variable dengan view username dan view password dari activity_login.xml */
        //pDialog = new ProgressDialog(context);
        bar = findViewById(R.id.load);
        vUsername = findViewById(R.id.username);
        vPassword = findViewById(R.id.password);
        tvlupa_password = findViewById(R.id.tvLupaPassword);
        btnLogin = findViewById(R.id.idButton);

        //menambahkna onClickListener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // berfungsi untuk mendapatkan nilai dari textview username dan password
                //trim berfungsi untuk memotong karakter spasi pada bagian awal dan akhir
                String username = vUsername.getText().toString().trim();
                String password = vPassword.getText().toString().trim();

                if (!username.isEmpty() || !password.isEmpty())
                {
                    login(username, password);
                } else {
                    vUsername.setError("Please, insert your username");
                    vPassword.setError("Please, type your  password");
                }
            }
        });

        tvlupa_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToHomeKelas();

            }
        });
    }


    //membuat method loginnya
    private void login(final String parameterUsername, final String parameterPassword)
    {
        bar.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.GONE);
        /*pDialog.setMessage("Login Process.........");
        showDialog();*/

        // Membuat String Request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Login_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("Success");
                                JSONArray jsonArray = jsonObject.getJSONArray("login_siswa");

                                if (success.equals("1"))
                                {
                                    for (int i = 0; i < jsonArray.length(); i++)
                                    {
                                        JSONObject jObject = jsonArray.getJSONObject(i);

                                        String username = jObject.getString("username").trim();
                                        String password = jObject.getString("password").trim();

                                        Toast.makeText(LoginActivity.this,  "Login Success \n Your username" + username, Toast.LENGTH_LONG).show();

                                        startActivity(new Intent(LoginActivity.this, HomekelasActivity.class));

                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Login Error!!! \n" + e.toString(), Toast.LENGTH_SHORT).show();
                            bar.setVisibility(View.GONE);
                            btnLogin.setVisibility(View.VISIBLE);


                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "Login Error !!! \n" + error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {


            protected Map<String, String> getParams() throws AuthFailureError {
                      Map<String, String> params = new HashMap<>();
                      params.put("username", parameterUsername);
                      params.put("password", parameterPassword);
                      return params;
                    }
            };
        RequestQueue requestQueue =  Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);
    }

    /*private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show()
    }*/

    private void moveToHomeKelas() {
        startActivity(new Intent(LoginActivity.this, LupaPasswordActivity.class));
    }


}






