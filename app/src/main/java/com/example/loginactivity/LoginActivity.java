package com.example.loginactivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Inisialisasi variable dengan view username dan view password dari activity_login.xml */
        pDialog = new ProgressDialog(context);
        vUsername = findViewById(R.id.username);
        vPassword = findViewById(R.id.password);
        tvlupa_password = findViewById(R.id.tvLupaPassword);
        btnLogin = findViewById(R.id.idButton);

        //menambahkna onClickListener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


    //membuat method loginnya
    private void login() {
        // berfungsi untuk mendapatkan nilai dari textview username dan password
        //trim berfungsi untuk memotong karakter spasi pada bagian awal dan akhir
        final String username = vUsername.getText().toString().trim();
        final String password = vPassword.getText().toString().trim();
        pDialog.setMessage("Login .........");
        showDialog();

        // Membuat String Request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Preference.Login_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // jika respon sukses dari server
                        if (response.contains(Preference.KEY_LOGIN_SUKSES)) {
                            hideDialog();
                            PindahHomeKelas();
                        } else {
                            //jika tidak maka
                            hideDialog();
                            Toast.makeText(context, "Username tidak valid", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hideDialog();
                        Toast.makeText(context, "Server tidak dapat dijangkau", Toast.LENGTH_LONG).show();
                    }
                }) {


            protected Map<String, String> getParamemeter() throws AuthFailureError {
                      Map<String, String> parameter = new HashMap<>();
                      parameter.put(Preference.KEY_USER_Login, username);
                      parameter.put(Preference.KEY_PASS_Login, password);
                      return parameter;
                    }
            };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void PindahHomeKelas() {
        Intent intent = new Intent(context, HomekelasActivity.class);
        startActivity(intent);
        finish();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}






