package com.thiman.android.reservationmanager10;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.graphics.drawable.AnimationUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Asus on 12/24/2017.
 */

public class SplashActivity extends AppCompatActivity {

    TextView reservation;
    TextView manager;
    ImageView res;
    RelativeLayout r1;
    RelativeLayout r2;
    Animation fadeIn;
    Animation fromBottom;
    Animation fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);

        manager = findViewById(R.id.second);
        fromBottom = AnimationUtils.loadAnimation(this,R.anim.imageanim);
        manager.setAnimation(fromBottom);

        reservation = findViewById(R.id.first);
        fromTop = AnimationUtils.loadAnimation(this,R.anim.imageanim);
        reservation.setAnimation(fromTop);

        res = findViewById(R.id.res);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.from_top);
        res.setAnimation(fadeIn);

        r1 = findViewById(R.id.r1);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.imageanim);
        r1.setAnimation(fadeIn);

        r2 = findViewById(R.id.r2);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.imageanim);
        r2.setAnimation(fadeIn);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        } ,5000);
    }


}