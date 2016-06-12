package fgecctv.com.appdemo.data.remote;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author denghang
 * @version V1.0
 * @Package fgecctv.com.appdemo.data.remote
 * @Description: (用一句话描述该文件做什么)
 * @date 2016/5/5 11
 */
public class RetrofitService {

    private static final String BASE_URL = "http://120.24.181.136/cloud/";
    private static APIService apiService;

    private static Retrofit createRetrofit(Context context) {
        Gson gson = new GsonBuilder().
                setDateFormat("yyyy-MM-dd HH:mm:ss").
                create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpHelper.createClient(context))
                .build();
    }

    public static APIService getApiService(Context context) {
        if (apiService == null) {
            synchronized (RetrofitService.class) {
                if (apiService == null) {
                    apiService = createRetrofit(context).create(APIService.class);
                }
            }
        }
        return apiService;
    }

}
