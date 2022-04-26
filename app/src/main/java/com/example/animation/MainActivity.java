package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_bounce;
    Button btn_rotate;
    Button btn_zoom_in;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bounce = (ImageButton) findViewById(R.id.android1);

        btn_bounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);

                btn_bounce.startAnimation(animation1);
            }
        });


        btn_rotate = (Button) findViewById(R.id.android2);

        btn_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);

                btn_rotate.startAnimation(animation2);
            }
        });

        btn_zoom_in = (Button) findViewById(R.id.android3);

        btn_zoom_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoomin);
                btn_zoom_in.startAnimation(animation3);
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        btn_zoom_in.setText("Zoom out");
                        Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoomout);
                        btn_zoom_in.startAnimation(animation4);
                    }
                }, 2100);
                btn_zoom_in.setText("Zoom in");
            }
        });



    }
}