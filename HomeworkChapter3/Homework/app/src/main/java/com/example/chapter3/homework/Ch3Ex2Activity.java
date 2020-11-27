package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Ch3Ex2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex2);

        Animator breathAnimator = AnimatorInflater.loadAnimator(this,R.animator.breath);
        breathAnimator.setTarget(findViewById(R.id.sjtu_logo));

        Animator alphaAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        alphaAnimator.setTarget(findViewById((R.id.sjtu_logo)));

        final AnimatorSet animatorSet = new AnimatorSet();
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
