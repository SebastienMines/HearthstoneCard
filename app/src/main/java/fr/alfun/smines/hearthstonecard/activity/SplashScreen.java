package fr.alfun.smines.hearthstonecard.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import fr.alfun.smines.hearthstonecard.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by aordogh on 17/11/2017.
 */

public class SplashScreen extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

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
