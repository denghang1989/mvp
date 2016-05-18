package fgecctv.com.appdemo;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;

import java.io.InputStream;

import fgecctv.com.appdemo.data.remote.OkHttpHelper;
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
        initGlide();
    }

    /**
     * 初始化glide数据库
     */
    private void initGlide() {
        Glide.get(this).register(GlideUrl.class,InputStream.class,new OkHttpUrlLoader.Factory(OkHttpHelper.createClient(getApplicationContext())));
    }

    /**
     * 初始化Realm数据库
     */
    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
