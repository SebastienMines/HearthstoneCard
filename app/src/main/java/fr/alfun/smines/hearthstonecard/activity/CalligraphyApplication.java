package fr.alfun.smines.hearthstonecard.activity;

import android.app.Application;
import android.content.Context;

import fr.alfun.smines.hearthstonecard.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by aordogh on 17/11/2017.
 */

public class CalligraphyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Belwe-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
