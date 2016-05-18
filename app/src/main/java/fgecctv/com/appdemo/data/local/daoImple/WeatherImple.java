package fgecctv.com.appdemo.data.local.daoImple;

import fgecctv.com.appdemo.data.local.dao.WeatherDao;
import fgecctv.com.appdemo.data.model.bean.Weather;
import io.realm.Realm;
import rx.Observable;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local.daoImple
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 14
 */
public class WeatherImple implements WeatherDao {


    private static WeatherImple weatherImple;

    private WeatherImple() {
    }

    public static WeatherImple getWeatherImple() {
        if (weatherImple == null) {
            synchronized (WeatherImple.class) {
                if (weatherImple == null) {
                    weatherImple = new WeatherImple();
                }
            }
        }
        return weatherImple;
    }

    @Override
    public Observable<Weather> find(Realm realm) {
        realm.beginTransaction();
        Observable<Weather> observable = realm.where(Weather.class).findFirst().asObservable();
        realm.commitTransaction();
        return observable;
    }

    @Override
    public void update(Realm realm, Weather weather) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(weather);
        realm.commitTransaction();
    }
}
