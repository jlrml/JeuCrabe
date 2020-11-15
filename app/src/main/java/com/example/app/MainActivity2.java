package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageView myButton = findViewById(R.id.facile);
        ImageView myButton2= findViewById(R.id.normale);
        ImageView myButton3= findViewById(R.id.difficile);


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changed();
            }
        });

        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changed2();
            }
        });

        myButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changed3();
            }
        });

    }


    public void changed(){
        Intent intent = new Intent(MainActivity2.this,Game.class);
        startActivity(intent);
        finish();
    }

    public void changed2(){
        Intent intent = new Intent(MainActivity2.this,GameMedium.class);
        startActivity(intent);
        finish();
    }


    public void changed3(){
        Intent intent = new Intent(MainActivity2.this,GameHard.class);
        startActivity(intent);
        finish();
    }

}