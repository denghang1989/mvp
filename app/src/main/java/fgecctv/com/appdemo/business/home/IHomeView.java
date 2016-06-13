package fgecctv.com.appdemo.business.home;

import fgecctv.com.appdemo.base.libpresenter.IView;
import fgecctv.com.appdemo.model.data.pojo.Weather;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.business.home
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/6/13 17
 */
public interface IHomeView extends IView{
    void showProgress();
    void hideProgress();
    void showWeather(Weather weather);
}
