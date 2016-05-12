package fgecctv.com.appdemo;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/5 15
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    /**
     * 初始化Realm数据库
     */
    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
