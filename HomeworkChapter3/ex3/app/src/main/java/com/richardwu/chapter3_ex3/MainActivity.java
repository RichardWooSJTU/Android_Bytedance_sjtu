package com.richardwu.chapter3_ex3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TabLayout tabLayout;
        ViewPager viewPager;
        FragmentPagerAdapter fragmentPagerAdapter;
        ArrayList<Fragment> fragments = new ArrayList<>();
        String[] titles = new String[]{"趋势", "推荐", "我的"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.layout_tab);
        viewPager = findViewById(R.id.view_pager);

        for (int i = 0; i < titles.length; ++i) {
            fragments.add(new TabFragment());
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return titles.length;
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        for (int i = 0; i < titles.length; ++i) {
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }
}