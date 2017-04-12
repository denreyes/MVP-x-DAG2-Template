package io.denreyes.dxr.mainscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.denreyes.dxr.App;
import io.denreyes.dxr.R;
import io.denreyes.dxr.data.component.DaggerMainScreenComponent;
import io.denreyes.dxr.data.module.MainScreenModule;
import io.denreyes.dxr.util.Quotes;

public class MainActivity extends AppCompatActivity implements MainScreenContract.View{
    private static final String TAG = "MainActivity";

    @Inject
    MainScreenPresenter mPresenter;

    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.my_list);
        list = new ArrayList<>();

        DaggerMainScreenComponent.builder()
                .netComponent(((App)getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);

        mPresenter.loadPost();
    }

    @Override
    public void showPosts(Quotes posts) {
        list.clear();
        list.addAll(posts.getMessages().getPersonalized());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Log.e(TAG, "Error" + message);

    }

    @Override
    public void showComplete() {
        Log.e(TAG, "Complete");

    }
}
