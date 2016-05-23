package fgecctv.com.appdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.BaseFragment;
import fgecctv.com.appdemo.base.BasePresent;
import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.mvp.contract.HomeContract;
import fgecctv.com.appdemo.ui.mvp.presenter.HomePresenter;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/22 15
 */
public class HomeFragment extends BaseFragment implements HomeContract.View{
    @Override
    protected BasePresent getPresent() {
        return new HomePresenter(DataManager.getInstance(mActivity),this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
