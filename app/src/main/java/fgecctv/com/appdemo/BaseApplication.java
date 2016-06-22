package fgecctv.com.appdemo;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.io.InputStream;

import fgecctv.com.appdemo.model.DataManager;
import fgecctv.com.appdemo.model.remote.OkHttpHelper;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/5 15
 */
public class BaseApplication extends Application {

    private DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initDatabase();
        initGlide();
        initDataManager();
    }

    /**
     * 实例化全局的数据对象
     */
    private void initDataManager() {
        mDataManager = DataManager.getInstance(getApplicationContext());
    }

    /**
     * 初始化数据库
     */
    private void initDatabase() {
        FlowManager.init(this);
    }

    /**
     * 初始化glide
     */
    private void initGlide() {
        Glide.get(this).register(GlideUrl.class,InputStream.class,new OkHttpUrlLoader.Factory(OkHttpHelper.createClient(getApplicationContext())));
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

}
