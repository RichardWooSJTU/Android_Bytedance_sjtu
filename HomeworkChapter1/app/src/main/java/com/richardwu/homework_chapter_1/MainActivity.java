package com.richardwu.homework_chapter_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.login_btn);
        EditText input = findViewById(R.id.input);
        final String[] loginName = {new String()};
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("main", "beforeTextChanged: 1");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("main", "onTextChanged: 2");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("main", "afterTextChanged: 3");
                loginName[0] = s.toString();

            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("extra", loginName[0]);
                startActivity(intent);
            }
        });
    }
}