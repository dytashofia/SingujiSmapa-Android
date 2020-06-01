package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score_remidial extends AppCompatActivity {
    TextView txt_nilai,txt_comment;
    Button kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_remidial);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_nilai = findViewById(R.id.txt_nilai);
        txt_comment = findViewById(R.id.txt_comment);
        kembali = findViewById(R.id.btn_kembali);

        //int nilai = getIntent().getExtras().getInt("nilai");
        //txt_nilai.setText(String.valueOf(nilai));

        //if(nilai >= 80) {
            //txt_comment.setText("Kamu lulus REMIDI, NILAI KAMU AKAN DIPERBAIKI");
        //}else if(nilai >= 60) {
            //txt_comment.setText("Kamu lulus, tingkat nilai lebih baik");
        //}else {
           // txt_comment.setText("Kamu harus belajar lagi");
        //}

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Score_remidial.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
