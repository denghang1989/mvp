package fgecctv.com.appdemo.data;


import android.content.Context;

import fgecctv.com.appdemo.data.local.PreferencesHelper;
import fgecctv.com.appdemo.data.remote.APIService;
import fgecctv.com.appdemo.data.remote.RetrofitService;

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

    private DataManager(Context context) {
        mApiService = RetrofitService.getApiService(context);
        mSpHelper = PreferencesHelper.getInstance(context);
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



}
