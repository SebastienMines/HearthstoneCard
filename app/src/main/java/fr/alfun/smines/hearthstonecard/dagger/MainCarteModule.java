package fr.alfun.smines.hearthstonecard.dagger;

import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by s.mines on 19/11/2017.
 */
@Module
public class MainCarteModule {

    static final  String MAIN_THREAD = "mainThread";
    static final String BACKGROUND_THREAD = "backgroundThread";

    @Provides
    @Singleton
    @Named(BACKGROUND_THREAD)
    Executor providesBackgroundExecutor(){ return Executors.newSingleThreadExecutor(); }

    @Provides
    @Singleton
    @Named(MAIN_THREAD)
    Executor provideMainCarteExecutor(){
        return new HandlerExecutor(new android.os.Handler(Looper.getMainLooper()));
    }

    class HandlerExecutor implements Executor{
        private android.os.Handler handler;

        HandlerExecutor(android.os.Handler handler) {
            this.handler = handler;
        }

        @Override
        public void execute(@NonNull final Runnable runnable) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    runnable.run();
                }
            });
        }
    }
}
