package com.generlas.homework6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class ListActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        TabLayout tabLayout1 = findViewById(R.id.tabLayout1);
        TabLayout tabLayout2 = findViewById(R.id.tabLayout2);
        ViewPager2 vp2 = findViewById(R.id.tab_viewpager2);
        ViewPager2 vp2_2 = findViewById(R.id.tab_viewpager2_2);
        ArrayList<FragmentInterface> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FirstFragment();
            }
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new SecondFragment();
            }
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new ThirdFragment();
            }
        });
        VPAdapter adapter = new VPAdapter(this, fragmentList);
        vp2.setAdapter(adapter);
        VPAdapter adapter2 = new VPAdapter(this, fragmentList);
        vp2_2.setAdapter(adapter2);
        new TabLayoutMediator(tabLayout1, vp2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0) {
                    tab.setText("页面一");
                } else if (position == 1) {
                    tab.setText("页面二");
                } else {
                    tab.setText("页面三");
                }
            }
        }).attach();
        new TabLayoutMediator(tabLayout2, vp2_2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0) {
                    tab.setText("页面一");
                } else if (position == 1) {
                    tab.setText("页面二");
                } else {
                    tab.setText("页面三");
                }
            }
        }).attach();
    }
}