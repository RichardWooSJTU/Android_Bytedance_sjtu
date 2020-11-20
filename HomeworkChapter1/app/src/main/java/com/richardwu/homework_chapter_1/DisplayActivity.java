package com.richardwu.homework_chapter_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView textView = findViewById(R.id.text_view);
        textView.setText(getIntent().getStringExtra("extra"));
    }
}