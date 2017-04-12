package io.denreyes.dxr.mainscreen;

import java.util.List;

import io.denreyes.dxr.util.Quotes;

/**
 * Created by DJ on 4/10/2017.
 */

public interface MainScreenContract {
    interface View {
        void showPosts(Quotes quotes);

        void showError(String msg);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
