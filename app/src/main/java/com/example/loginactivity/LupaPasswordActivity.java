package com.example.loginactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LupaPasswordActivity extends AppCompatActivity {
    //ProgressDialog pDialog;
    private EditText email;
    private TextView tvKembaliLogin;
    private Context context;
    Button btnKirim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        email = findViewById(R.id.email);
        tvKembaliLogin = findViewById(R.id.tvKembaliLogin);
        tvKembaliLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToLogin();
            }
        });

        btnKirim = findViewById(R.id.btnKirim);
        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void backToLogin() {
        Intent i_kembaliLogin = new Intent(context, LoginActivity.class);
        startActivity(i_kembaliLogin);
        finish();
    }

    private void sendEmail() {

    }
}
