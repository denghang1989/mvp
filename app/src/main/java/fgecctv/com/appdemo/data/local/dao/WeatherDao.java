package fgecctv.com.appdemo.data.local.dao;

import fgecctv.com.appdemo.data.model.bean.Weather;
import io.realm.Realm;
import rx.Observable;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.local.dao
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/17 14
 */
public interface WeatherDao {
    Observable<Weather> find(Realm realm);
    void update(Realm realm,Weather weather);
}
