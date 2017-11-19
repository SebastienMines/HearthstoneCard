package fr.alfun.smines.hearthstonecard.activity;

import android.app.Application;
import fr.alfun.smines.hearthstonecard.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by aordogh on 17/11/2017.
 */

public class CalligraphyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                .setDefaultFontPath("")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
