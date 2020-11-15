package com.richardwu.exercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchLayout searchLayout = findViewById(R.id.search_layout);
        EditText searchValue = findViewById(R.id.search_value);
        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchValue.setText("");
            }
        });
        Log.d("Main", "finish layout init");
        //对RecyclerView进行一系列配置
        initItems();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);//初始化一个布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);//设置布局管理器
        Log.d("Main", "finish layout manager");
        ItemViewAdapter itemViewAdapter = new ItemViewAdapter(items);//初始化一个适配器
        recyclerView.setAdapter(itemViewAdapter);//设置适配器
        Log.d("Main", "finish View Adaptor ");
    }

    private void initItems() {
        for (int i = 0; i  < 10000; ++i) {
            items.add("这是第"+String.valueOf(i)+"本书");
        }
    }
}