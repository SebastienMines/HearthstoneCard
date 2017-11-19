package fr.alfun.smines.hearthstonecard.activity;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by aordogh on 19/11/2017.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context context){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
    }
}
