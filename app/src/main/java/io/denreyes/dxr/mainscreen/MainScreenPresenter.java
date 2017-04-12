package io.denreyes.dxr.mainscreen;

import java.util.List;

import javax.inject.Inject;

import io.denreyes.dxr.util.Quotes;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DJ on 4/10/2017.
 */

public class MainScreenPresenter implements MainScreenContract.Presenter {
    Retrofit mRetrofit;
    MainScreenContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenContract.View mView){
        this.mRetrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPost() {
        mRetrofit.create(PostService.class).getQuotes().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<Quotes>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Quotes quotes) {
                        mView.showPosts(quotes);
                    }
                });
    }

    public interface PostService {

        @GET("quotes")
        Observable<Quotes> getQuotes();
    }

}
