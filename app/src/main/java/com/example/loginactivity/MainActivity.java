package com.example.loginactivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragment(new home());


        btm_view = findViewById(R.id.bottom_view);
        btm_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home){
                    getSupportActionBar().setTitle("Home");
                    getFragment(new home());
                }else if(item.getItemId() == R.id.jadwal) {
                    getSupportActionBar().setTitle("Jadwal");
                    getFragment(new jadwal());

                }else if (item.getItemId() == R.id.laporan){
                    getSupportActionBar().setTitle("Laporan");
                    getFragment(new Laporan());
                }
                else if (item.getItemId() == R.id.akun){
                    getSupportActionBar().setTitle("Akun Saya");
                    getFragment(new akun_saya());
                }
                return false;
            }
        });
    }

    private void getFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.isi,fragment);
        fragmentTransaction.commit();
    }
}
