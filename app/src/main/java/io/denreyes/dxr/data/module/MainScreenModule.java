package io.denreyes.dxr.data.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.denreyes.dxr.mainscreen.MainScreenContract;
import io.denreyes.dxr.util.CustomScope;

/**
 * Created by DJ on 4/10/2017.
 */

@Module
public class MainScreenModule {
    MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View view){
        this.mView = view;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView(){
        return mView;
    }

}
