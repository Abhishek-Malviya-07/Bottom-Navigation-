package com.codewithabhi.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.codewithabhi.bottomnavigation.Fragments.Camera_Fragment;
import com.codewithabhi.bottomnavigation.Fragments.Home_Fragment;
import com.codewithabhi.bottomnavigation.Fragments.Profile_Fragment;
import com.codewithabhi.bottomnavigation.Fragments.Search_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navggation);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame , new Home_Fragment());
        ft.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "HOME ARRIVED", Toast.LENGTH_SHORT).show();
                        ft.replace(R.id.frame , new Home_Fragment());
                        break;
                    case R.id.search:
                        Toast.makeText(MainActivity.this, "SEARCH ARRIVED", Toast.LENGTH_SHORT).show();
                        ft.replace(R.id.frame , new Search_Fragment());
                        break;
                    case R.id.camera:
                        Toast.makeText(MainActivity.this, "CAMERA ARRIVED", Toast.LENGTH_SHORT).show();
                        ft.replace(R.id.frame , new Camera_Fragment());
                        break;
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "PROFILE ARRIVED", Toast.LENGTH_SHORT).show();
                        ft.replace(R.id.frame , new Profile_Fragment());
                        break;
                }
                ft.commit();
                return true;
            }
        });
    }
}