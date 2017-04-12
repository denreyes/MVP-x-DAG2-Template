package io.denreyes.dxr.data.component;

import dagger.Component;
import io.denreyes.dxr.data.module.MainScreenModule;
import io.denreyes.dxr.mainscreen.MainActivity;
import io.denreyes.dxr.util.CustomScope;

/**
 * Created by DJ on 4/10/2017.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
