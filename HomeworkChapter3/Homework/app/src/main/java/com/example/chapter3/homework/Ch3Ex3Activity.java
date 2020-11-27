package com.example.chapter3.homework;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);
        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        // TODO: ex3-2, 添加 TabLayout 支持 Tab
        TabLayout tabLayout;
        ViewPager viewPager;
        FragmentPagerAdapter fragmentPagerAdapter;
        final ArrayList<Fragment> fragments = new ArrayList<>();
        final String[] titles = new String[]{"好友", "推荐", "你"};
        tabLayout = (TabLayout) findViewById(R.id.layout_tab);
        viewPager = findViewById(R.id.view_pager);

        for (int i = 0; i < titles.length; ++i) {
            fragments.add(new PlaceholderFragment());
            tabLayout.addTab(tabLayout.newTab());
        }
        tabLayout.setupWithViewPager(viewPager);
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
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
