package fgecctv.com.appdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.List;

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

    /**
     * @return
     * @desc 根布局
     */
    protected abstract int getContentViewId();

    /**
     * @return
     * @desc 布局中FrameLayout的Id
     */
    protected abstract int getFragmentContentId();

    /**
     * @param fragment
     * @desc 布局中FrameLayout的Id
     */
    public void addFragment(BaseFragment fragment) {
        start(getTopFragment(),fragment);
    }

    /**
     * @desc:移除栈顶Fragment
     */
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

    /**
     * @param fromFragment 栈顶的fragment
     * @param toFragment   需要加入的fragment
     */
    private void start(BaseFragment fromFragment, BaseFragment toFragment) {
        String toName = toFragment.getClass().getSimpleName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(getFragmentContentId(), toFragment, toName);
        if (fromFragment != null) {
            ft.hide(fromFragment);
        }
        ft.addToBackStack(toName);
        ft.commit();
    }

    /**
     * @return
     * @dec:返回栈顶的fragment
     */
    private BaseFragment getTopFragment() {
        List<Fragment> list = getSupportFragmentManager().getFragments();
        if (list != null) {
            for (int i = list.size() - 1; i >= 0; i--) {
                Fragment fragment = list.get(i);
                if (fragment instanceof BaseFragment) {
                    return (BaseFragment) fragment;
                }
            }
        }
        return null;
    }

}
