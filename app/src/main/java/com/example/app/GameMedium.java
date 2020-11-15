package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class GameMedium extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 1;
    private GameViewMedium game;
    private Runnable my_runnable;
    private SensorManager sensorManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );
        game = new GameViewMedium(this);
        setContentView(game);





    }

    public void start() {
        handler.postDelayed(my_runnable, 1);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);



    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(
                game,
                sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER ),
                sensorManager.SENSOR_DELAY_GAME );
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener( game);
    }

    public void changed(){
        Intent intent = new Intent(GameMedium.this,GameOver.class);
        startActivity(intent);
        finish();
    }
    public void stop() {
        handler.removeCallbacks(my_runnable);
    }

}