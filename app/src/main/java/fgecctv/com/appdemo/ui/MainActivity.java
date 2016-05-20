package fgecctv.com.appdemo.ui;

import android.os.Bundle;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.BaseActivity;
import fgecctv.com.appdemo.base.BaseFragment;
import fgecctv.com.appdemo.ui.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentById(getFragmentContentId());
        if (null == fragment) {
            addFragment(MainFragment.newInstance());
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.frameLayout_main;
    }
}
