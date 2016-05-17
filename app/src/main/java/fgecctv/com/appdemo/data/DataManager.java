package fgecctv.com.appdemo.data;


import android.content.Context;

import fgecctv.com.appdemo.data.local.DatabaseHelper;
import fgecctv.com.appdemo.data.local.PreferencesHelper;
import fgecctv.com.appdemo.data.model.bean.Weather;
import fgecctv.com.appdemo.data.model.pojo.WeatherDataBean;
import fgecctv.com.appdemo.data.remote.APIService;
import fgecctv.com.appdemo.data.remote.RetrofitService;
import rx.Observable;
import rx.functions.Func1;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data
 * @Description: 单例（数据供应商）
 * @date 2016/5/5 10
 */
public class DataManager {

    private static DataManager mDataManager;
    private static APIService mApiService;
    private static PreferencesHelper mSpHelper;
    private static DatabaseHelper mDbHelper;

    private DataManager(Context context) {
        mApiService = RetrofitService.getApiService(context);
        mSpHelper = PreferencesHelper.getInstance(context);
        mDbHelper = DatabaseHelper.getInstance();
    }

    public static DataManager getInstance(Context context) {
        if (mDataManager == null) {
            synchronized (DataManager.class) {
                if (mDataManager == null) {
                    mDataManager = new DataManager(context);
                }
            }
        }
        return mDataManager;
    }

    public Observable<Weather> getWeather(String city) {
        return mApiService.getWeatherByCity(city).map(new Func1<WeatherDataBean, Weather>() {
            @Override
            public Weather call(WeatherDataBean weatherDataBean) {
                Weather weather = new Weather();
                weather.setCity(weatherDataBean.getRetData().getCity());
                weather.setH_tmp(weatherDataBean.getRetData().getH_tmp());
                weather.setL_tmp(weatherDataBean.getRetData().getL_tmp());
                weather.setTemp(weatherDataBean.getRetData().getTemp());
                weather.setWeather(weatherDataBean.getRetData().getWeather());
                // TODO: 2016/5/17  是否需要存储数据库
                return weather;
            }
        });
    }

}
