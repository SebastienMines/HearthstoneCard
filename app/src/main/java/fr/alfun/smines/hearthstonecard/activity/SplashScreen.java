package fr.alfun.smines.hearthstonecard.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import fr.alfun.smines.hearthstonecard.R;

/**
 * Created by aordogh on 17/11/2017.
 */

public class SplashScreen extends BaseActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, AccueilActivity.class);
                startActivity(i);
                finish();

            }
        }, SPLASH_TIME_OUT);

    }

}
