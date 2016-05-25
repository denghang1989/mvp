package fgecctv.com.appdemo.data;


import android.content.Context;

import com.google.gson.Gson;

import fgecctv.com.appdemo.config.SPConfig;
import fgecctv.com.appdemo.data.local.DatabaseHelper;
import fgecctv.com.appdemo.data.local.PreferencesHelper;
import fgecctv.com.appdemo.data.model.bean.User;
import fgecctv.com.appdemo.data.model.bean.Weather;
import fgecctv.com.appdemo.data.model.pojo.LoginResponse;
import fgecctv.com.appdemo.data.model.pojo.WeatherDataBean;
import fgecctv.com.appdemo.data.remote.APIService;
import fgecctv.com.appdemo.data.remote.RetrofitService;
import io.realm.Realm;
import rx.Observable;
import rx.functions.Action1;
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

    private DataManager(Context context,Realm realm) {
        mApiService = RetrofitService.getApiService(context);
        mSpHelper = PreferencesHelper.getInstance(context);
        mDbHelper = DatabaseHelper.getInstance(realm);
    }

    public static DataManager getInstance(Context context,Realm realm) {
        if (mDataManager == null) {
            synchronized (DataManager.class) {
                if (mDataManager == null) {
                    mDataManager = new DataManager(context,realm);
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
                return weather;
            }
        }).doOnNext(new Action1<Weather>() {
            @Override
            public void call(Weather weather) {
                mSpHelper.put(SPConfig.WEATHER,new Gson().toJson(weather));
            }
        });
    }
    
    public Observable<User> getUserInfo() {
        return mDbHelper.getUserInfo().map(new Func1<User, User>() {
            @Override
            public User call(User user) {
                // TODO: 2016/5/25
                return user!=null?user:null;
            }
        });
    }

    public Observable<LoginResponse> login(String id,String passward) {
        return mApiService.login(id,passward).doOnNext(new Action1<LoginResponse>() {
            @Override
            public void call(LoginResponse loginResponse) {
                mDbHelper.saveUserInfo(loginResponse.getUser());
            }
        });
    }

    public Observable<User> getUserInfor() {
        return null;
    }

}
