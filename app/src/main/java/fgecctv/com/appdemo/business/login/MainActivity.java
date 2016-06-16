package fgecctv.com.appdemo.business.login;

import android.support.v4.app.Fragment;

import fgecctv.com.appdemo.base.BaseContainerActivity;

public class MainActivity extends BaseContainerActivity {

    @Override
    protected Fragment createContentFragment() {
        return MainFragment.newInstance();
    }

}
