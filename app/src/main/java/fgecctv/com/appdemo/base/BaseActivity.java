package fgecctv.com.appdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.zhy.autolayout.AutoLayoutActivity;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.base
 * @Description: (使用hongyang的百分比布局, 需要继承AutoLayoutActivity)
 * @date 2016/5/10 22
 */
public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
    }

    /*根布局*/
    protected abstract int getContentViewId();

    /*布局中FrameLayout的Id*/
    protected abstract int getFragmentContentId();

    /*添加Fragment*/
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    /*移除栈顶Fragment*/
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            int count = getSupportFragmentManager().getBackStackEntryCount();
            if (count > 1) {
                removeFragment();
                return true;
            } else {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
