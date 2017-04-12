package io.denreyes.dxr.data.component;

import javax.inject.Singleton;

import dagger.Component;
import io.denreyes.dxr.data.module.AppModule;
import io.denreyes.dxr.data.module.NetModule;
import retrofit2.Retrofit;

/**
 * Created by DJ on 4/10/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
