package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;

public class GameHard extends AppCompatActivity {

    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 1;
    private GameHardView game;
    private Runnable my_runnable;
    private SensorManager sensorManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );
        game = new GameHardView(this);
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
        Intent intent = new Intent(GameHard.this,GameOver.class);
        startActivity(intent);
        finish();
    }
    public void stop() {
        handler.removeCallbacks(my_runnable);
    }
}