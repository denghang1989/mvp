package fgecctv.com.appdemo.ui.mvp.contract;

import fgecctv.com.appdemo.base.BasePresent;
import fgecctv.com.appdemo.base.BaseView;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.ui.mvp.contract
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 15
 */
public interface MainContract {
    interface View extends BaseView<Presenter> {
        String getCity();
        void showTemp(String temp);
        void showPm25(String pm25);
        void showWeatherIcon(String icon);
        void showHumidity(String humidity);
    }

    interface Presenter extends BasePresent {
        void loadData(boolean load);
    }

}
