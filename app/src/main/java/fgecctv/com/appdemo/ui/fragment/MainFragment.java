package fgecctv.com.appdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.BaseFragment;
import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.mvp.contract.MainContract;
import fgecctv.com.appdemo.ui.mvp.presenter.MainPresenter;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 15
 */
public class MainFragment extends BaseFragment implements MainContract.View, View.OnClickListener {

    private static final String TAG = "MainFragment";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(DataManager.getInstance(mActivity, mRealm), this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void showView(int State) {
        getLoadingPager().refreshUIByState(State);
    }

    @Override
    public String getCity() {
        return "beijing";
    }

    @Override
    public void showTemp(String temp) {
        ((TextView)getSuccessView().findViewById(R.id.textView_temp)).setText(temp);
    }

    @Override
    public void showPm25(String pm25) {
        ((TextView)getSuccessView().findViewById(R.id.textView_pm25)).setText(pm25);
    }

    @Override
    public void showWeatherIcon(String icon) {
    }

    @Override
    public void showHumidity(String humidity) {
        ((TextView)getSuccessView().findViewById(R.id.textView_humidity)).setText(humidity);
    }

    @Override
    public void onClick(View v) {
        getHoldingActivity().addFragment(HomeFragment.newInstance());
    }
}
