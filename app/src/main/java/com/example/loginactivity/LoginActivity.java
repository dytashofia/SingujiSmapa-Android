package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    //deklarasi view
    View vUsername;
    View vPassword;

    //deklarasi Textview
    TextView tvlupa_password;

    //deklarasi button
    Button btnLogin;

    //deklarasi SQLite
    SQLiteDatabase sqLiteDatabase;
    private Object dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        /* Inisialisasi variable dengan view username dan view password dari activity_login.xml */
        vUsername = findViewById(R.id.username);
        vPassword = findViewById(R.id.password);
        tvlupa_password = findViewById(R.id.tvLupaPassword);
        btnLogin = findViewById(R.id.idButton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(new LoginActivity.this, HomekelasActivity.class);
                startActivity(homeIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = vUsername.getText()
            }
        });


    }


}
