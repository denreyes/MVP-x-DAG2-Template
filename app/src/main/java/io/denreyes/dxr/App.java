package io.denreyes.dxr;

import android.app.Application;

import io.denreyes.dxr.data.component.DaggerNetComponent;
import io.denreyes.dxr.data.component.NetComponent;
import io.denreyes.dxr.data.module.AppModule;
import io.denreyes.dxr.data.module.NetModule;

/**
 * Created by DJ on 4/10/2017.
 */

public class App extends Application{
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.whatdoestrumpthink.com/api/v1/"))
                .build();
    }

    public NetComponent getNetComponent(){
        return mNetComponent;
    }
}
