package fgecctv.com.appdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.fragment.MainFragment;
import fgecctv.com.appdemo.ui.mvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frameLayout_main);
        if (fragment == null) {
            fragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_main,fragment).commit();
        }

        mPresenter = new MainPresenter(DataManager.getInstance(getApplicationContext()),fragment);

    }
}
