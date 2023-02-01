package com.codewithabhi.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.codewithabhi.bottomnavigation.Fragments.Camera_Fragment;
import com.codewithabhi.bottomnavigation.Fragments.Home_Fragment;
import com.codewithabhi.bottomnavigation.Fragments.Profile_Fragment;
import com.codewithabhi.bottomnavigation.Fragments.Search_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navggation);




        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:
                        viewPager.setCurrentItem(0);

                        break;
                    case R.id.search:
                        viewPager.setCurrentItem(1);

                        break;
                    case R.id.camera:
                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.profile:
                        viewPager.setCurrentItem(3);

                        break;
                }
                ft.commit();
                return true;
            }
        });
    }
}