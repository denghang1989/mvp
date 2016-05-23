package fgecctv.com.appdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fgecctv.com.appdemo.R;
import fgecctv.com.appdemo.base.BaseFragment;
import fgecctv.com.appdemo.data.DataManager;
import fgecctv.com.appdemo.ui.mvp.contract.MainContract;
import fgecctv.com.appdemo.ui.mvp.presenter.MainPresenter;
import fgecctv.com.appdemo.utils.WeatherUtils;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.fragment
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 15
 */
public class MainFragment extends BaseFragment implements MainContract.View {

    private TextView  mHumidity;
    private TextView  mPm25;
    private TextView  mTemp;
    private ImageView mIcon;

    private static final String TAG = "MainFragment";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHumidity = (TextView) view.findViewById(R.id.textView_humidity);
        mPm25 = (TextView) view.findViewById(R.id.textView_pm25);
        mTemp = (TextView) view.findViewById(R.id.textView_temp);
        mIcon = (ImageView) view.findViewById(R.id.imageView_icon);
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(DataManager.getInstance(getHoldingActivity()), this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public String getCity() {
        return "beijing";
    }

    @Override
    public void showTemp(String temp) {
        mTemp.setText(temp);
    }

    @Override
    public void showPm25(String pm25) {
        mPm25.setText(pm25);
    }

    @Override
    public void showWeatherIcon(String icon) {
        mIcon.setImageResource(WeatherUtils.changeString2Icon(icon));
    }

    @Override
    public void showHumidity(String humidity) {
        mHumidity.setText(humidity);
    }

}
