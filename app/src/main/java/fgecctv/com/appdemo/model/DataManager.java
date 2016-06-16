package fgecctv.com.appdemo.model;


import android.content.Context;

import com.google.common.base.Objects;
import com.google.gson.Gson;

import fgecctv.com.appdemo.config.APPConfig;
import fgecctv.com.appdemo.model.local.DatabaseHelper;
import fgecctv.com.appdemo.model.local.PreferencesHelper;
import fgecctv.com.appdemo.model.data.entity.User;
import fgecctv.com.appdemo.model.data.pojo.LoginResponse;
import fgecctv.com.appdemo.model.data.pojo.Weather;
import fgecctv.com.appdemo.model.data.pojo.WeatherDataBean;
import fgecctv.com.appdemo.model.remote.APIService;
import fgecctv.com.appdemo.model.remote.Results;
import fgecctv.com.appdemo.model.remote.RetrofitService;
import retrofit2.adapter.rxjava.Result;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author denghang
 * @version V1.0
 * @Description:
 * @date 2016/5/5 10
 */
public class DataManager {

    private static DataManager       mDataManager;
    private static APIService        mApiService;
    private static PreferencesHelper mSpHelper;
    private static DatabaseHelper    mDbHelper;

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
        return mApiService.getWeatherByCity(city).
                filter(Results.isSuccess()).
                map(new Func1<Result<WeatherDataBean>, WeatherDataBean>() {
                    @Override
                    public WeatherDataBean call(Result<WeatherDataBean> weatherDataBeanResult) {
                        return weatherDataBeanResult.response().body();
                    }
                }).
                map(new Func1<WeatherDataBean, Weather>() {
                    @Override
                    public Weather call(WeatherDataBean weatherDataBean) {
                        Weather weather = new Weather();
                        weather.setCity(weatherDataBean.getRetData().getCity());
                        weather.setH_tmp(weatherDataBean.getRetData().getH_tmp());
                        weather.setL_tmp(weatherDataBean.getRetData().getL_tmp());
                        weather.setTemp(weatherDataBean.getRetData().getTemp());
                        weather.setWeather(weatherDataBean.getRetData().getWeather());
                        return weather;
                    }
                }).doOnNext(new Action1<Weather>() {
            @Override
            public void call(Weather weather) {
                mSpHelper.put(APPConfig.WEATHER, new Gson().toJson(weather));
            }
        });
    }

    public Observable<User> getUserInfo() {
        return null;
    }

    public Observable<LoginResponse> login(String id, String passward) {
        return mApiService.login(id, passward).
                filter(Results.isSuccess()).
                map(new Func1<Result<LoginResponse>, LoginResponse>() {
                    @Override
                    public LoginResponse call(Result<LoginResponse> loginResponseResult) {
                        return loginResponseResult.response().body();
                    }
                });
    }

    public Observable<User> findAllUser() {
        return mDbHelper.findAllUser().filter(new Func1<User, Boolean>() {
            @Override
            public Boolean call(User user) {
                return Objects.equal(user.name,"haha");
            }
        });
    }

}
