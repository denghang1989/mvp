package fgecctv.com.appdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
<<<<<<< edbca1c045f90933b5184c0cb34c737318cb6dc3
=======
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
>>>>>>> 备份

import com.zhy.autolayout.AutoLayoutActivity;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.base
 * @Description: (使用hongyang的百分比布局, 需要继承AutoLayoutActivity)
 * @date 2016/5/10 22
 */
public class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< edbca1c045f90933b5184c0cb34c737318cb6dc3
<<<<<<< 04d46aaf230b1537ed4472b7c02b114e42f33f16

=======
>>>>>>> 谁便写点东西
=======
        setContentView(getContentViewId());
    }

    /*根布局*/
    protected abstract int getContentViewId();

    /*布局中FrameLayout的Id*/
    protected abstract int getFragmentContentId();

    /*添加Fragment*/
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(getFragmentContentId(),fragment,fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();
    }

    /*移除栈顶Fragment*/
    public void removeFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
>>>>>>> 备份
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
