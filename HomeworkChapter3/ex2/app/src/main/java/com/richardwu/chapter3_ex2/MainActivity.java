package com.richardwu.chapter3_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animator breathAnimator = AnimatorInflater.loadAnimator(this,R.animator.breath);
        breathAnimator.setTarget(findViewById(R.id.sjtu_logo));

        Animator alphaAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        alphaAnimator.setTarget(findViewById((R.id.sjtu_logo)));

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(alphaAnimator,breathAnimator);
        Button startButton = findViewById(R.id.btn_begin), stopButton = findViewById(R.id.btn_end);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.start();
            }
        });
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.pause();
            }
        });
    }
}