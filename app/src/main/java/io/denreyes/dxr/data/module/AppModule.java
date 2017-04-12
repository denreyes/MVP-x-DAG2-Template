package io.denreyes.dxr.data.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by DJ on 4/6/2017.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return mApplication;
    }
}
